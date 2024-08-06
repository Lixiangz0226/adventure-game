package UseCaseInteracter;

import OutsideEntities.Items.*;
import OutsideEntities.Player;
import OutsideEntities.Weapons.*;
import Presenter.ShopPresenter;

import javax.swing.*;
import java.util.Objects;

public class ShopInteracter {

    JTextArea mainTextarea;
    JButton choice1, choice2, choice3, choice4;
    Player player;
    ShopPresenter presenter;
    private Boolean bought1 = false, bought3 = false;
    private Item item1 = new Battle_Axe();
    private Item item2 = new Life_Potion();
    private Item item3 = new Golden_Key();

    public ShopInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2,
                          JButton choice3, JButton choice4, Player player) {

        this.mainTextarea = mainTextArea;
        this.presenter = new ShopPresenter(mainTextArea, choice1, choice2, choice3, choice4, item1, item2, item3);
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.player = player;
    }

    public void buy1(){
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
        presenter.bought(bought1, bought3, item1.getName());
    }

    public void buy2(){
        if (player.getMoney() < 40) {
            presenter.lackofmoney();
            return;
        }
        player.getInventory().addItem(new Life_Potion());
        player.setMoney(player.getMoney() - 40);
        presenter.bought(bought1, bought3, item2.getName());
    }

    public void buy3(){
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
        presenter.bought(bought1, bought3, item3.getName());
    }

    public void shop(){presenter.shop(bought1, bought3);}

}
