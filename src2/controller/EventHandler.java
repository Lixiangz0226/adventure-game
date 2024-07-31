package controller;

import java.awt.Container;
import java.awt.Font;

import javax.swing.*;

//Tests the functionality of the battle or shop event in rooms
public class EventHandler {

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


    //Creates the event screen
    public EventHandler() {

    }


    public static void runEvent() {

    }
}
