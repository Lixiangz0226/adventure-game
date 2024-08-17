package controller.EventController;

import OutsideEntities.Player;
import UseCaseInteracter.PlayerInfoInteracter;
import controller.GamePanel;
import view.EventView.PlayerInfoViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInfo extends Event {
    /**
     * The player info page and player can return to the title page.
     */
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    private PlayerInfoViewModel view;
    private PlayerInfoInteracter interacter;
    private String position = "start";
    public Boolean opened = true;
    public GamePanel gp;

    public PlayerInfo(Player player, GamePanel gp) {
        // Constructor
        this.gp = gp;
        view = new PlayerInfoViewModel(player);
        choice1 = view.getChoice1();
        choice2 = view.getChoice2();
        choice3 = view.getChoice3();
        choice4 = view.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
        view.getBackButton().addActionListener(choiceHandler);
        interacter = new PlayerInfoInteracter(player, view.getMainTextArea(), choice1, choice2, choice3, choice4);
    }

    public Window getWindow() {/* Get Game Window */return view.getWindow();}

    public void runEvent(){// Run the player info view.
        position = interacter.start();}

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /* Listens to the choice button actions and then take actions. */
            String yourChoice = event.getActionCommand();

            switch (position) {
                case "start":
                    switch (yourChoice) {
                        case "c1": position = interacter.inventory(); break;
                        case "c2": position = interacter.skills(); break;
                        case "c3": position = interacter.states(); break;
                        case "c4":
                            getWindow().setVisible(false);
                            gp.gameState = gp.titleState;
                            opened = false;
                            break;
                        case "c5": opened = false; break;
                    }break;
                case "inventory":
                    switch (yourChoice) {
                        case "c1": position = interacter.upInv(); break;
                        case "c2": position = interacter.downInv(); break;
                        case "c5": position = interacter.start(); break;
                    }break;
                case "skills":
                    switch (yourChoice) {
                        case "c1": position = interacter.upSkill(); break;
                        case "c2": position = interacter.downSkill(); break;
                        case "c5": position = interacter.start(); break;
                    }break;
                case "states":
                    switch (yourChoice) {
                        case "c1": position = interacter.upState(); break;
                        case "c2": position = interacter.downState(); break;
                        case "c5": position = interacter.start(); break;
                    }break;

            }
        }
    }
}
