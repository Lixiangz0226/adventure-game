package use_case_interacter;

import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;
import entities.stat_entities.Skills.Basic_attack;
import presenter.GuidingPresenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GuidingInteracter extends EventInteracter{
    /**
     * The use case interacter of guiding event
     */
    private Player player;
    private Monster monster;
    private int m; private int current, used1, used2, used3;
    private GuidingPresenter presenter;
    private List<String> message = new ArrayList<String>();
    Basic_attack basic_attack = new Basic_attack();

    public GuidingInteracter(JButton choice1, JButton choice2, JButton choice3, JButton choice4, JPanel backPanel,
                            JTextArea mainTextArea, JLabel hpLabelNumber, JLabel enemyhp, Player player,
                            Monster monster) {//Constructor
        this.monster = monster;
        this.player = player;
        this.used1 = player.getSkills().get(0).getTimes(); this.used2 = player.getSkills().get(1).getTimes();
        this.used3 = player.getSkills().get(2).getTimes();
        this.m = player.getInventory().getLength() / 2;
        this.current = 0;
        presenter = new GuidingPresenter(choice1, choice2, choice3, choice4, backPanel, mainTextArea, hpLabelNumber,
                enemyhp, player, monster);
    }
    public String chasing(){// The use case of the story
        presenter.chasing(); return "chasing";}

    public String start(){// The start use case
        presenter.start(); return "start";}

    public String finished(){// The finished use case
        presenter.finished(); return "finished";}

    public String attack(){// The attack use case
        presenter.attack(); return "attack";}

    public String items(){// The items use case
        if (player.getInventory().getLength() == 0){
            presenter.empty_inventory();
            return "empty_inventory";}
        m = player.getInventory().getLength() / 2;
        presenter.items(current,m);
        return "items";
    }

    public String useitem1(){// The use case the player using the first item
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

    public String useitem2(){// The use case the player using the second item
        if (current + 1>=player.getInventory().getLength()){return "items";}
        if(player.use_item(current + 1)){presenter.items(current,m);}
        else {
            current = 0;
            presenter.renewhp();
            m = player.getInventory().getLength() / 2;
            presenter.items(current,m);}
        return "items";
    }

    public String rollup(){// The use case rolling up the inventory
        if (current - 2 < 0){presenter.top_items();}
        else{current -= 2; presenter.items(current,m);}
        return "items";
    }

    public String rolldown(){// The use case rolling down the inventory
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

    public String hit1(){// The use case using the first skill
        message = player.hit(monster, basic_attack);
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit2(){// The use case using the second skill
        if (used1 == 0){presenter.skill_not_available(); return "attack";}
        used1 -= 1;
        message = player.hit(monster, player.getSkills().getFirst());
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit3(){// The use case using the third skill
        if (used2 == 0){presenter.skill_not_available(); return "attack";}
        used2 -= 1;
        message = player.hit(monster, player.getSkills().get(1));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit4(){// The use case using the forth skill
        if (used3 == 0){presenter.skill_not_available();return "attack";}
        used3 -= 1;
        message = player.hit(monster, player.getSkills().get(2));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String playerMessage(){// The use case presenting the message
        presenter.enemy_message(message.getLast());
        return "enemy_message";
    }

    public String enemyMessage(){// The use case presenting the message
        if (player.getHealth()<=0){
            presenter.lost();
            return "lost";}
        else if (monster.getHealth()<=0){
            presenter.won();
            return "won";}
        presenter.attacked();
        return "attack";
    }

    public String won(){// The reward use case
        player.add_key();
        player.setMoney(player.getMoney() + monster.getGoldDrop());
        presenter.finished();
        return "finished";
    }

    public String talk1(){// The story use case
        presenter.talk1();
        return "talk1";
    }

    public String talk2(){// The story use case
        presenter.talk2();
        return "talk2";
    }

    public String talk3(){// The story use case
        presenter.talk3();
        return "talk3";
    }

    public String talk4(){// The story use case
        presenter.talk4();
        return "talk4";
    }

    public String talk5(){// The story use case
        presenter.talk5();
        return "talk5";
    }
}
