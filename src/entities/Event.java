package entities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.math.*;

class Event{
    /*
      An event takes place in rooms, and can be
    encountered by Players.
    */
}

class Shop_Event0 extends Event{
    /**
     * One shop with three items on sell.
     */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;
    private String position;
    CHandler choiceHandler = new CHandler();

    public Shop_Event0(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                       Player player) {
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1; this.choice2 = choice2; this.choice3 = choice3;
        this.choice4 = choice4;
        this.player = player;
        this.position = "justarrived";
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
    }

    public void run_shop(){///////////////////////////////////////////////////////////////Joseph, run this event here!
        switch (position) {
            case "justarrived" -> justarrived();
            case "bought1" -> bought1();
            case "bought2" -> bought2();
            case "bought3" -> bought3();
            case "bought12" -> bought12();
            case "bought13" -> bought13();
            case "bought23" -> bought23();
            case null, default -> bought123();
        }
    }

    private void justarrived(){
        this.position = "justarrived";
        this.mainTextArea.setText("Frank: Welcome to my store! I wish I have something you want:\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("Buy flame crossbow");
        this.choice2.setText("Buy life potion");
        this.choice3.setText("Buy golden key");
        this.choice4.setText("Leave");
    }

    private void bought1(){
        this.position = "bought1";
        player.getInventory().addItem(new Flame_Crossbow());
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("-");
        this.choice2.setText("Buy life potion");
        this.choice3.setText("Buy golden key");
        this.choice4.setText("Leave");
    }

    private void bought2(){
        this.position = "bought2";
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("Buy flame crossbow");
        this.choice2.setText("_");
        this.choice3.setText("Buy golden key");
        this.choice4.setText("Leave");

    }

    private void bought3(){
        this.position = "bought3";
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("Buy flame crossbow");
        this.choice2.setText("Buy life potion");
        this.choice3.setText("-");
        this.choice4.setText("Leave");
    }

    private void bought12() {
        this.position = "bought12";
        player.getInventory().addItem(new Flame_Crossbow());
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("-");
        this.choice2.setText("-");
        this.choice3.setText("Buy golden key");
        this.choice4.setText("Leave");
    }

    private void bought13(){
        this.position = "bought13";
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                    "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("_");
        this.choice2.setText("Buy life potion");
        this.choice3.setText("-");
        this.choice4.setText("Leave");
    }

    private void bought23(){
        this.position = "bought23";
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("Buy flame crossbow");
        this.choice2.setText("_");
        this.choice3.setText("-");
        this.choice4.setText("Leave");
    }

    private void bought123(){
        this.position = "bought123";
        this.mainTextArea.setText("Thanks for your patronage!\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("_");
        this.choice2.setText("_");
        this.choice3.setText("-");
        this.choice4.setText("Leave");
    }

    private void rebuy(){
        this.mainTextArea.setText("You've already bought this one.\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
    }

    private void lackofmoney(){
        this.mainTextArea.setText("I'm afraid you don't have enough money.\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
    }

    public class CHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            if (yourChoice.equals("c4")) {
                return Room_shop();///////////////////////////////////////////Joseph, it turns back to room class here
            }

            switch(position){
                case "justarrived":
                    switch (yourChoice){
                        case "c1":
                            if (player.getMoney() < 40){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Flame_Crossbow());
                            player.setMoney(player.getMoney() - 40);
                            bought1();break;
                        case "c2":
                            if (player.getMoney() < 15){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Life_Potion());
                            player.setMoney(player.getMoney() - 15);
                            bought2();break;
                        case "c3":
                            if (player.getMoney() < 30){
                                lackofmoney();break;
                            }
                            player.add_key();
                            player.setMoney(player.getMoney() - 30);
                            bought3();break;
                    }
                case "bought1":
                    switch (yourChoice){
                        case "c1": rebuy();break;
                        case "c2":
                            if (player.getMoney() < 15){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Life_Potion());
                            player.setMoney(player.getMoney() - 15);
                            bought12();break;
                        case "c3":
                            if (player.getMoney() < 30){
                                lackofmoney();break;
                            }
                            player.add_key();
                            player.setMoney(player.getMoney() - 30);
                            bought13();break;
                    }
                case "bought2":
                    switch (yourChoice){
                        case "c1":
                            if (player.getMoney() < 40){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Flame_Crossbow());
                            player.setMoney(player.getMoney() - 40);
                            bought12();break;
                        case "c2": rebuy();break;
                        case "c3":
                            if (player.getMoney() < 30){
                                lackofmoney();break;
                            }
                            player.add_key();
                            player.setMoney(player.getMoney() - 30);
                            bought23();break;
                    }
                case "bought3":
                    switch (yourChoice){
                        case "c1":
                            if (player.getMoney() < 40){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Flame_Crossbow());
                            player.setMoney(player.getMoney() - 40);
                            bought13();break;
                        case "c2":
                            if (player.getMoney() < 15){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Life_Potion());
                            player.setMoney(player.getMoney() - 15);
                            bought23();break;
                        case "c3": rebuy();break;
                    }
                case "bought12":
                    switch (yourChoice){
                        case "c1", "c2": rebuy(); break;
                        case "c3":
                            if (player.getMoney() < 30){
                                lackofmoney();break;
                            }
                            player.add_key();
                            player.setMoney(player.getMoney() - 30);
                            bought123();break;
                    }
                case "bought13":
                    switch (yourChoice){
                        case "c1", "c3": rebuy();break;
                        case "c2":
                            if (player.getMoney() < 15){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Life_Potion());
                            player.setMoney(player.getMoney() - 15);
                            bought123();break;
                    }
                case "bought23":
                    switch (yourChoice){
                        case "c2", "c3": rebuy();break;
                        case "c1":
                            if (player.getMoney() < 40){
                                lackofmoney();break;
                            }
                            player.getInventory().addItem(new Flame_Crossbow());
                            player.setMoney(player.getMoney() - 40);
                            bought123();break;
                    }
                case "bought123":rebuy();break;
            }
        }
    }
}

class Battle_Event0 extends Event{
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;
    private Monster monster;
    private static String position;
    private boolean firsttime;
    private int m; private int current, used1, used2, used3;
    JLabel hpLabel; JLabel enemyhp; JPanel backPanel;

    cHandler choiceHandler = new cHandler();
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    int index = 0;

    public Battle_Event0(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                       Player player, Container con) {
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1; this.choice2 = choice2; this.choice3 = choice3;
        this.choice4 = choice4;
        this.player = player;
        this.monster = new Goblin();
        this.position = "";
        this.firsttime = true;
        this.used1 = player.getSkills().get(0).getTimes(); this.used2 = player.getSkills().get(1).getTimes();
        this.used3 = player.getSkills().get(2).getTimes();
        this.m = player.getInventory().get_length() / 2;
        this.current = 0;

        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        JPanel playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        JLabel hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        JLabel hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        hpLabelNumber.setText("" + player.getHealth());
        playerPanel.add(hpLabelNumber);
        JLabel enemylabel = new JLabel(monster.getName() + " HP:");
        enemylabel.setFont(normalFont);
        enemylabel.setForeground(Color.white);
        enemylabel.setBackground(Color.red);
        playerPanel.add(enemylabel);
        JLabel enemyhp = new JLabel();
        enemyhp.setFont(normalFont);
        enemyhp.setForeground(Color.white);
        enemyhp.setText("" + monster.getHealth());
        playerPanel.add(enemyhp);

        JPanel backPanel = new JPanel();
        backPanel.setBounds(100, 500, 100, 50);
        backPanel.setBackground(Color.black);
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFont(normalFont);
        backButton.setFocusPainted(false);
        backButton.addActionListener(choiceHandler);
        backButton.setActionCommand("c5");
        backPanel.add(backButton);
        con.add(backPanel);
        backPanel.setVisible(false);
    }

    public void run_battle_event(){/////////////////////////////////////////////////////////////////////////////////////
        if(firsttime){start();}
        else {finished();}
    }

    private void start(){
        position = "start";
        mainTextArea.setText("Suddenly, a goblin leaped out from nowhere!");
        choice1.setText("Attack");
        choice2.setText("Items");
        choice3.setText("-");
        choice4.setText("Run");
    }

    private void items(){
        position = "items";
        mainTextArea.setText("Choose the item you wanna use:");
        choice1.setText(player.getInventory().getItem(current).get_name());
        if (player.getInventory().get_length() % 2 == 1){
            if (current < 2 * m){choice2.setText(player.getInventory().getItem(current + 1).get_name());}
            else {choice2.setText("-");}
        }
        else{choice2.setText(player.getInventory().getItem(current + 1).get_name());}
        choice3.setText("Previous Page");
        choice4.setText("Next Page");
    }

    private void top_items(){
        mainTextArea.setText("You are already at the top of your inventory.\nChoose the item you wanna use:");
    }

    private void bot_items(){
        mainTextArea.setText("You are already at the bottom of your inventory.\nChoose the item you wanna use:");
    }

    private void attack(){
        position = "attack";
        mainTextArea.setText("Put it in action!");
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    private void finished(){
        firsttime = false;
        position = "finished";
        mainTextArea.setText("The goblin you defeated never moved again");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public class cHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch(position){
                case "start":
                    switch(yourChoice){
                        case "c1":
                            backPanel.setVisible(true);
                            attack(); break;
                        case "c2":
                            backPanel.setVisible(true);
                            items(); break;
                        case "c4": //////////////////////////////////////////////////////////////////////////////Runaway
                    }
                case "items":
                    switch(yourChoice){
                        case "c1":
                        case "c2":
                        case "c3":
                            if (current - 2 < 0){
                                top_items(); break;
                            }
                            else{
                                current -= 2;
                                items(); break;
                            }
                        case "c4":
                            if (player.getInventory().get_length() % 2 == 1){
                                if (current + 2 > 2 * m){bot_items(); break;}
                                else {current += 2; items(); break;}
                            }
                            else {
                                if (current + 2 >= 2 * m){bot_items(); break;}
                                else {current += 2; items(); break;}
                            }

                        case "c5": backPanel.setVisible(false); start(); break;
                    }
                case "attack":
                case "finished":
            }
        }
    }
}
