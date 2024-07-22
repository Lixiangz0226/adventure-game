package TextGame.entities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game{

    //Game attributes
    Container con;
    JPanel newButtonPanel;JButton newButton;
    JPanel loadButtonPanel;JButton loadButton;
    JPanel titleNamePanel; JLabel titleNameLabel;
    JFrame window;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    JPanel mainTextPanel;JTextArea mainTextArea;
    JPanel choiceButtonPanel;
    JButton choice1;JButton choice2;JButton choice3;JButton choice4;
    ActionListener choiceHandler;



    //Exception test for UIManager
    public static void main(String[] args) {
        try {
            UIManager UIManager = null;
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Game();
    }

    //Game constructor
    public Game(){

        //The Main Manu
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        //window.setIconImage(logo.getImage());
        con = window.getContentPane();

        //Title
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        newButtonPanel = new JPanel();
        newButtonPanel.setBounds(300, 300, 200, 100);
        newButtonPanel.setBackground(Color.black);

        //Button to start a new game
        newButton = new JButton("NEW");
        newButton.setBackground(Color.black);
        newButton.setForeground(Color.white);
        newButton.setFont(normalFont);
        newButton.setFocusPainted(false);
        newButton.addActionListener(tsHandler);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(300, 400, 200, 100);
        loadButtonPanel.setBackground(Color.black);

        //Button to load a previous game (not implemented yet)
        loadButton = new JButton("LOAD");
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.setFont(normalFont);
        loadButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        newButtonPanel.add(newButton);
        loadButtonPanel.add(loadButton);

        con.add(titleNamePanel);
        con.add(newButtonPanel);
        con.add(loadButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen(){

        //Creates a new game
        titleNamePanel.setVisible(false);
        newButtonPanel.setVisible(false);
        loadButtonPanel.setVisible(false);

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

        //Created player and gives items
        Player player = new Player("Vergil", 50);

        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());

        //Creates the map of the game
        Map map = new Map0(con,player,mainTextArea);

        map.displayMap();
    }

    //Handles the action of clicking the new button in the main screen
    public class TitleScreenHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    //Class to test the functionality of the map
    public static class Test_Map {

        public static void main(String[] args) {
            Player p = new Player("Vergil", 500);
            Container con = new Container();
            JTextArea mainTextArea = new JTextArea();
            Map m = new Map0(con, p, mainTextArea);

            System.out.println(m.get_playerroom().getName());
            System.out.println(m.get_playerroom().getN().getName());
            System.out.println(m.get_playerroom().getS().getName());
            System.out.println(m.get_playerroom().getE().getName());
            System.out.println(m.get_playerroom().getW().getName());
            System.out.println(m.get_playerroom().getN().getN().getName());
            System.out.println(m.get_playerroom().getS().getS().getE().getName());
        }
    }

    //Class to test the functionality of the battle or shop event in rooms
    public static class Test_Event {

        //Test event attributes
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

        //Creates the screen for the events
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
            //        test_battle(con);
            test_shop0(con);
        }

        //Simulation of a shop event with 99999 money
        public void test_shop0(Container con){
            Player player = new Player("Vergil", 100);
            player.setMoney(99999);
            Shop_Event0 shop = new Shop_Event0(player,con, mainTextArea);
            shop.run_event();
        }

        //Simulation of a battle event with weapons and potions
        public void test_battle(Container con){
            Player player = new Player("Vergil", 500);
            player.getInventory().addItem(new Flame_Crossbow());
            player.getInventory().addItem(new Life_Potion());
            player.getInventory().addItem(new Knife());
            player.getInventory().addItem(new Knife());
            player.getInventory().addItem(new Life_Potion());

            Battle_Event0 battle = new Battle_Event0(player, con, mainTextArea);
            battle.run_event();
        }
    }
}
