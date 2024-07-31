package Event_Tester_Package;

import OutsideEntities.Flame_Crossbow;
import OutsideEntities.Knife;
import OutsideEntities.Life_Potion;
import OutsideEntities.PlayerController;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

        try {
            UIManager UIManager = null;
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        JPanel mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);

        con.add(mainTextPanel);
        this.mainTextArea = new JTextArea("Fix this bug!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        window.setVisible(true);
        test_shop0(con);
    }


    //Simulates a shop event with 99999 money
    public void test_shop0(Container con) {
        PlayerController player = new PlayerController("Vergil", 100);
        player.setMoney(50);
        ShopEvent0 shop = new ShopEvent0(player, con, mainTextArea);
        shop.run_event();
        while (shop.shopOpened) {
            // Wait until shopOpened is false
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        window.setVisible(false);
    }


    //Simulates a battle event with weapons and potions
    public void test_battle(Container con){
        PlayerController player = new PlayerController("Vergil", 25);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());

        Battle_Event0 battle = new Battle_Event0(player, con, mainTextArea);
        battle.run_event();
    }




}