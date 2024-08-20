package use_case_interacter;

import entities.stat_entities.Player;
import presenter.SlotMachinePresenter;

import javax.swing.*;
import java.util.Random;

public class SlotMachineInteracter extends EventInteracter{
    /**
     * The use case interacter of slot machine event
     */
    private SlotMachinePresenter presenter;
    private Player player;
    Random rand = new Random();

    public SlotMachineInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                 JButton choice4, Player player) {// Constructor
        presenter = new SlotMachinePresenter(mainTextArea, choice1, choice2, choice3, choice4);
        this.player = player;
    }

    public String play(){// The playing use case
        presenter.play();
        return "play";
    }

    public String result(){// The use case getting random playing result
        if (player.getMoney() < 50){
            presenter.lackOfMoney();
            return "play";
        }
        player.setMoney(player.getMoney() - 50);
        int r = rand.nextInt(10);
        if (r <= 1){
            player.setMoney(player.getMoney() + 0);
            presenter.result(0);}
        else if (r <= 4){
            player.setMoney(player.getMoney() + 30);
            presenter.result(30);}
        else if (r <= 7){
            player.setMoney(player.getMoney() + 70);
            presenter.result(70);}
        else{
            player.setMoney(player.getMoney() + 100);
            presenter.result(100);
        }
        return "result";
    }

    public String broken(){// The story use case
        presenter.broken();
        player.setMoney(player.getMoney() + 500);
        return "broken";
    }

    public String finish(){// The finished use case
        presenter.finish();
        return "finish";
    }
}
