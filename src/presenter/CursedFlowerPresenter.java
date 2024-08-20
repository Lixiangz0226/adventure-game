package presenter;

import javax.swing.*;

public class CursedFlowerPresenter extends EventPresenter{
    /**
     * The presenter of Cursed flower event
     */
    JTextArea mainTextArea;
    JButton choice1, choice2, choice3, choice4;

    public CursedFlowerPresenter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                 JButton choice4) {// Constructor of the presenter
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public void start(){// Update the start view
        mainTextArea.setText("The cursed flower shines with a strange luster");
        choice1.setText("Use purification potion");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }

    public void not_obtained(){// Update the view showing the player's inventory excludes purification potion
        mainTextArea.setText("You don't have a purification potion");
    }

    public void purified(){// Update the view just after using purification potion
        mainTextArea.setText("The strange luster disappeared, but the flower shot a dim light pointing at a " +
                "patch of grass");
        choice1.setText("Dig from it");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void dug(){// Update the view of the story
        mainTextArea.setText("You found a crossbow. When you're picking it up, you could feel the heat of" +
                " the immortal flame burning at the front.");
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void gotten(){// Update the view of the story
        mainTextArea.setText("You got Flame Crossbow.");
        choice1.setText("Next");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void finish(){// Update the finished view
        mainTextArea.setText("The flower is purified.");
        choice1.setText("-");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("Leave");
    }
}
