package presenter;

import javax.swing.*;

public class QueenSlimePresenter extends EventPresenter{
    /**
     * The presenter of Queen slime event
     */
    private JButton choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;

    public QueenSlimePresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                               JButton choice4){// Constructor
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public void start() {// Update the start view
        mainTextArea.setText("The Queen slime was heavily injured, do you want to help her?");
        choice1.setText("Help her");
        choice2.setText("Kill her");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void saved(){// Update the finished story view
        mainTextArea.setText("You helped the Queen, and she rewards you with a golden key");
        choice1.setText("Leave");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void killed(){// Update the finished story view
        mainTextArea.setText("You killed the Queen, and she dropped 200 Golds.");
        choice1.setText("Leave");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }
}
