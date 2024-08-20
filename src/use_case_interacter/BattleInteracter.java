package use_case_interacter;

import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;
import entities.stat_entities.Skills.Basic_attack;
import presenter.BattlePresenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BattleInteracter {
    /**
     * The use case interacter of battle event
     */
    private Player player;
    private Monster monster;
    private int m; private int current, used1, used2, used3;
    private BattlePresenter presenter;
    private List<String> message = new ArrayList<String>();
    Basic_attack basic_attack = new Basic_attack();

    public BattleInteracter(JButton choice1, JButton choice2, JButton choice3, JButton choice4, JPanel backPanel,
                            JTextArea mainTextArea, JLabel hpLabelNumber, JLabel enemyhp, Player player,
                            Monster monster) {// Constructor
        this.monster = monster;
        this.player = player;
        this.used1 = player.getSkills().get(0).getTimes(); this.used2 = player.getSkills().get(1).getTimes();
        this.used3 = player.getSkills().get(2).getTimes();
        this.m = player.getInventory().getLength() / 2;
        this.current = 0;

        presenter = new BattlePresenter(choice1, choice2, choice3, choice4, backPanel, mainTextArea, hpLabelNumber,
                enemyhp, player, monster);
    }

    public List<String> getMessage() {
        return message;
    }

    public String start(){// Start use case
        presenter.start(); return "start";}

    public String finished(){// Finished use case
        presenter.finished(); return "finished";}

    public String attack(){// Attack use case
        presenter.attack(); return "attack";}

    public String items(){// Items use case
        if (player.getInventory().getLength() == 0){
            presenter.empty_inventory();
            return "empty_inventory";}
        m = player.getInventory().getLength() / 2;
        presenter.items(current,m);
        return "items";
    }

    public String useitem1(){// Use item1
        if(player.use_item(current)){presenter.items(current,m);}
        else {
            if (player.getInventory().getLength() == 0) {
                presenter.empty_inventory();
                return  "empty_inventory";}
            current = 0;
            presenter.renewHP();
            m = player.getInventory().getLength() / 2;
            presenter.items(current,m);
        }
        return "items";
    }

    public String useitem2(){// Use item2
        if (current + 1>=player.getInventory().getLength()){return "items";}
        if(player.use_item(current + 1)){presenter.items(current,m);}
        else {
            current = 0;
            presenter.renewHP();
            m = player.getInventory().getLength() / 2;
            presenter.items(current,m);}
        return "items";
    }

    public String rollup(){// Scroll up items
        if (current - 2 < 0){presenter.top_items();}
        else{current -= 2; presenter.items(current,m);}
        return "items";
    }

    public String rolldown(){// Scroll down items
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

    public String hit1(){// Hit using the basic attack
        message = player.hit(monster, basic_attack);
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit2(){// Hit using the second skill
        if (used1 == 0){presenter.skill_not_available(); return "attack";}
        used1 -= 1;
        message = player.hit(monster, player.getSkills().getFirst());
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit3(){// Hit using the third skill
        if (used2 == 0){presenter.skill_not_available(); return "attack";}
        used2 -= 1;
        message = player.hit(monster, player.getSkills().get(1));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit4(){// Hit using the forth skill
        if (used3 == 0){presenter.skill_not_available();return "attack";}
        used3 -= 1;
        message = player.hit(monster, player.getSkills().get(2));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String playerMessage(){// Player message use case
        presenter.enemy_message(message.getLast());
        return "enemy_message";
    }

    public String enemyMessage(){// Enemy message use case
        if (player.getHealth()<=0){
            presenter.lost();
            return "lost";}
        else if (monster.getHealth()<=0){
            presenter.won();
            return "won";}
        presenter.attacked();
        return "attack";
    }

    public String won(){// Won use case
        player.add_key();
        player.setMoney(player.getMoney() + monster.getGoldDrop());
        presenter.finished();
        return "finished";
    }
}
