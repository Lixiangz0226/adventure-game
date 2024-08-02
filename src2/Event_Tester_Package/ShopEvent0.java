package Event_Tester_Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import OutsideEntities.*;
import OutsideEntities.Items.*;
import OutsideEntities.Weapons.*;
import Presenter.ShopPresenter;
import UseCaseInteracter.ShopInteracter;
import view.EventView.ShopViewModel;

public class ShopEvent0 extends Event{
    /**
     * One shop with three items on sell.
     */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;
    private String position;
    private Container con;
    private JPanel choiceButtonPanel;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    ShopInteracter shopInteracter;
    Player playerEntity;
    ShopPresenter presenter;
    ShopViewModel shopview = new ShopViewModel();

    //Open / close checker
    public boolean shopOpened;

    public ShopEvent0(Player player) {//////////////////////////////////////////////////////////////////Create shop here
        /*
        Initializer of the event.
         */
        shopOpened = true;

        this.mainTextArea = shopview.getMainTextArea();
        choice1 = shopview.getChoice1();
        choice2 = shopview.getChoice2();
        choice3 = shopview.getChoice3();
        choice4 = shopview.getChoice4();

        this.player = player;
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        presenter = new ShopPresenter(mainTextArea, choice1, choice2, choice3, choice4);

        shopInteracter = new ShopInteracter(mainTextArea,presenter,choice1,choice2,choice3,choice4,player);
    }

    public void run_event(){///////////////////////////////////////////////////////////////////////////////Run shop here
        /*
        Run this event with the buying history saved.
         */
        shopInteracter.shop();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            if (yourChoice.equals("c4se")) {

                shopOpened = false;
                return;

            }///////////////////////////////////////////////////////

            switch (yourChoice) {
                case "c1se":
                    shopInteracter.buy1();
                    break;
                case "c2se":
                    shopInteracter.buy2();
                    break;
                case "c3se":
                    shopInteracter.buy3();
                    break;
            }
        }
    }
}