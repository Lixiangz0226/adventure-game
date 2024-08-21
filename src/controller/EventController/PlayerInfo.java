package controller.EventController;

import entities.stat_entities.Player;
import use_case_interacter.PlayerInfoInteracter;
import controller.GamePanel;
import data_access.SaveEvent;
import data_access.SavePlayer;
import view.EventView.PlayerInfoViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayerInfo extends Event {
    /**
     * The player info page and player can return to the title page.
     */
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4; JButton choice5; JButton choice6;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    private PlayerInfoViewModel view;
    private PlayerInfoInteracter interacter;
    private String position = "start";
    public Boolean opened = true;
    public GamePanel gp;
    private SavePlayer savePlayer;
    private SaveEvent saveEvent;
    private JButton handSwitchButton;


    public PlayerInfo(Player player, GamePanel gp) throws IOException {
        // Constructor
        savePlayer = new SavePlayer(player);
        saveEvent = new SaveEvent();
        this.gp = gp;
        view = new PlayerInfoViewModel(player);
        choice1 = view.getChoice1();
        choice2 = view.getChoice2();
        choice3 = view.getChoice3();
        choice4 = view.getChoice4();
        choice5 = view.getBackButton();
        choice6 = view.getHomeButton();
        handSwitchButton = view.getHandSwitchButton();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
        choice5.addActionListener(choiceHandler);
        choice6.addActionListener(choiceHandler);
        handSwitchButton.addActionListener(choiceHandler);

        interacter = new PlayerInfoInteracter(player, view.getMainTextArea(), choice1, choice2, choice3, choice4,
                view.getHpLabelNumber(), view.getMoney());
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
                            try {
                                savePlayer.save();
                                saveEvent.save(gp);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            /////////////////////////////////////////////////////////////////////////////////data_access
                            break;
                        case "c5": opened = false; break;
                        case "c6":
                            getWindow().setVisible(false);
                            gp.gameState = gp.titleState;
                            opened = false; break;
                        case "c7":
                            gp.leftHanded = !gp.leftHanded; break;
                    }break;
                case "inventory":
                    switch (yourChoice) {
                        case "c1": position = interacter.upInv(); break;
                        case "c2": position = interacter.downInv(); break;
                        case "c5": position = interacter.start(); break;
                        case "c6":
                            getWindow().setVisible(false);
                            gp.gameState = gp.titleState;
                            opened = false; break;
                    }break;
                case "skills":
                    switch (yourChoice) {
                        case "c1": position = interacter.upSkill(); break;
                        case "c2": position = interacter.downSkill(); break;
                        case "c5": position = interacter.start(); break;
                        case "c6":
                            getWindow().setVisible(false);
                            gp.gameState = gp.titleState;
                            opened = false; break;
                    }break;
                case "states":
                    switch (yourChoice) {
                        case "c1": position = interacter.upState(); break;
                        case "c2": position = interacter.downState(); break;
                        case "c5": position = interacter.start(); break;
                        case "c6":
                            getWindow().setVisible(false);
                            gp.gameState = gp.titleState;
                            opened = false; break;
                    }break;

            }
        }
    }
}
