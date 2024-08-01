package Event_Tester_Package;

import OutsideEntities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Queen_Slime_Event extends Event {
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;
    private Container con;
    private JPanel choiceButtonPanel;
    CHandler cHandler = new CHandler();
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    private String position;



    public Queen_Slime_Event(Player player, Container con, JTextArea mainTextArea){
        /*
        Queen event
         */

        this.con = con;

        this.mainTextArea = mainTextArea;

        this.choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        this.position = "start";

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.setActionCommand("c1qs");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.setActionCommand("c2qs");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.setActionCommand("c3qs");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.setActionCommand("c4qs");
        choiceButtonPanel.add(choice4);
        this.player = player;
        choice1.addActionListener(cHandler);
        choice2.addActionListener(cHandler);
        choice3.addActionListener(cHandler);
        choice4.addActionListener(cHandler);

        choiceButtonPanel.setVisible(false);
    }

    public void run_event(){
        choiceButtonPanel.setVisible(true);
        switch (position){
            case "start":
                start();
                break;
            case "killed":
                killed();
                break;
            case "saved":
                saved();
                break;
        }
    }

    private void start() {
        position = "start";
        mainTextArea.setText("The Queen slime was heavily injured, do you want to help her?");
        choice1.setText("Help her");
        choice2.setText("Kill her");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    private void saved(){
        position = "saved";
        mainTextArea.setText("You helped the Queen, and she rewards you with a golden key");
        choice1.setText("Leave the Queen");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    private void killed(){
        position = "killed";
        mainTextArea.setText("You killed the Queen, and she dropped 200 Golds.");
        choice1.setText("Leave the Queen");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public class CHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch (position){
                case "start":
                    switch (yourChoice){
                        case "c1qs":
                            player.add_key();
                            saved();break;
                        case "c2qs":
                            player.setMoney(player.getMoney() + 200);
                            killed();break;
                        case "c3qs":
                            break;/////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "saved", "killed":
                    if (Objects.equals(yourChoice, "c1qs")){
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }
                    break;

            }

        }
    }
}
