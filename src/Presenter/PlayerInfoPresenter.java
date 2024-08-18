package Presenter;

import javax.swing.*;

public class PlayerInfoPresenter extends EventPresenter{
    /**
     * The presenter of Player info page
     */
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;

    public PlayerInfoPresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                               JButton choice4) {// Constructor
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public void start(){// Start view
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
