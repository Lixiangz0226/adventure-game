
import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Monsters.Goblin;
import entities.stat_entities.Weapons.Flame_Crossbow;
import entities.stat_entities.Weapons.Knife;
import entities.stat_entities.Weapons.Spear;
import entities.stat_entities.Weapons.Staff;
import entities.stat_entities.Player;

import controller.EventController.*;
import controller.GamePanel;

import java.io.IOException;

public class TestBattle {
    public static void main(String[] args) throws IOException {
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

//        BattleEvent battle = new BattleEvent(player, new Bat());
        BattleEvent battle = new BattleEvent(player, new Goblin(), new GamePanel());

        battle.getWindow().setVisible(true);

        battle.runEvent();
    }
}
