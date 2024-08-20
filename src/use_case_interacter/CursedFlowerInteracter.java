package use_case_interacter;

import entities.stat_entities.Items.Item;
import entities.stat_entities.Player;
import entities.stat_entities.Weapons.Flame_Crossbow;
import presenter.CursedFlowerPresenter;

import javax.swing.*;
import java.util.Objects;

public class CursedFlowerInteracter extends EventInteracter{
    /**
     * The use case interacter of cursed flower event
     */
    private CursedFlowerPresenter presenter;
    private Player player;

    public CursedFlowerInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                  JButton choice4, Player player) {// Constructor
        this.presenter = new CursedFlowerPresenter(mainTextArea, choice1, choice2, choice3, choice4);
        this.player = player;
    }

    public String start(){// The start use case
        presenter.start();
        return "start";
    }

    public String purified(){// The use case used or not obtained a purification potion

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

    public String dug(){// The story use case
        presenter.dug();
        return "dug";
    }

    public String gotten(){// The story use case
        player.getInventory().addItem(new Flame_Crossbow());
        presenter.gotten();
        return "gotten";
    }

    public String finish(){// The finished use case
        presenter.finish();
        return "finish";
    }
}
