package controller.EventController;

import entities.stat_entities.Monsters.Goblin0;
import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;
import use_case_interacter.GuidingInteracter;
import view.EventView.GuidingViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GuidingEvent extends Event {
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private static String position;
    private boolean firsttime = true;
    JLabel hpLabelNumber; JLabel enemyhp; JPanel backPanel;
    private JButton backButton;
    private GuidingViewModel viewModel;
    private GuidingInteracter interacter;
    private Monster monster = new Goblin0();
    public boolean opened = true;

    ChoiceHandler choiceHandler = new ChoiceHandler();

    public GuidingEvent(Player player) {////////////////////////////////////////////////////////////////////Create here
        /*
        Initializer of the event.
         */

        viewModel = new GuidingViewModel(player, monster);

        status = true;
        fighting = false;

        mainTextArea = viewModel.getMainTextArea();
        this.position = "";
        hpLabelNumber = viewModel.getHpLabelNumber();
        enemyhp = viewModel.getEnemyhp();
        backPanel = viewModel.getBackPanel();
        choice1 = viewModel.getChoice1();
        choice2 = viewModel.getChoice2();
        choice3 = viewModel.getChoice3();
        choice4 = viewModel.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        backButton = viewModel.getBackButton();
        backButton.addActionListener(choiceHandler);

        interacter = new GuidingInteracter(choice1, choice2, choice3, choice4, backPanel, mainTextArea, hpLabelNumber,
                enemyhp, player, monster);
    }

    public void runEvent(){////////////////////////////////////////////////////////////////////////////////////Run here
        /*
          Run this event.
          If the player hasn't defeated the monster, fight the monster; if yes, then show the
          finished slide to the player.
         */
        if(firsttime){position = interacter.chasing();}
        else {position = interacter.finished();}
    }

    public Window getWindow(){/* Get the window */return viewModel.getWindow();}

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            switch(position){
                case "chasing": if (Objects.equals(yourChoice, "c1be")) {position = interacter.start(); break;}
                case "start":
                    switch(yourChoice){
                        case "c1be": position = interacter.attack(); break;
                        case "c2be": position = interacter.items(); break;
                    }
                    break;
                case "items":
                    switch(yourChoice){
                        case "c1be": position = interacter.useitem1(); break;
                        case "c2be": position = interacter.useitem2(); break;
                        case "c3be": position = interacter.rollup(); break;
                        case "c4be": position = interacter.rolldown(); break;
                        case "c5": position = interacter.start(); break;
                    }
                    break;
                case "empty_inventory":
                    if (Objects.equals(yourChoice, "c5")){position = interacter.start();} break;
                case "attack":
                    switch (yourChoice){
                        case "c1be": position = interacter.hit1(); break;
                        case "c2be": position = interacter.hit2(); break;
                        case "c3be": position = interacter.hit3(); break;
                        case "c4be": position = interacter.hit4(); break;
                        case "c5": position = "start"; position = interacter.start(); break;
                    } break;
                case "player_message":
                    if (Objects.equals(yourChoice, "c1be")){position = interacter.playerMessage();}
                    break;
                case "enemy_message":
                    if (Objects.equals(yourChoice, "c1be")){position = interacter.enemyMessage();}
                    break;
                case "lost":if (Objects.equals(yourChoice, "c4be")){}break;
                ///////////////////////////////////////////////////////////////////////////////////////////////Lost here
                case "won":
                    if (Objects.equals(yourChoice, "c4be")){
                        firsttime = false;
                        position = interacter.won();
                    }
                    break;
                case "finished":
                    if (Objects.equals(yourChoice, "c4be")){position = interacter.talk1();}break;
                case "talk1":
                    switch (yourChoice){
                        case "c1be", "c2be", "c3be": position = interacter.talk2(); break;
                    }break;
                case "talk2":
                    switch (yourChoice){
                        case "c1be", "c2be": position = interacter.talk3(); break;
                    }break;
                case "talk3":
                    switch (yourChoice){
                        case "c1be", "c2be": position = interacter.talk4(); break;
                    }break;
                case "talk4":
                    switch (yourChoice){
                        case "c1be", "c2be": position = interacter.talk5(); break;
                    }break;
                case "talk5":
                    if (Objects.equals(yourChoice, "c1be")){
                        opened = false; fighting = false; break;/////////////////////////////////////////////////////////////////Leave
                    }break;


            }
        }
    }
}


