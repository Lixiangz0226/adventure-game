import OutsideEntities.Items.*;
import OutsideEntities.Player;
import OutsideEntities.Weapons.*;
import controller.EventController.CursedTreeEvent;

public class TestCursedTree {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 300);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Spear());
        player.getInventory().addItem(new Battle_Axe());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());

        CursedTreeEvent cursedTree = new CursedTreeEvent(player);
        cursedTree.getWindow().setVisible(true);

        cursedTree.run_event();
    }
}
