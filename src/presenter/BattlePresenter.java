package presenter;

import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;

import javax.swing.*;

public class BattlePresenter extends EventPresenter{
    /**
     * The presenter of battle event
     */

    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private JPanel backPanel;
    private JLabel hpLabelNumber, enemyhp;
    private Player player;
    private Monster monster;

    public BattlePresenter(JButton choice1, JButton choice2, JButton choice3, JButton choice4, JPanel backPanel,
                           JTextArea mainTextArea, JLabel hpLabelNumber, JLabel enemyhp, Player player,
                           Monster monster) {// Battle presenter
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.backPanel = backPanel;
        this.hpLabelNumber = hpLabelNumber;
        this.enemyhp = enemyhp;
        this.player = player;
        this.monster = monster;
    }

    public void start(){
        /*
        The start scene.
         */
        renewHP();
        backPanel.setVisible(false);
        mainTextArea.setText("Suddenly, a "+ monster.getName() +" leaped out from nowhere!");
        choice1.setText("Attack");
        choice2.setText("Items");
        choice3.setText("-");
        choice4.setText("Run");
    }

    public void items(int current, int m){
        /*
        The scene where the player can use items or equip weapons from player's inventory.
         */
        backPanel.setVisible(true);
        mainTextArea.setText("Choose the item you wanna use:");
        choice1.setText(player.getInventory().getItem(current).getName());
        if (player.getInventory().getLength() % 2 == 1){
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

    public void attack(){
        /*
        The scene after where the player pressed the Attack button from the start().
         */
        backPanel.setVisible(true);
        mainTextArea.setText("Put it in action!");
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
    }

    public void bot_items(){
        /*
        The scene tells the player that the bottom of the inventory has already been reached.
         */
        mainTextArea.setText("You are already at the bottom of your inventory.\nChoose the item you wanna use:");
    }

    public void attacked(){
        /*
        The scene where player is in a battle.
         */
        backPanel.setVisible(true);
        mainTextArea.setText("Continue your victorious pursuit!");
        hpLabelNumber.setText("" + player.getHealth()); 
        enemyhp.setText("" + monster.getHealth());
        choice1.setText("Basic attack");
        choice2.setText(player.getSkills().get(0).getName());
        choice3.setText(player.getSkills().get(1).getName());
        choice4.setText(player.getSkills().get(2).getName());
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
        hpLabelNumber.setText("" + player.getHealth()); 
        enemyhp.setText("" + monster.getHealth());
        mainTextArea.setText("You won! You found 50$ and a golden key!");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Next");
    }

    public void lost(){
        /*
        The scene after the player's lost.
         */
        hpLabelNumber.setText("" + player.getHealth()); 
        enemyhp.setText("" + monster.getHealth());
        mainTextArea.setText("YOU DIED");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void finished(){
        /*
        The scene after the monster is defeated and the player is able to leave the event.
         */
        backPanel.setVisible(false);
        mainTextArea.setText("The "+ monster.getName() +" you defeated never moved again");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void skill_not_available(){// The updated view of showing the unavailable skill
        mainTextArea.setText("You have used the maximum times of this skill.");}

    public void renewHP(){// Update the view of HP values of the player and the monster
        hpLabelNumber.setText("" + player.getHealth());
        enemyhp.setText("" + monster.getHealth());}
}
