package Tests;

import OutsideEntities.*;
import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Weapons.Flame_Crossbow;
import OutsideEntities.Weapons.Knife;
import OutsideEntities.Weapons.Spear;
import OutsideEntities.Weapons.Staff;
import controller.EventHandler.Battle_Event0;
import controller.EventHandler.CursedTree_Event;
import controller.EventHandler.Queen_Slime_Event;
import controller.EventHandler.ShopEvent0;

import java.awt.Container;
import java.awt.Font;

import javax.swing.*;

//Tests the functionality of the battle or shop event in rooms
public class Test_Event {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;
    ShopEvent0 shop;

    public static void main(String[] args) {
        new Test_Event();
    }

    //Creates the event screen
    public Test_Event() {
        test_shop0();
//        test_battle();
//        test_Queen_Slime_event();
//        test_boss();
//        test_battle();
    }


    //Simulates a shop event with 99999 money
    public void test_shop0() {
        Player player = new Player("Vergil", 100);
        player.setMoney(50);
        ShopEvent0 shop = new ShopEvent0(player);
        shop.run_event();
        while (shop.shopOpened) {
            // Wait until shopOpened is false
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test_Queen_Slime_event(){
        Player player = new Player("Vergil", 25);
        Queen_Slime_Event queen = new Queen_Slime_Event(player, con, mainTextArea);
        queen.run_event();
    }


    //Simulates a battle event with weapons and potions
    public void test_battle(){
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

        Battle_Event0 battle = new Battle_Event0(player, con, mainTextArea);
        battle.run_event();
    }

    public void test_boss(){
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

        CursedTree_Event cursedTree = new CursedTree_Event(player, con, mainTextArea);
        cursedTree.run_event();

    }




}
