package UseCaseInteracter;

import OutsideEntities.Player;
import Presenter.SlotMachinePresenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class SlotMachineInteracter {
    private SlotMachinePresenter presenter;
    private Player player;
    Random rand = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public SlotMachineInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                 JButton choice4, Player player) {
        presenter = new SlotMachinePresenter(mainTextArea, choice1, choice2, choice3, choice4);
        this.player = player;
        list.add(0); list.add(30); list.add(70); list.add(100);
    }

    public String play(){
        presenter.play();
        return "play";
    }

    public String result(){
        if (player.getMoney() < 50){
            presenter.lackOfMoney();
            return "play";
        }
        player.setMoney(player.getMoney() - 50);
        int won = list.get(rand.nextInt(4));
        player.setMoney(player.getMoney() + won);
        presenter.result(won);
        return "result";
    }

    public String broken(){
        presenter.broken();
        player.setMoney(player.getMoney() + 500);
        return "broken";
    }

    public String finish(){
        presenter.finish();
        return "finish";
    }
}
