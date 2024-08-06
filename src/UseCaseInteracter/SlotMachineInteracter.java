package UseCaseInteracter;

import OutsideEntities.Player;
import Presenter.SlotMachinePresenter;

import javax.swing.*;
import java.util.Random;

public class SlotMachineInteracter {
    private SlotMachinePresenter presenter;
    private Player player;
    Random rand = new Random();

    public SlotMachineInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                 JButton choice4, Player player) {
        presenter = new SlotMachinePresenter(mainTextArea, choice1, choice2, choice3, choice4);
        this.player = player;
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