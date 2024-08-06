package UseCaseInteracter;

import OutsideEntities.Monsters.Monster;
import OutsideEntities.Player;
import OutsideEntities.Skills.Basic_attack;
import Presenter.GuidingPresenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BattleInteracter {
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private JPanel backPanel;
    private JLabel hpLabelNumber, enemyhp;
    private Player player;
    private Monster monster;
    private boolean firsttime;
    private int m; private int current, used1, used2, used3;
    private GuidingPresenter presenter;
    private List<String> message = new ArrayList<String>();
    private JButton backButton;
    Basic_attack basic_attack = new Basic_attack();

    public BattleInteracter(JButton choice1, JButton choice2, JButton choice3, JButton choice4, JPanel backPanel,
                            JTextArea mainTextArea, JLabel hpLabelNumber, JLabel enemyhp, Player player,
                            Monster monster) {
        this.monster = monster;
        this.player = player;
        this.firsttime = true;
        this.used1 = player.getSkills().get(0).getTimes(); this.used2 = player.getSkills().get(1).getTimes();
        this.used3 = player.getSkills().get(2).getTimes();
        this.m = player.getInventory().getLength() / 2;
        this.current = 0;

        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.backPanel = backPanel;

        this.mainTextArea = mainTextArea;
        this.hpLabelNumber = hpLabelNumber;
        this.enemyhp = enemyhp;

        presenter = new GuidingPresenter(choice1, choice2, choice3, choice4, backPanel, mainTextArea, hpLabelNumber,
                enemyhp, player, monster);
    }

    public String start(){
        presenter.start(); return "start";}

    public String finished(){
        presenter.finished(); return "finished";}

    public String attack(){
        presenter.attack(); return "attack";}

    public String items(){
        if (player.getInventory().getLength() == 0){
            presenter.empty_inventory();
            return "empty_inventory";}
        m = player.getInventory().getLength() / 2;
        presenter.items(current,m);
        return "items";
    }

    public String useitem1(){
        if(player.use_item(current)){presenter.items(current,m);}
        else {
            if (player.getInventory().getLength() == 0) {
                presenter.empty_inventory();
                return  "empty_inventory";}
            current = 0;
            presenter.renewhp();
            m = player.getInventory().getLength() / 2;
            presenter.items(current,m);
        }
        return "items";
    }

    public String useitem2(){
        if (current + 1>=player.getInventory().getLength()){return "items";}
        if(player.use_item(current + 1)){presenter.items(current,m);}
        else {
            current = 0;
            presenter.renewhp();
            m = player.getInventory().getLength() / 2;
            presenter.items(current,m);}
        return "items";
    }

    public String rollup(){
        if (current - 2 < 0){presenter.top_items();}
        else{current -= 2; presenter.items(current,m);}
        return "items";
    }

    public String rolldown(){
        if (player.getInventory().getLength() % 2 == 1){
            if (current + 2 > 2 * m){presenter.bot_items();}
            else {current += 2; presenter.items(current,m);}
        }
        else {
            if (current + 2 >= 2 * m){presenter.bot_items();}
            else {current += 2; presenter.items(current,m);}
        }
        return "items";
    }

    public String hit1(){
        message = player.hit(monster, basic_attack);
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit2(){
        if (used1 == 0){presenter.skill_not_available(); return "attack";}
        used1 -= 1;
        message = player.hit(monster, player.getSkills().getFirst());
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit3(){
        if (used2 == 0){presenter.skill_not_available(); return "attack";}
        used2 -= 1;
        message = player.hit(monster, player.getSkills().get(1));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit4(){
        if (used3 == 0){presenter.skill_not_available();return "attack";}
        used3 -= 1;
        message = player.hit(monster, player.getSkills().get(2));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String playerMessage(){
        presenter.enemy_message(message.getLast());
        return "enemy_message";
    }

    public String enemyMessage(){
        if (player.getHealth()<=0){
            presenter.lost();
            return "lost";}
        else if (monster.getHealth()<=0){
            presenter.won();
            return "won";}
        presenter.attacked();
        return "attack";
    }

    public String won(){
        player.add_key();
        player.setMoney(player.getMoney() + monster.getGoldDrop());
        presenter.finished();
        return "finished";
    }
}
