package controller.EventController;

import entities.stat_entities.Player;
import use_case_interacter.ShopInteracter;
import view.EventView.ShopViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShopEvent extends Event {
    /**
     * One shop with three items on sell.
     */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    ShopInteracter interacter;
    ShopViewModel shopview = new ShopViewModel();

    //Open / close checker
    public boolean opened = true;
    public boolean shopping = false;

    public ShopEvent(Player player) {//////////////////////////////////////////////////////////////////Create shop here
        /* Constructor of the event. */
        this.mainTextArea = shopview.getMainTextArea();
        choice1 = shopview.getChoice1();
        choice2 = shopview.getChoice2();
        choice3 = shopview.getChoice3();
        choice4 = shopview.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        interacter = new ShopInteracter(mainTextArea,choice1,choice2,choice3,choice4,player);
    }

    public void runEvent(){///////////////////////////////////////////////////////////////////////////////Run shop here
        /*
        Run this event with the buying history saved.
         */
        interacter.shop();
    }

    public Window getWindow(){
        /* Get the window */return shopview.getWindow();}

    public ArrayList getBoughts(){// Return bought1 and bought2 from interacter
        return interacter.getBoughts();}

    public void setBoughts(ArrayList boughts){// Set bought1 and bought2
        interacter.setBoughts(boughts);}

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            if (yourChoice.equals("c4se")) {
                opened = false;
                shopping = false;
                System.out.println("Shop closed");
                return;
            }///////////////////////////////////////////////////////

            switch (yourChoice) {
                case "c1se":
                    interacter.buy1();
                    break;
                case "c2se":
                    interacter.buy2();
                    break;
                case "c3se":
                    interacter.buy3();
                    break;
            }
        }
    }
}