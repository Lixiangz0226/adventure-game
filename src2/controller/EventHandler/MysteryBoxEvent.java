package controller.EventHandler;

import OutsideEntities.Player;
import UseCaseInteracter.MysteryBoxInteracter;
import view.EventView.MystereyViewModel;
import view.EventView.ShopViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MysteryBoxEvent {
    private JButton choice1, choice2, choice3, choice4;
    private MystereyViewModel mysteryView;
    private MysteryBoxInteracter interacter;
    private String position = "";
    ChoiceHandler choiceHandler = new ChoiceHandler();
    public Boolean boxOpened = true;

    public MysteryBoxEvent(Player player) {
        mysteryView = new MystereyViewModel();
        choice1 = mysteryView.getChoice1();
        choice2 = mysteryView.getChoice2();
        choice3 = mysteryView.getChoice3();
        choice4 = mysteryView.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
        interacter = new MysteryBoxInteracter(choice1, choice2, choice3, choice4, mysteryView.getMainTextArea(),
                player);
    }

    public void run_event() {
        if (Objects.equals(position, "present1")) {position = interacter.present1();}
        else if (Objects.equals(position, "present2")){position = interacter.present2();}
        else if (Objects.equals(position, "present3")){position = interacter.present3();}
        else if (Objects.equals(position, "present4")){position = interacter.present4();}
        else if (Objects.equals(position, "")){position = interacter.start();}
        else {position = interacter.finish();}

    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            switch (position){
                case "start": if(Objects.equals(yourChoice, "c1mb")){position = interacter.talk();}break;
                case "talk": if (Objects.equals(yourChoice, "c1mb")){position = interacter.present1();}break;
                case "present1":
                    switch (yourChoice){
                        case "c1mb": position = interacter.receive1(); break;
                        case "c4mb": boxOpened = false; break;
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "receive1": if (Objects.equals(yourChoice, "c1mb")){position = interacter.present2();}break;
                case "present2":
                    switch (yourChoice){
                        case "c1mb": position = interacter.receive2(); break;
                        case "c4mb": boxOpened = false; break;
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "receive2": if (Objects.equals(yourChoice, "c1mb")){position = interacter.present3();}break;
                case "present3":
                    switch (yourChoice){
                        case "c1mb": position = interacter.receive3(); break;
                        case "c4mb": boxOpened = false; break;
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "receive3": if (Objects.equals(yourChoice, "c1mb")){position = interacter.present4();}break;
                case "present4":
                    switch (yourChoice){
                        case "c1mb": position = interacter.receive4(); break;
                        case "c4mb": boxOpened = false; break;
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "receive4": if (Objects.equals(yourChoice, "c1mb")){position = interacter.finish();}break;
                case "finish": if (Objects.equals(yourChoice, "c4mb")){boxOpened = false;}break;
                ///////////////////////////////////////////////////////////////////////////////////////////////////Leave
            }
        }
    }

}