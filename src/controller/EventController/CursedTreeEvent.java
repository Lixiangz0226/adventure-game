package controller.EventController;

import entities.stat_entities.Monsters.Cursed_Tree;
import entities.stat_entities.Player;
import use_case_interacter.BossInteracter;
import controller.GamePanel;
import view.EventView.BossViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CursedTreeEvent extends Event {
    /**
     * The final boss fight.
     */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Cursed_Tree boss;
    private static String position;
    JLabel hpLabelNumber; JLabel enemyhp; JPanel backPanel; JButton backButton;
    private JLabel weaponLabel;

    private GamePanel gp;
    private BossViewModel bossViewModel;
    private BossInteracter interacter;
    public Boolean status;


    ChoiceHandler choiceHandler = new ChoiceHandler();

    public CursedTreeEvent(Player player, GamePanel gp) {///////////////////////////////////////////////////////Create here
        /*
        Initializer of the event.
         */
        this.boss = new Cursed_Tree();
        this.position = "";
        this.gp = gp;
        status = true;

        bossViewModel = new BossViewModel(player, boss);
        this.mainTextArea = bossViewModel.getMainTextArea();

        choice1 = bossViewModel.getChoice1();
        choice2 = bossViewModel.getChoice2();
        choice3 = bossViewModel.getChoice3();
        choice4 = bossViewModel.getChoice4();
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        weaponLabel = bossViewModel.getWeaponLabel();
        backPanel = bossViewModel.getBackPanel();
        backButton = bossViewModel.getBackButton();
        backButton.addActionListener(choiceHandler);
        hpLabelNumber = bossViewModel.getHpLabelNumber();
        enemyhp = bossViewModel.getEnemyhp();

        interacter = new BossInteracter(mainTextArea, choice1, choice2, choice3, choice4, hpLabelNumber, enemyhp,
                weaponLabel, backPanel, player, boss);
    }

    public Window getWindow() {/* Get Game Window */return bossViewModel.getWindow();}

    public void runEvent(){////////////////////////////////////////////////////////////////////////////////////Run here
        /*
          Run this event.
          If the player hasn't defeated the monster, fight the monster; if yes, then show the
          finished slide to the player.
         */
        if(status){position = interacter.start();}
        else {position = interacter.finished();}
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /*
            Listens to the choice button actions and then take actions.
             */

            String yourChoice = event.getActionCommand();

            switch(position){
                case "start":
                    switch(yourChoice){
                        case "c1ce": position = interacter.attack(); break;
                        case "c2ce": position = interacter.items(); break;
                    }
                    break;
                case "items":
                    switch(yourChoice){
                        case "c1ce": position = interacter.use1(); break;
                        case "c2ce": position = interacter.use2(); break;
                        case "c3ce": position = interacter.rollup(); break;
                        case "c4ce": position = interacter.rolldown(); break;
                        case "c5": position = interacter.start(); break;
                    }
                    break;
                case "empty_inventory":
                    if (Objects.equals(yourChoice, "c5")){position = interacter.start();} break;
                case "attack":
                    switch (yourChoice){
                        case "c1ce": position = interacter.hit1(); break;
                        case "c2ce": position = interacter.hit2(); break;
                        case "c3ce": position = interacter.hit3(); break;
                        case "c4ce": position = interacter.hit4(); break;
                        case "c5": position = interacter.start(); break;
                    } break;
                case "player_message":
                    if (Objects.equals(yourChoice, "c1ce")){position = interacter.player_message();}
                    break;
                case "enemy_message":
                    if (Objects.equals(yourChoice, "c1ce")){position = interacter.enemy_message();}
                    break;
                case "lost":if (Objects.equals(yourChoice, "c4ce")){
                    gp.gameState = gp.titleState;
                    opened = false;
                    ///////////////////////////////////////////////////////////////////////////////////////////Game lost
                }break;
                case "won":
                    if (Objects.equals(yourChoice, "c4ce")){position = interacter.finished();}
                    break;
                case "finished":
                    if (Objects.equals(yourChoice, "c4ce")){
                        ////////////////////////////////////////////////////////////////////////////////////////Game Won
                        opened = false;
                        status = false;
                    }break;
            }
        }
    }
}
