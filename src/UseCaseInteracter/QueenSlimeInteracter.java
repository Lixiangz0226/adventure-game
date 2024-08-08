package UseCaseInteracter;

import entities.Player;
import Presenter.QueenSlimePresenter;

import javax.swing.*;

public class QueenSlimeInteracter extends EventInteracter{
    private Player player;
    private QueenSlimePresenter presenter;

    public QueenSlimeInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                JButton choice4, Player player){
        this.player = player;
        presenter = new QueenSlimePresenter(mainTextArea, choice1, choice2, choice3, choice4);
    }

    public String start(){
        presenter.start();
        return  "start";
    }

    public String saved(){
        player.add_key();
        presenter.saved();
        return "saved";
    }

    public String killed(){
        player.setMoney(player.getMoney() + 200);
        presenter.killed();
        return "killed";
    }
}
