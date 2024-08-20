//
//import entities.stat_entities.Items.Life_Potion;
//import entities.stat_entities.Weapons.Battle_Axe;
//import entities.stat_entities.Weapons.Flame_Crossbow;
//import entities.stat_entities.Weapons.Spear;
//import entities.stat_entities.Player;
//
//import controller.EventController.CursedTreeEvent;
//import controller.GamePanel;
//
//import java.io.IOException;
//
//public class TestCursedTree {
//    public static void main(String[] args) throws IOException {
//        Player player = new Player("Vergil", 300);
//        player.getInventory().addItem(new Flame_Crossbow());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Spear());
//        player.getInventory().addItem(new Battle_Axe());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Life_Potion());
//
//        CursedTreeEvent cursedTree = new CursedTreeEvent(player, new GamePanel());
//        cursedTree.getWindow().setVisible(true);
//
//        cursedTree.runEvent();
//    }
//}
