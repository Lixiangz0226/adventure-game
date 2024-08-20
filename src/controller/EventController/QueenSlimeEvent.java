package controller.EventController;

import entities.stat_entities.Player;
import use_case_interacter.QueenSlimeInteracter;
import view.EventView.QueenViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class QueenSlimeEvent extends Event {
    /**
     * The event that player can choose to kill the queen or to save the queen.
     */
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    private String position = "start";
    private QueenViewModel view = new QueenViewModel();
    private QueenSlimeInteracter interacter;
    public Boolean opened = true;


    public QueenSlimeEvent(Player player){
        /* Queen event */
        choice1 = view.getChoice1();
        choice2 = view.getChoice2();
        choice3 = view.getChoice3();
        choice4 = view.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        interacter = new QueenSlimeInteracter(view.getMainTextArea(), choice1, choice2, choice3, choice4, player);
    }

    public Window getWindow(){/* Get Game Window */return view.getWindow();}

    public void runEvent(){
        switch (position){
            case "start":
                position = interacter.start();
                break;
            case "killed":
                position = interacter.killed();
                break;
            case "saved":
                position = interacter.saved();
                break;
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            /* Listens to the choice button actions and then take actions. */

            String yourChoice = event.getActionCommand();

            switch (position){
                case "start":
                    switch (yourChoice){
                        case "c1qs":
                            position = interacter.saved();break;
                        case "c2qs":
                            position = interacter.killed();break;
                        case "c4qs":
                            opened = false;
                            break;/////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "saved", "killed":
                    if (Objects.equals(yourChoice, "c1qs")){
                        opened = false;
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }
                    break;

            }

        }
    }
}
