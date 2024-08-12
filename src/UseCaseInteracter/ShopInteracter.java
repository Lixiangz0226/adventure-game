package UseCaseInteracter;

import OutsideEntities.Items.*;
import OutsideEntities.Player;
import OutsideEntities.Weapons.*;
import Presenter.ShopPresenter;

import javax.swing.*;
import java.util.Objects;

public class ShopInteracter extends EventInteracter{

    JButton choice1, choice3;
    Player player;
    ShopPresenter presenter;
    private Boolean bought1 = false, bought2 = false, bought3 = false;
    private Item item1 = new Battle_Axe();
    private Item item2 = new Life_Potion();
    private Item item3 = new Golden_Key();

    public ShopInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2,
                          JButton choice3, JButton choice4, Player player) {// Constructor
        this.choice1 = choice1;
        this.choice3 = choice3;
        this.presenter = new ShopPresenter(mainTextArea, choice1, choice2, choice3, choice4);
        this.player = player;
    }

    public void buy1(){// The use case buying the first item
        if (Objects.equals(choice1.getText(), "-")) {
            presenter.rebuy();
            return;
        } else if (player.getMoney() < 100) {
            presenter.lackofmoney();
            return;
        }
        player.getInventory().addItem(item1);
        player.setMoney(player.getMoney() - 100);
        bought1 = true;
        presenter.shop(bought1, bought2, bought3, item1, item2, item3);
    }

    public void buy2(){// The use case buying the second item
        if (player.getMoney() < 40) {
            presenter.lackofmoney();
            return;
        }
        player.getInventory().addItem(new Life_Potion());
        player.setMoney(player.getMoney() - 40);
        bought2 = true;
        presenter.shop(bought1, bought2, bought3, item1, item2, item3);
    }

    public void buy3(){// The use case buying the third item
        if (Objects.equals(choice3.getText(), "-")) {
            presenter.rebuy();
            return;
        } else if (player.getMoney() < 50) {
            presenter.lackofmoney();
            return;
        }
        player.add_key();
        player.setMoney(player.getMoney() - 50);
        bought3 = true;
        presenter.shop(bought1, bought2, bought3, item1, item2, item3);
    }

    public void shop(){// The basic shop use case
        presenter.shop(bought1, bought2, bought3, item1, item2, item3);}

}
