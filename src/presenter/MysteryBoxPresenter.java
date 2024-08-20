package presenter;

import entities.stat_entities.Player;

import javax.swing.*;

public class MysteryBoxPresenter extends EventPresenter{
    /**
     * The presenter of mystery box event
     */
    private JButton choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;
    private JLabel hpLabelNumber;
    private JLabel moneyNumber;
    private Player player;

    public MysteryBoxPresenter(JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                               JTextArea mainTextArea, JLabel hpLabelNumber, JLabel moneyNumber, Player player) {
        // Constructor
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.mainTextArea = mainTextArea;
        this.hpLabelNumber = hpLabelNumber;
        this.moneyNumber = moneyNumber;
        this.player = player;
        hpLabelNumber.setText(player.getHealth() + ""); moneyNumber.setText("" + player.getMoney());

    }

    public void start(){// Update the start view
        mainTextArea.setText("Old witch: Come here, Young adventurer! I have four presents for you.");
        choice1.setText("What are you doing?");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void talk(){// Update the story view
        mainTextArea.setText("Old witch: The crystal ball has shown me: only you would break the seal and release the " +
                "cursed soul from that tree. I'm just giving you a little push.");
        choice1.setText("What are you giving me?");
    }

    public void present1(){// Update the story view
        mainTextArea.setText("Old witch: The first present has a 0% chance to be harmful. Are you gonna receive it?");
        choice1.setText("Hmm, I'll take it.");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void received(String present){// Shows the player what had received
        hpLabelNumber.setText(player.getHealth() + ""); moneyNumber.setText("" + player.getMoney());
        mainTextArea.setText("You received " + present);
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void punished(String punishment){// Update the view after punishment
        hpLabelNumber.setText(player.getHealth() + ""); moneyNumber.setText("" + player.getMoney());
        mainTextArea.setText(punishment);
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void present2(){// Update the story view
        mainTextArea.setText("Old witch: The second present has a 30% chance to be harmful, but it's more valuable than the first one " +
                "if you're lucky. Are you gonna receive it?");
        choice1.setText("I'll take it.");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void present3(){// Update the story view
        mainTextArea.setText("Old witch: The third present has a 50% chance to be harmful, but it's more valuable than the second one " +
                "if you're lucky. Are you gonna receive it?");
        choice1.setText("Grab it");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void present4(){// Update the story view
        mainTextArea.setText("Old witch: The final present has a 70% chance to be harmful, but it's more valuable than the third one " +
                "if you're lucky. Are you gonna receive it?");
        choice1.setText("Just give it to me!");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void finish(){// Update the finished view
        mainTextArea.setText("Old witch: Don't get too greedy, my friend!");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }
}
