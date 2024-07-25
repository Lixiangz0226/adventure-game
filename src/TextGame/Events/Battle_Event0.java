package TextGame.Events;

import TextGame.app.Game;
import TextGame.Skills.Basic_attack;
import TextGame.Monsters.Goblin;
import TextGame.Monsters.Monster;
import TextGame.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Battle_Event0 extends TextGame.Events.Event {
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;
    private Monster monster;
    private static String position;
    private boolean firsttime;
    private int m; private int current, used1, used2, used3;
    JLabel hpLabelNumber; JLabel enemyhp; JPanel backPanel;
    private List<String> message;
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
        this.m = player.getInventory().getLength() / 2;
        this.current = 0;
        this.message = new ArrayList<String>();
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
        if (player.getInventory().getLength() % 2 == 1){
            m = player.getInventory().getLength() / 2;
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
        backPanel.setVisible(true);
        position = "attack";
        mainTextArea.setText("Continue your victorious pursuit!");
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + monster.getHealth());
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    private void player_message(){
        backPanel.setVisible(false);
        position = "player_message";
        mainTextArea.setText(message.getFirst());
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    private void enemy_message(){
        backPanel.setVisible(false);
        position = "enemy_message";
        mainTextArea.setText(message.getLast());
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
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

    public class ChoiceHandler implements ActionListener {
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
                            if (player.getInventory().getLength() == 0){empty_inventory();break;}
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
                                if (player.getInventory().getLength() == 0) {empty_inventory();}
                                else {
                                    current = 0;
                                    m = player.getInventory().getLength() / 2;
                                    hpLabelNumber.setText("" + player.getHealth());
                                    items();}
                            }
                            break;
                        case "c2be":
                            if (current + 1>=player.getInventory().getLength()){break;}
                            if(player.use_item(current + 1)){items();}
                            else {
                                current = 0;
                                m = player.getInventory().getLength() / 2;
                                hpLabelNumber.setText("" + player.getHealth());
                                items();}
                            break;
                        case "c3be":
                            if (current - 2 < 0){top_items(); }
                            else{current -= 2;items(); }
                            break;
                        case "c4be":
                            if (player.getInventory().getLength() % 2 == 1){
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
                            message = player.hit(monster, basic_attack);
                            player_message(); break;
                        case "c2be":
                            if (used1 == 0){skill_not_available();break;}
                            used1 -= 1;
                            message = player.hit(monster, player.getSkills().getFirst());
                            player_message(); break;
                        case "c3be":
                            if (used2 == 0){skill_not_available();break;}
                            used2 -= 1;
                            message = player.hit(monster, player.getSkills().get(1));
                            player_message(); break;
                        case "c4be":
                            if (used3 == 0){skill_not_available();break;}
                            used3 -= 1;
                            message = player.hit(monster, player.getSkills().get(2));
                            player_message(); break;
                        case "c5":start();break;
                } break;
                case "player_message":
                    if (Objects.equals(yourChoice, "c1be")){
                        enemy_message();
                    }
                    break;
                case "enemy_message":
                    if (Objects.equals(yourChoice, "c1be")){
                        if (player.getHealth()<=0){lost(); break;}
                        else if (monster.getHealth()<=0){won(); break;}
                        attacked();
                    }
                    break;
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
