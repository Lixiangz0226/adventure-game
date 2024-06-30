package entities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
import javax.swing.ImageIcon;
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
        window.setSize(1200, 900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        //window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(300, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        newButtonPanel = new JPanel();
        newButtonPanel.setBounds(450, 400, 300, 100);
        newButtonPanel.setBackground(Color.black);

        newButton = new JButton("NEW");
        newButton.setBackground(Color.black);
        newButton.setForeground(Color.white);
        newButton.setFont(normalFont);
        newButton.setFocusPainted(false);
        newButton.addActionListener(tsHandler);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(450, 500, 300, 100);
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
        loadButtonPanel.setVisible(false);//Set all Panels in the Main Menu dissapeared.

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);//To make the text not across the frame but switch line automatically.
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(450, 600, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));//Buttons separated vertically.
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);// Remove the focus.
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);


    }

    public class TitleScreenHandler implements ActionListener{
        /*This handles the action of clicking the new button in the main screen*/

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }
}
