package TextGame.entities;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Event{
    /*
      An event takes place in rooms, and can be
    encountered by Players.
    */
    public void run_event(){}
}

class Shop_Event0 extends Event{
    /**
     * One shop with three items on sell.
     */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;
    private String position;
    private Container con;
    private JPanel choiceButtonPanel;
    CHandler cHandler = new CHandler();
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    private boolean bought1 = false, bought2 = false, bought3 = false;
    private Item item1 = new Flame_Crossbow();
    private Item item2 = new Life_Potion();
    private Item item3 = new Golden_Key();


    public Shop_Event0(Player player, Container con, JTextArea mainTextArea) {/////////////////////////Create shop here
        /*
        Initializer of the event.
         */
        this.con = con;

        this.mainTextArea = mainTextArea;

        this.choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.setActionCommand("c1se");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.setActionCommand("c2se");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.setActionCommand("c3se");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.setActionCommand("c4se");
        choiceButtonPanel.add(choice4);
        this.con = con;
        this.player = player;
        choice1.addActionListener(cHandler);
        choice2.addActionListener(cHandler);
        choice3.addActionListener(cHandler);
        choice4.addActionListener(cHandler);

        choiceButtonPanel.setVisible(false);
    }

    public void run_event(){////////////////////////////////////////////////////////////////////////////////Run shop here
        /*
        Run this event with the buying history saved.
         */
        choiceButtonPanel.setVisible(true);
        shop();
    }

