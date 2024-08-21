package presenter;

import entities.stat_entities.Items.Item;

import javax.swing.*;

public class ShopPresenter extends EventPresenter{
    /**
     * The presenter of shop event
     */
    JTextArea mainTextArea;
    JButton choice1, choice2, choice3, choice4;

    public ShopPresenter(JTextArea mainTextarea, JButton choice1, JButton choice2, JButton choice3, JButton choice4) {
        // Constructor
        this.mainTextArea = mainTextarea;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public void shop(Boolean bought1, Boolean bought3, Item item1, Item item2, Item item3){
        /*
        The scene of the shop.
         */
        mainTextArea.setText("Frank: Welcome to my store! I wish I have something you want:\n" +
                "Battle Axe: 100$\nLife Potion: 40$\nGolden Key: 50$");
        choice1.setText("-");if (!bought1){choice1.setText("Buy " + item1.getName());}
        choice2.setText("Buy " + item2.getName());
        choice3.setText("-");if (!bought3){choice3.setText("Buy " + item3.getName());}
        choice4.setText("Leave");
    }

    public void rebuy(){
        /*
        The scene that notices the player which has already bought the item player has chosen.
         */
        mainTextArea.setText("You've already bought this one.\n" +
                 "Battle Axe: 100$\nLife Potion: 40$\nGolden Key: 50$");
    }

    public void lackofmoney(){
        /*
        The scene that notices the player which is lack of money.
         */
        mainTextArea.setText("I'm afraid you don't have enough money.\n" +
                "Battle Axe: 100$\nLife Potion: 40$\nGolden Key: 50$");
    }
}
