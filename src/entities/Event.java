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
    private String position;
    CHandler choiceHandler = new CHandler();


    public Battle_Event0(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                       Player player) {
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1; this.choice2 = choice2; this.choice3 = choice3;
        this.choice4 = choice4;
        this.player = player;
        this.monster = new Goblin();
        this.position = "";
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
        start();
    }

    private void start(){
        mainTextArea.setText("Suddenly, a goblin jumped out from nowhere!");

    }

    public static class CHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();


        }
    }
}
