package OutsideEntities;

import Event_Tester_Package.Battle_Event0;
import Event_Tester_Package.Shop_Event0;
import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Weapons.Flame_Crossbow;
import OutsideEntities.Weapons.Knife;

import javax.swing.*;
import java.awt.*;

public class Map0 extends Map{

    private JTextArea mainTextArea;
    private JButton c1; JButton c2; JButton c3; JButton c4;
    private Player player;
    private Container con;
    Room startRoom, playerRoom, boss, desert, shop, forest, forestmiddle, forestleft, forestright, hallway;

    public Map0(Container con, Player player, JTextArea mainTextArea) {
        /* An example map */
        Room Boss = new Room("Boss", "This is the boss room", new Battle_Event0(player,con,mainTextArea), player,con);
        Room hallway = new Room("Hallway", "It's a long path", new Shop_Event0(player,con,mainTextArea),
                player,con);
        Room startRoom = new Room("Start", "We started here", new Shop_Event0(player, con,mainTextArea), player, con);
        Room shop = new Room("Shop", "There's a business man called Frank.", new Shop_Event0(player, con,mainTextArea), player,con);
        Room desert = new Room("Desert", "Desert", new Battle_Event0(player,con,mainTextArea), player,con);
        Room forest = new Room("Forest", "You are surrounded by trees.", new Shop_Event0(player,con,mainTextArea), player, con);
        Room forestmiddle = new Room("Forest Centre", "It's hard to find the way out.", new Shop_Event0(
                player, con,mainTextArea), player, con);
        Room forestleft = new Room("Forest Left", "Dead end.", new Battle_Event0(player,con,mainTextArea), player,con);
        Room forestright = new Room("Forest Right", "Dead end", new Shop_Event0(player, con,mainTextArea), player,con);
        hallway.setN(Boss); hallway.setS(startRoom);
        startRoom.setW(shop);startRoom.setE(desert);
        forest.setN(startRoom); forest.setS(forestmiddle);
        forestmiddle.setW(forestleft); forestmiddle.setE(forestright);

        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Life_Potion());


        super(con, startRoom, player, mainTextArea);
    }

}
