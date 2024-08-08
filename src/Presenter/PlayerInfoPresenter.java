package Presenter;

import javax.swing.*;

public class PlayerInfoPresenter extends EventPresenter{
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;

    public PlayerInfoPresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                               JButton choice4) {
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public void start(){
        mainTextArea.setText("Player Info:");
        choice1.setText("Inventory");
        choice2.setText("Skills");
        choice3.setText("States");
        choice4.setText("-");
    }

    public void describe(String description){
        mainTextArea.setText(description);
        choice1.setText("Previous");
        choice2.setText("Next");
        choice3.setText("-");
        choice4.setText("-");
    }

}
