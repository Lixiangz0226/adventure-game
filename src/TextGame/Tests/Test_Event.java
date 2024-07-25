package TextGame.Tests;

import TextGame.entities.Items.Life_Potion;
import TextGame.entities.Weapons.Flame_Crossbow;
import TextGame.entities.Weapons.Knife;
import TextGame.entities.Player;
import TextGame.use_case.Events.Battle_Event0;
import TextGame.use_case.Events.Shop_Event0;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


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

    public static void main(String[] args) {
        new Test_Event();
    }

    //Creates the event screen
    public Test_Event() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        window.setVisible(true);

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

        test_battle(con);
//        test_shop0(con);
    }
    
    //Simulates a shop event with 99999 money
    public void test_shop0(Container con){
        Player player = new Player("Vergil", 25);
        player.setMoney(50);
        Shop_Event0 shop = new Shop_Event0(player,con, mainTextArea);
        shop.run_event();
    }

    //Simulates a battle event with weapons and potions
    public void test_battle(Container con){
        Player player = new Player("Vergil", 100);
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
