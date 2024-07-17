package entities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game{

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




    public static void main(String[] args) {
        new Game();
    }

    public Game(){

        /*
          The Main Manu
         */


        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        //window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        newButtonPanel = new JPanel();
        newButtonPanel.setBounds(300, 300, 200, 100);
        newButtonPanel.setBackground(Color.black);

        newButton = new JButton("NEW");
        newButton.setBackground(Color.black);
        newButton.setForeground(Color.white);
        newButton.setFont(normalFont);
        newButton.setFocusPainted(false);
        newButton.addActionListener(tsHandler);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(300, 400, 200, 100);
        loadButtonPanel.setBackground(Color.black);

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

        /*A new game*/

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

        Player player = new Player("Vergil", 50);

        Map map = new Map0(con,player,mainTextArea);

        map.displayMap();
    }

    public class TitleScreenHandler implements ActionListener{
        /*This handles the action of clicking the new button in the main screen*/

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }

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

    public static class Test_Event {

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

        public void test_shop0(Container con){
            Player player = new Player("Vergil", 100);
            player.setMoney(99999);
            Shop_Event0 shop = new Shop_Event0(player,con, mainTextArea);
            shop.run_event();
        }

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
