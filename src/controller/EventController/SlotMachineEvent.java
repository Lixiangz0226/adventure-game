package controller.EventController;

import entities.stat_entities.Player;
import use_case_interacter.SlotMachineInteracter;
import view.EventView.SlotViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SlotMachineEvent extends Event {
    /**
     * The event that player can pay money to gamble.
     */
    private SlotViewModel slotViewModel = new SlotViewModel();
    private SlotMachineInteracter interacter;
    private JButton choice1, choice2, choice3, choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    public int times = 0;
    public Boolean opened = true;
    private String position = "";

    public SlotMachineEvent(Player player) {
        // Constructor
        choice1 = slotViewModel.getChoice1();
        choice2 = slotViewModel.getChoice2();
        choice3 = slotViewModel.getChoice3();
        choice4 = slotViewModel.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
        interacter = new SlotMachineInteracter(slotViewModel.getMainTextArea(), choice1, choice2, choice3, choice4,
                player);
    }

    public Window getWindow (){/* Get Game Window */return slotViewModel.getWindow();}

    public void runEvent(){
        // Runs the event at the start or the place the player left
        if (times >= 10){position = interacter.finish();}
        else {position = interacter.play();}
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /* Listens to the choice button actions and then take actions. */

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "play":
                    switch (yourChoice){
                        case "c1": position = interacter.result(); break;
                        case "c4": opened = false; break;
                    }break;
                case "result":
                    if (Objects.equals(yourChoice, "c1")){
                        times += 1;
                        if (times >= 10) {
                            position = interacter.broken();
                            break;
                        }
                        position = interacter.play();
                    }break;
                case "broken":
                    if (Objects.equals(yourChoice, "c1")){position = interacter.finish();}
                    break;
                case "finish":
                    opened = false; fighting = false; break;


            }
        }
    }
}
