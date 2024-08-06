package controller.EventHandler;

import OutsideEntities.Player;
import UseCaseInteracter.SlotMachineInteracter;
import view.EventView.SlotViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotMachineEvent extends Event {
    private SlotViewModel slotViewModel = new SlotViewModel();
    private SlotMachineInteracter interacter;
    private JButton choice1, choice2, choice3, choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    public int times = 0;
    public Boolean slotOpened = true;
    private String position = "";

    public SlotMachineEvent(Player player) {
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

    public Window getWindow() {return slotViewModel.getWindow();}

    public void run_event(){
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
                        case "c4": slotOpened = false; break;
                    }break;
                case "result":
                    times += 1;
                    if (times >= 10) {
                        position = interacter.broken();
                        break;
                    }
                    position = interacter.play();
                    break;
                case "broken":
                    position = interacter.finish(); break;
            }
        }
    }
}
