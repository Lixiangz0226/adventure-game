package presenter;

import entities.stat_entities.Player;
import use_case_interacter.PlayerInfoInteracter;

import javax.swing.*;

public class PlayerInfoPresenter extends EventPresenter{
    /**
     * The presenter of Player info page
     */
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private JLabel hp, money;
    private Player player;

    public PlayerInfoPresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                               JButton choice4, JLabel hp, JLabel money, Player player) {// Constructor
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.hp = hp;
        this.money = money;
        this.player = player;
    }

    public void start(){// Start view
        hp.setText("" + player.getHealth());
        money.setText("" + player.getMoney());
        mainTextArea.setText("Info:");
        choice1.setText("Inventory");
        choice2.setText("Skills");
        choice3.setText("States");
        choice4.setText("Save Game");
    }

    public void describe(String description){// Update the info view
        mainTextArea.setText(description);
        choice1.setText("Previous");
        choice2.setText("Next");
        choice3.setText("-");
        choice4.setText("-");
    }

}
