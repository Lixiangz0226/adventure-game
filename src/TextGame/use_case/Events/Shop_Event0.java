package TextGame.use_case.Events;

import TextGame.entities.*;
import TextGame.entities.Items.Golden_Key;
import TextGame.entities.Items.Item;
import TextGame.entities.Items.Life_Potion;
import TextGame.entities.Weapons.Flame_Crossbow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Shop_Event0 extends Event {
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

    public class CHandler implements ActionListener {
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
