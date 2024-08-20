package controller.EventController;


import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;
import use_case_interacter.BattleInteracter;
import controller.GamePanel;
import view.EventView.BattleViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class BattleEvent extends Event {
    /**
     * The battle event between the player and a monster
     */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private static String position;
    JLabel hpLabelNumber; JLabel enemyhp; JPanel backPanel;
    private JButton backButton;
    private BattleViewModel battleViewModel;
    private BattleInteracter battleInteracter;
    public boolean opened = true;
    public boolean fighting = false;
    private GamePanel gp;

    ChoiceHandler choiceHandler = new ChoiceHandler();

    public BattleEvent(Player player, Monster monster, GamePanel gp) throws IOException {////////////////////////////////////////////////////////////////////Create here
        /*
        Initializer of the event.
         */
        status = true;
        this.gp = gp;

        battleViewModel = new BattleViewModel(player, monster);

        mainTextArea = battleViewModel.getMainTextArea();
        this.position = "";
        hpLabelNumber = battleViewModel.getHpLabelNumber();
        enemyhp = battleViewModel.getEnemyhp();
        backPanel = battleViewModel.getBackPanel();
        choice1 = battleViewModel.getChoice1();
        choice2 = battleViewModel.getChoice2();
        choice3 = battleViewModel.getChoice3();
        choice4 = battleViewModel.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        backButton = battleViewModel.getBackButton();
        backButton.addActionListener(choiceHandler);

        battleInteracter = new BattleInteracter(choice1, choice2, choice3, choice4, backPanel, mainTextArea, hpLabelNumber,
                enemyhp, player, monster);
    }

    public void runEvent(){////////////////////////////////////////////////////////////////////////////////////Run here
        /*
          Run this event.
          If the player hasn't defeated the monster, fight the monster; if yes, then show the
          finished slide to the player.
         */
        if(status){position = battleInteracter.start();}
        else {position = battleInteracter.finished();}
    }

    public Window getWindow(){/* Get the window */return battleViewModel.getWindow();}

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            switch(position){
                case "start":
                    switch(yourChoice){
                        case "c1be": position = battleInteracter.attack(); break;
                        case "c2be": position = battleInteracter.items(); break;
                        case "c4be":
                            opened = false;
                            fighting = false;
                            break; ////////////////////////////////////////////////////////////////Runaway, back to room
                    }
                    break;
                case "items":
                    switch(yourChoice){
                        case "c1be": position = battleInteracter.useitem1(); break;
                        case "c2be": position = battleInteracter.useitem2(); break;
                        case "c3be": position = battleInteracter.rollup(); break;
                        case "c4be": position = battleInteracter.rolldown(); break;
                        case "c5": position = battleInteracter.start(); break;
                    }
                    break;
                case "empty_inventory":
                    if (Objects.equals(yourChoice, "c5")){position = battleInteracter.start();} break;
                case "attack":
                    switch (yourChoice){
                        case "c1be": position = battleInteracter.hit1(); break;
                        case "c2be": position = battleInteracter.hit2(); break;
                        case "c3be": position = battleInteracter.hit3(); break;
                        case "c4be": position = battleInteracter.hit4(); break;
                        case "c5":position = "start"; position = battleInteracter.start(); break;
                } break;
                case "player_message":
                    if (Objects.equals(yourChoice, "c1be")){position = battleInteracter.playerMessage();}
                    break;
                case "enemy_message":
                    if (Objects.equals(yourChoice, "c1be")){position = battleInteracter.enemyMessage();}
                    break;
                case "lost":if (Objects.equals(yourChoice, "c4be")){
                    gp.gameState = gp.titleState;
                    opened = false;
                }break;
                ///////////////////////////////////////////////////////////////////////////////////////////////Lost here
                case "won":
                    if (Objects.equals(yourChoice, "c4be")){
                        position = battleInteracter.won();
                    }
                    break;
                case "finished":
                    if (Objects.equals(yourChoice, "c4be")){
                        opened = false;
                        status = false;
                        fighting = false;

                    }break;//////////////////////////////////////////////////////////////////////////////////Back to map
            }
        }
    }
}
