package TextGame.entities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game {

    Container con;
    JPanel newButtonPanel;
    JButton newButton;
    JPanel loadButtonPanel;
    JButton loadButton;
    JPanel titleNamePanel;
    JLabel titleNameLabel;
    JFrame window;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    JPanel mainTextPanel;
    JTextArea mainTextArea;
    JPanel choiceButtonPanel;
    JButton choice1;
    JButton choice2;
    JButton choice3;
    JButton choice4;
    ActionListener choiceHandler;


    public static void main(String[] args) {
        try {
            UIManager UIManager = null;
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Game();
    }

    public Game() {

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

    public void createGameScreen() {

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

        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());

        Map map = new Map0(con, player, mainTextArea);

        map.displayMap();
    }

    public class TitleScreenHandler implements ActionListener {
        /*This handles the action of clicking the new button in the main screen*/

        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }
}
