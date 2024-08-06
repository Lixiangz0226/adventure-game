package OutsideEntities;//package OutsideEntities;
//
//
//import OutsideEntities.Items.Life_Potion;
//import OutsideEntities.Monsters.Bat;
//import OutsideEntities.Monsters.Goblin;
//import OutsideEntities.Weapons.Flame_Crossbow;
//import OutsideEntities.Weapons.Knife;
//import controller.EventHandler.BattleEvent;
//import controller.EventHandler.ShopEvent0;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Map0 extends Map {
//
//    private JTextArea mainTextArea;
//    private JButton c1; JButton c2; JButton c3; JButton c4;
//    private Player player;
//    private Container con;
//    Room startRoom, playerRoom, boss, desert, shop, forest, forestmiddle, forestleft, forestright, hallway;
//
//    public Map0(Container con, Player player, JTextArea mainTextArea) {
//        /* An example map */
//        Room Boss = new Room("Boss", "This is the boss room", new BattleEvent(player, new Bat()), player,con);
//        Room hallway = new Room("Hallway", "It's a long path", new ShopEvent(player),
//                player,con);
//        Room startRoom = new Room("Start", "We started here", new ShopEvent(player), player, con);
//        Room shop = new Room("Shop", "There's a business man called Frank.", new ShopEvent0(player), player,con);
//        Room desert = new Room("Desert", "Desert", new BattleEvent(player, new Goblin()), player,con);
//        Room forest = new Room("Forest", "You are surrounded by trees.", new ShopEvent(player), player, con);
//        Room forestmiddle = new Room("Forest Centre", "It's hard to find the way out.", new ShopEvent(
//                player), player, con);
//        Room forestleft = new Room("Forest Left", "Dead end.", new BattleEvent(player, new Bat()), player,con);
//        Room forestright = new Room("Forest Right", "Dead end", new ShopEvent(player), player,con);
//        hallway.setN(Boss); hallway.setS(startRoom);
//        startRoom.setW(shop);startRoom.setE(desert);
//        forest.setN(startRoom); forest.setS(forestmiddle);
//        forestmiddle.setW(forestleft); forestmiddle.setE(forestright);
//
//        player.getInventory().addItem(new Flame_Crossbow());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Knife());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Flame_Crossbow());
//        player.getInventory().addItem(new Life_Potion());
//        player.getInventory().addItem(new Knife());
//        player.getInventory().addItem(new Life_Potion());
//
//
//        super(con, startRoom, player, mainTextArea);
//    }
//
//}
