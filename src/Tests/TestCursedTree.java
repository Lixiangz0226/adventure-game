package Tests;

import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Player;
import OutsideEntities.Weapons.Flame_Crossbow;
import controller.EventController.CursedTreeEvent;

public class TestCursedTree {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 300);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());

        CursedTreeEvent cursedTree = new CursedTreeEvent(player);
        cursedTree.run_event();
    }
}
