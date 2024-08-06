package Tests;

import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Monsters.Bat;
import OutsideEntities.Player;
import OutsideEntities.Weapons.Flame_Crossbow;
import OutsideEntities.Weapons.Knife;
import OutsideEntities.Weapons.Spear;
import OutsideEntities.Weapons.Staff;
import controller.EventController.BattleEvent;

public class TestBattle {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 10);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Spear());
        player.getInventory().addItem(new Staff());

        BattleEvent battle = new BattleEvent(player, new Bat());
        battle.run_event();
    }
}
