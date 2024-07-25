package TextGame.app;

import TextGame.entities.*;
import TextGame.view.Map;
import TextGame.view.Map0;

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
    JTextArea mainTextArea;


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
}
