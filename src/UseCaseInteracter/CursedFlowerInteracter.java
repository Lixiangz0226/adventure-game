package UseCaseInteracter;

import entities.OutsideEntities.Items.Item;
import entities.Player;
import entities.OutsideEntities.Weapons.Flame_Crossbow;
import Presenter.CursedFlowerPresenter;

import javax.swing.*;
import java.util.Objects;

public class CursedFlowerInteracter extends EventInteracter{
    private CursedFlowerPresenter presenter;
    private Player player;

    public CursedFlowerInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                  JButton choice4, Player player) {
        this.presenter = new CursedFlowerPresenter(mainTextArea, choice1, choice2, choice3, choice4);
        this.player = player;
    }

    public String start(){
        presenter.start();
        return "start";
    }

    public String purified(){

        for (Item item: player.getInventory().getItems()){
            if (Objects.equals(item.getName(), "Purification Potion")){
                player.getInventory().removeItem(item);
                presenter.purified();
                return "purified";
            }
        }
        presenter.not_obtained();
        return "start";
    }

    public String dug(){
        presenter.dug();
        return "dug";
    }

    public String gotten(){
        player.getInventory().addItem(new Flame_Crossbow());
        presenter.gotten();
        return "gotten";
    }

    public String finish(){
        presenter.finish();
        return "finish";
    }
}
