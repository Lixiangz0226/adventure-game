package Tests;

import entities.OutsideEntities.Items.Life_Potion;
import entities.OutsideEntities.Monsters.Bat;
import entities.OutsideEntities.Weapons.Flame_Crossbow;
import entities.OutsideEntities.Weapons.Knife;
import entities.OutsideEntities.Weapons.Spear;
import entities.OutsideEntities.Weapons.Staff;
import entities.Player;
import controller.EventController.*;

public class TestBattle {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Spear());
        player.getInventory().addItem(new Staff());

        BattleEvent battle = new BattleEvent(player, new Bat());
        battle.getWindow().setVisible(true);

        battle.run_event();
    }
}
