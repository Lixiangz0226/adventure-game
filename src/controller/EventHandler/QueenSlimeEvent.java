package controller.EventHandler;

import OutsideEntities.Player;
import UseCaseInteracter.QueenSlimeInteracter;
import view.EventView.QueenViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class QueenSlimeEvent extends Event {
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    private String position = "start";
    private QueenViewModel view = new QueenViewModel();
    private QueenSlimeInteracter interacter;
    public Boolean queenOpened = true;


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

    public Window getWindow() {return view.getWindow();}

    public void run_event(){
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
            String yourChoice = event.getActionCommand();

            switch (position){
                case "start":
                    switch (yourChoice){
                        case "c1qs":
                            position = interacter.saved();break;
                        case "c2qs":
                            position = interacter.killed();break;
                        case "c4qs":
                            queenOpened = false;
                            break;/////////////////////////////////////////////////////////////////////////////////Leave
                    }break;
                case "saved", "killed":
                    if (Objects.equals(yourChoice, "c1qs")){
                        queenOpened = false;
                        ///////////////////////////////////////////////////////////////////////////////////////////Leave
                    }
                    break;

            }

        }
    }
}
