package presenter;

import entities.stat_entities.Monsters.Cursed_Tree;
import entities.stat_entities.Player;

import javax.swing.*;

public class BossPresenter extends EventPresenter{
    /**
     * The presenter of boss fight
     */

    JLabel hpLabelNumber; JLabel enemyhp;
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private JLabel weaponLabel;
    private JPanel backPanel;
    private Player player; Cursed_Tree boss;

    public BossPresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                         JLabel hpLabelNumber, JLabel enemyhp, JLabel weaponLabel, JPanel backPanel, Player player,
                         Cursed_Tree boss) {// Boss presenter Constructor
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1; this.choice2 = choice2; this.choice3 = choice3;
        this.choice4 = choice4;
        this.hpLabelNumber = hpLabelNumber;
        this.enemyhp = enemyhp;
        this.weaponLabel = weaponLabel;
        this.backPanel = backPanel;
        this.player = player;
        this.boss = boss;
    }

    public void start(int bindingRounds){
        /*
        The start scene.
         */
        renewHP();
        backPanel.setVisible(false);
        mainTextArea.setText("You look up at the Cursed Tree that reaches over 30 meters. " +
                "As you sense its wicked presence, you understand the final battle has come.");
        choice1.setText("Attack");
        choice2.setText("Items");if (bindingRounds > 0){choice2.setText("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");}
        choice3.setText("-");
        choice4.setText("-");
    }

    public void items(int current, int m){
        /*
        The scene where the player can use items or equip weapons from player's inventory.
         */
        backPanel.setVisible(true);
        mainTextArea.setText("Choose the item you wanna use:");
        choice1.setText(player.getInventory().getItem(current).getName());
        if (player.getInventory().getLength() % 2 == 1){
            m = player.getInventory().getLength() / 2;
            if (current < 2 * m){choice2.setText(player.getInventory().getItem(current + 1).getName());}
            else {choice2.setText("-");}
        }
        else{choice2.setText(player.getInventory().getItem(current + 1).getName());}
        choice3.setText("Previous Page");
        choice4.setText("Next Page");
    }

    public void empty_inventory(){
        /*
        The scene when player trys to use item from player's empty inventory.
         */
        backPanel.setVisible(true);
        mainTextArea.setText("Your inventory is empty!");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("Previous Page");
        choice4.setText("Next Page");
    }

    public void top_items(){
        /*
        The scene tells the player that the top of the inventory has already been reached.
         */
        mainTextArea.setText("You are already at the top of your inventory.\nChoose the item you wanna use:");
    }

    public void bot_items(){
        /*
        The scene tells the player that the bottom of the inventory has already been reached.
         */
        mainTextArea.setText("You are already at the bottom of your inventory.\nChoose the item you wanna use:");
    }

    public void attack(){
        /*
        The scene after where the player pressed the Attack button from the start().
         */
        backPanel.setVisible(true);
        mainTextArea.setText("There's no way back!");
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    public void attacked(){
        /*
        The scene where player is in a battle.
         */
        backPanel.setVisible(true);
        mainTextArea.setText("Don't give up!");
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + boss.getHealth());
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    public void renewHP(){// Update HP number
        hpLabelNumber.setText("" + player.getHealth());
    }

    public void renewWeapon(){// Update Weapon label
        weaponLabel.setText("Weapon: " + player.getWeaponName());
    }

    public void player_message(String message){
        // The updated view showing the player's attacking result
        backPanel.setVisible(false);
        mainTextArea.setText(message);
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void enemy_message(String message){
        // The updated view showing the monster's attacking result
        backPanel.setVisible(false);
        mainTextArea.setText(message);
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void won(){
        /*
        The scene after the player has won.
         */
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + boss.getHealth());
        mainTextArea.setText("You won! The Cursed Tree turned to ashes and fell to the ground.");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Next");
    }

    public void lost(){
        /*
        The scene after the player's lost.
         */
        hpLabelNumber.setText("" + player.getHealth()); enemyhp.setText("" + boss.getHealth());
        mainTextArea.setText("YOU DIED");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void skill_not_available(){// The updated view of showing the unavailable skill
        mainTextArea.setText("You have used the maximum times of this skill.");}

    public void finished(){
        /*
        The scene after the monster is defeated and the player is able to leave the event.
         */
        backPanel.setVisible(false);
        mainTextArea.setText("Only ashes were left on the ground");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }
}
