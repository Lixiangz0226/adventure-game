package controller.EventController;

import entities.stat_entities.Player;
import use_case_interacter.CursedFlowerInteracter;
import view.EventView.CursedFlowerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CursedFlowerEvent extends Event {
    /**
     * The special event where the player can obtain a Flame Crossbow
     */
    private CursedFlowerViewModel view;
    private CursedFlowerInteracter interacter;
    private JButton choice1, choice2, choice3, choice4;
    public String position = "start";
    public Boolean opened = true;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    public Boolean status;

    public CursedFlowerEvent(Player player) {
        // Constructor
        view = new CursedFlowerViewModel();
        choice1 = view.getChoice1();
        choice2 = view.getChoice2();
        choice3 = view.getChoice3();
        choice4 = view.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        status = true;

        interacter = new CursedFlowerInteracter(view.getMainTextArea(), choice1, choice2, choice3, choice4, player);
    }

    public Window getWindow() {/* Get Game Window */return view.getWindow();}

    public void runEvent(){
        // Runs event at finished page if finished, otherwise at start page.
        if(Objects.equals(position, "finish")){position = interacter.finish();}
        else {position = interacter.start();}
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            switch (position){
                case "start":
                    switch (yourChoice){
                        case "c1":
                            position = interacter.purified(); break;
                        case "c4": opened = false; break;

                    }break;
                case "purified":
                    switch (yourChoice){
                        case "c1": position = interacter.dug(); break;
                    }break;
                case "dug":
                    switch (yourChoice){
                        case "c1": position = interacter.gotten(); break;
                    }break;
                case "gotten":
                    switch (yourChoice){
                        case "c1": position = interacter.finish(); break;
                    }break;
                case "finish":
                    switch (yourChoice){
                        case "c4": opened = false; status = false; break;
                    }
            }
        }
    }
}
