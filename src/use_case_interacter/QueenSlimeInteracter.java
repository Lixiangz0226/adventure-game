package use_case_interacter;

import entities.stat_entities.Player;
import presenter.QueenSlimePresenter;

import javax.swing.*;

public class QueenSlimeInteracter extends EventInteracter{
    /**
     * The use case interacter of Queen slime event
     */
    private Player player;
    private QueenSlimePresenter presenter;

    public QueenSlimeInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                JButton choice4, Player player){
        this.player = player;
        presenter = new QueenSlimePresenter(mainTextArea, choice1, choice2, choice3, choice4);
    }

    public String start(){// The start use case
        presenter.start();
        return  "start";
    }

    public String saved(){// The saved use case
        player.add_key();
        presenter.saved();
        return "saved";
    }

    public String killed(){// The killed use case
        player.setMoney(player.getMoney() + 200);
        presenter.killed();
        return "killed";
    }
}
