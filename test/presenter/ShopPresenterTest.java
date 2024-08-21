package presenter;

import entities.stat_entities.Items.Item;
import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Items.PurificationPotion;
import entities.stat_entities.Weapons.Katana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;



class ShopPresenterTest {
    JTextArea mainTextArea;
    JButton choice1, choice2, choice3, choice4;
    ShopPresenter presenter;
    Item item1;
    Item item2;
    Item item3;


    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        item1 = new Life_Potion();
        item2 = new Katana();
        item3 = new PurificationPotion();
        presenter = new ShopPresenter(mainTextArea, choice1, choice2, choice3, choice4);
    }


    @Test
    void shop() {
        presenter.shop(true, true, item1, item2, item3);


        assertEquals("Frank: Welcome to my store! I wish I have something you want:\n" +
                "Battle Axe: 100$\nLife Potion: 40$\nGolden Key: 50$", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("Buy Katana", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());


    }

    @Test
    void rebuy() {
        presenter.rebuy();

        assertEquals("You've already bought this one.\n" +
                "Battle Axe: 100$\nLife Potion: 40$\nGolden Key: 50$", mainTextArea.getText());
    }

    @Test
    void lackofmoney() {
        presenter.lackofmoney();

        assertEquals("I'm afraid you don't have enough money.\n" +
                "Battle Axe: 100$\nLife Potion: 40$\nGolden Key: 50$", mainTextArea.getText());
    }
}