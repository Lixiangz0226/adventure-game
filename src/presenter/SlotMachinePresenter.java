package presenter;

import javax.swing.*;

public class SlotMachinePresenter extends EventPresenter{
    /**
     * The presenter of slot machine event
     */
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;

    public SlotMachinePresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                JButton choice4) {// Constructor
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public void play(){// Update the playing view
        mainTextArea.setText("Here's a slot machine. You can pay 50$ to play:");
        choice1.setText("Play");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void lackOfMoney(){// Update the view to show the player doesn't have enough money
        mainTextArea.setText("You don't have enough money! You can pay 50$ to play:");
    }

    public void result(int result){// Update the result view
        mainTextArea.setText("You won " + result + "$");
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void broken(){// Update the story view
        mainTextArea.setText("This slot machine is not working.");
        choice1.setText("Kick it");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void finish(){// Update the finished view
        mainTextArea.setText("The slot machine fell to the ground and gave out a \" BANG!\" sound." +
                "You got your 500$ back. Thank you for playing!");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }
}