    private void shop(){
        /*
        The scene of the shop.
         */
        this.mainTextArea.setText("Frank: Welcome to my store! I wish I have something you want:\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
        this.choice1.setText("-");if (!bought1){choice1.setText("Buy " + item1.get_name());}
        this.choice2.setText("-");if (!bought2){choice2.setText("Buy " + item2.get_name());}
        this.choice3.setText("-");if (!bought3){choice3.setText("Buy " + item3.get_name());}
        this.choice4.setText("Leave");
    }

        private void rebuy(){
        /*
        The scene that notices the player which has already bought the item player has chosen.
         */
        this.mainTextArea.setText("You've already bought this one.\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
    }

    private void lackofmoney(){
        /*
        The scene that notices the player which is lack of money.
         */
        this.mainTextArea.setText("I'm afraid you don't have enough money.\n" +
                "Flame crossbow: 40$\nLife Potion: 15$\nGolden Key: 30$");
    }

    public class CHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            if (yourChoice.equals("c4se")) {
                choiceButtonPanel.setVisible(false);
                player.leave();
                return;}///////////////////////////////////////////////////////

            switch (yourChoice){
                case "c1se":
                    if (Objects.equals(choice1.getText(), "-")){rebuy();break;}
                    else if (player.getMoney() < 40){lackofmoney();break;}
                    player.getInventory().addItem(item1);
                    player.setMoney(player.getMoney() - 40);
                    bought1 = true;
                    shop();break;
                case "c2se":
                    if (Objects.equals(choice2.getText(), "-")){rebuy();break;}
                    else if (player.getMoney() < 15){lackofmoney();break;}
                    player.getInventory().addItem(item2);
                    player.setMoney(player.getMoney() - 15);
                    bought2 = true;
                    shop();break;
                case "c3se":
                    if (Objects.equals(choice3.getText(), "-")){rebuy();break;}
                    else if (player.getMoney() < 30){lackofmoney();break;}
                    player.add_key();
                    player.setMoney(player.getMoney() - 30);
                    bought3 = true;
                    shop();break;
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
    JLabel hpLabelNumber; JLabel enemyhp; JPanel backPanel;
    private List<Integer> dmg_result;
    private Container con;
    private JPanel choiceButtonPanel;
    private JPanel playerPanel;
    Basic_attack basic_attack = new Basic_attack();

    ChoiceHandler choiceHandler = new ChoiceHandler();
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    public Battle_Event0(Player player, Container con, JTextArea mainTextArea) {///////////////////////////////////////////////////////Create here
        /*
        Initializer of the event.
         */
        this.mainTextArea = mainTextArea;

        this.choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1be");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2be");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3be");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4be");
        choiceButtonPanel.add(choice4);

        this.player = player;
        this.monster = new Goblin();
        this.position = "";
        this.firsttime = true;
        this.used1 = player.getSkills().get(0).getTimes(); this.used2 = player.getSkills().get(1).getTimes();
        this.used3 = player.getSkills().get(2).getTimes();
        this.m = player.getInventory().get_length() / 2;
        this.current = 0;
        this.dmg_result = new ArrayList<Integer>();
        this.con = con;

        this.playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        JLabel hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        this.hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        hpLabelNumber.setText("" + player.getHealth());
        playerPanel.add(hpLabelNumber);
        JLabel enemylabel = new JLabel(monster.getName() + " HP:");
        enemylabel.setFont(normalFont);
        enemylabel.setForeground(Color.white);
        enemylabel.setBackground(Color.red);
        playerPanel.add(enemylabel);
        this.enemyhp = new JLabel();
        enemyhp.setFont(normalFont);
        enemyhp.setForeground(Color.white);
        enemyhp.setText("" + monster.getHealth());
        playerPanel.add(enemyhp);

        this.backPanel = new JPanel();
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

        playerPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
    }

    public void run_event(){/////////////////////////////////////////////////////////////////////////////Run here
        /*
          Run this event.
          If the player hasn't defeated the monster, fight the monster; if yes, then show the
          finished slide to the player.
         */
        playerPanel.setVisible(true);
        choiceButtonPanel.setVisible(true);
        if(firsttime){start();}
        else {finished();}
    }

    private void start(){
        /*
        The start scene.
         */
        backPanel.setVisible(false);
        position = "start";
        mainTextArea.setText("Suddenly, a goblin leaped out from nowhere!");
        choice1.setText("Attack");
        choice2.setText("Items");
        choice3.setText("-");
        choice4.setText("Run");
    }

    private void items(){
        /*
        The scene where the player can use items or equip weapons from player's inventory.
         */
        backPanel.setVisible(true);
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

    private void empty_inventory(){
        /*
        The scene when player trys to use item from player's empty inventory.
         */
        backPanel.setVisible(true);
        position = "empty_inventory";
        mainTextArea.setText("Your inventory is empty!");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("Previous Page");
        choice4.setText("Next Page");
    }

    private void top_items(){
        /*
        The scene tells the player that the top of the inventory has already been reached.
         */
        mainTextArea.setText("You are already at the top of your inventory.\nChoose the item you wanna use:");
    }

    private void bot_items(){
        /*
        The scene tells the player that the bottom of the inventory has already been reached.
         */
        mainTextArea.setText("You are already at the bottom of your inventory.\nChoose the item you wanna use:");
    }

    private void attack(){
        /*
        The scene after where the player pressed the Attack button from the start().
         */
        backPanel.setVisible(true);
        position = "attack";
        mainTextArea.setText("Put it in action!");
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    private void attacked(){
        /*
        The scene where player is in a battle.
         */
        position = "attack";
        mainTextArea.setText("You dealt " + dmg_result.get(0) + " and received "+ dmg_result.get(1) + " damage.");
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + monster.getHealth());
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    private void won(){
        /*
        The scene after the player has won.
         */
        position = "won";
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + monster.getHealth());
        mainTextArea.setText("You won! You found 50$ and a golden key!");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Next");
    }

    private void lost(){
        /*
        The scene after the player's lost.
         */
        position = "lost";
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + monster.getHealth());
        mainTextArea.setText("YOU DIED");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    private void skill_not_available(){mainTextArea.setText("You have used the maximum times of this skill.");}

    private void finished(){
        /*
        The scene after the monster is defeated and the player is able to leave the event.
         */
        backPanel.setVisible(false);
        firsttime = false;
        position = "finished";
        mainTextArea.setText("The goblin you defeated never moved again");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            switch(position){
                case "start":
                    switch(yourChoice){
                        case "c1be":
                            attack(); break;
                        case "c2be":
                            if (player.getInventory().get_length() == 0){empty_inventory();break;}
                            items(); break;
                        case "c4be":
                            choiceButtonPanel.setVisible(false);
                            playerPanel.setVisible(false);
                            player.leave();
                            break; ////////////////////////////////////////////////////////////////Runaway, back to room
                    }
                    break;
                case "items":
                    switch(yourChoice){
                        case "c1be":
                            if(player.use_item(current)){items();}
                            else {
                                if (player.getInventory().get_length() == 0) {empty_inventory();}
                                else {
                                    current = 0;
                                    m = player.getInventory().get_length() / 2;
                                    hpLabelNumber.setText("" + player.getHealth());
                                    items();}
                            }
                            break;
                        case "c2be":
                            if (current + 1>=player.getInventory().get_length()){break;}
                            if(player.use_item(current + 1)){items();}
                            else {
                                current = 0;
                                m = player.getInventory().get_length() / 2;
                                hpLabelNumber.setText("" + player.getHealth());
                                items();}
                            break;
                        case "c3be":
                            if (current - 2 < 0){top_items(); }
                            else{current -= 2;items(); }
                            break;
                        case "c4be":
                            if (player.getInventory().get_length() % 2 == 1){
                                if (current + 2 > 2 * m){bot_items();}
                                else {current += 2; items(); }
                            }
                            else {
                                if (current + 2 >= 2 * m){bot_items(); }
                                else {current += 2; items(); }
                            }
                            break;
                        case "c5": start(); break;
                    }
                    break;
                case "empty_inventory":
                    if (Objects.equals(yourChoice, "c5")){start();}break;
                case "attack":
                    switch (yourChoice){
                        case "c1be":
                            dmg_result = player.hit(monster, basic_attack);
                            if (player.getHealth()<=0){lost(); break;}
                            else if (monster.getHealth()<=0){won(); break;}
                            attacked(); break;
                        case "c2be":
                            if (used1 == 0){skill_not_available();break;}
                            used1 -= 1;
                            dmg_result = player.hit(monster, player.getSkills().getFirst());
                            if (player.getHealth()<=0){lost(); break;}
                            else if (monster.getHealth()<=0){won(); break;}
                            attacked(); break;
                        case "c3be":
                            if (used2 == 0){skill_not_available();break;}
                            used2 -= 1;
                            dmg_result = player.hit(monster, player.getSkills().get(1));
                            if (player.getHealth()<=0){lost(); break;}
                            else if (monster.getHealth()<=0){won(); break;}
                            attacked(); break;
                        case "c4be":
                            if (used3 == 0){skill_not_available();break;}
                            used3 -= 1;
                            dmg_result = player.hit(monster, player.getSkills().get(2));
                            if (player.getHealth()<=0){lost(); break;}
                            else if (monster.getHealth()<=0){won(); break;}
                            attacked(); break;
                        case "c5":start();break;
                } break;
                case "lost":if (Objects.equals(yourChoice, "c4be")){new Game();}break;
                case "won":
                    if (Objects.equals(yourChoice, "c4be")){
                        player.add_key(); player.setMoney(player.getMoney() + 50);
                        finished();
                    }
                    break;
                case "finished":
                    if (Objects.equals(yourChoice, "c4be")){
                        choiceButtonPanel.setVisible(false);
                        playerPanel.setVisible(false);
                        player.leave();
                    }break;//////////////////////////////////////////////////////////////////////////////////Back to map
            }
        }
    }
}
