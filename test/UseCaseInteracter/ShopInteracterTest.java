package UseCaseInteracter;

import OutsideEntities.Player;
import Presenter.ShopPresenter;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopInteracterTest {
    ShopPresenter presenter = new ShopPresenter(new JTextArea(), new JButton(), new JButton(), new JButton(),
            new JButton());
    Player player = new Player("Dante", 50);
    ShopInteracter Shop = new ShopInteracter(new JTextArea(), new JButton(), new JButton(), new JButton(),
            new JButton(), player);

    @Test
    void getBoughts() {
        //Check if bought 1 and bought 3 is returned
        assertEquals(Shop.getBoughts().getFirst(),false);
        assertEquals(Shop.getBoughts().getLast(),false);
    }

    @Test
    void setBoughts() {
        //Check if bought1 and bought3 each get set to the first and last boolean of the given list, respectively
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        list.add(true);
        list.add(false);
        list.add(true);
        Shop.setBoughts(list);
        assertEquals(true, Shop.getBoughts().getFirst());
        assertEquals(true, Shop.getBoughts().getLast());

        //Check if bought3 changes accordingly with the addition in the given list
        list.add(false);
        Shop.setBoughts(list);
        assertEquals(false, Shop.getBoughts().getLast());
    }

    @Test
    void buy1() {
        //Check if the player can't buy the battleaxe with money less than 100
        player.setMoney(50);
        Shop.buy1();
        assert (player.getInventory().getLength() == 0);
        assertEquals (Shop.getBoughts().getFirst(), false);

        //Check if the player can buy the battleaxe with money more than 100
        player.setMoney(250);
        Shop.buy1();
        assert (player.getInventory().getLength() == 1);
        assertEquals (Shop.getBoughts().getFirst(), true);

        //Check if the player's money decreased after the purchase
        assertEquals(player.getMoney(), 150);

        //Check if the player can't buy the battleaxe two times
        Shop.buy1();
        assert (player.getInventory().getLength() == 1);
        assertEquals(player.getMoney(), 150);
    }

    @Test
    void buy2() {
        //Check if the player can't buy a life potion with money less than 40
        player.setMoney(20);
        Shop.buy2();
        assert (player.getInventory().getLength() == 0);

        //Check if the player can buy a life potion with money more than 40
        player.setMoney(200);
        Shop.buy2();
        assert (player.getInventory().getLength() == 1);

        //Check if the player's money decreased after the purchase
        assertEquals(player.getMoney(), 160);

        //Check if the player can buy a life potion multiple times
        Shop.buy2();
        assert (player.getInventory().getLength() == 2);
        assertEquals(player.getMoney(), 120);
    }

    @Test
    void buy3() {
        //Check if the player can't buy the golden key with money less than 50
        player.setMoney(30);
        Shop.buy3();
        assertEquals (player.getKey(), 0);
        assertEquals (Shop.getBoughts().getLast(), false);

        //Check if the player can buy the golden key with money more than 50
        player.setMoney(200);
        Shop.buy3();
        assertEquals (player.getKey(), 1);
        assertEquals (Shop.getBoughts().getLast(), true);

        //Check if the player's money decreased after the purchase
        assertEquals(player.getMoney(), 150);

        //Check if the player can't buy the golden key two times
        Shop.buy3();
        assertEquals (player.getKey(), 1);
        assertEquals(player.getMoney(), 150);

    }

    @Test
    void shop() {

    }
}