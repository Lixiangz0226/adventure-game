package use_case_interacter;

import entities.stat_entities.Monsters.Cursed_Tree;
import entities.stat_entities.Player;
import entities.stat_entities.Skills.Basic_attack;
import presenter.BossPresenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BossInteracter extends EventInteracter{
    /**
     * The use case interacter of the boss fight
     */
    private Player player; Cursed_Tree boss;
    private BossPresenter presenter;
    private int m;
    private int current, used1, used2, used3;
    private List<String> message;
    private int bindingRounds = 0;
    private int r;
    Random rand = new Random();
    Basic_attack basic_attack = new Basic_attack();

    public BossInteracter(JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                          JLabel hpLabelNumber, JLabel enemyhp, JLabel weaponLabel, JPanel backPanel, Player player,
                          Cursed_Tree boss) {// Constructor
        this.player = player;
        this.boss = boss;

        presenter = new BossPresenter(mainTextArea, choice1, choice2, choice3, choice4, hpLabelNumber, enemyhp,
                weaponLabel, backPanel, player, boss);

        this.used1 = player.getSkills().get(0).getTimes();
        this.used2 = player.getSkills().get(1).getTimes();
        this.used3 = player.getSkills().get(2).getTimes();
        this.m = player.getInventory().getLength() / 2;
        this.current = 0;
        this.message = new ArrayList<String>();
    }

    public String start(){// The start use case
        presenter.start(bindingRounds); return "start";}

    public String attack(){// The attack use case
        presenter.attack();return "attack";}

    public String items(){// The items use case
        if (bindingRounds > 0){return "start";}
        if (player.getInventory().getLength() == 0){
            presenter.empty_inventory();
            return "empty_inventory";}
        presenter.items(current,m);
        return  "items";
    }

    public String use1(){// The use case the player using the first item
        if(player.use_item(current)){presenter.items(current,m);}
        else {
            if (player.getInventory().getLength() == 0) {
                presenter.empty_inventory();
                return "empty_inventory";}
            else {
                current = 0;
                m = player.getInventory().getLength() / 2;
                presenter.renewHP();
                presenter.items(current,m);
                return "items";}
        }
        presenter.renewWeapon();
        return "items";
    }

    public String use2(){// The use case the player using the second item
        if (current + 1>=player.getInventory().getLength()){return "items";}
        if(player.use_item(current + 1)){presenter.items(current,m); return "items";}
        else {
            current = 0;
            m = player.getInventory().getLength() / 2;
            presenter.renewHP();
            presenter.items(current,m);}
        presenter.renewWeapon();
        return "items";
    }

    public String rollup(){// The use case rolling up the inventory
        if (current - 2 < 0){presenter.top_items(); }
        else{current -= 2;presenter.items(current,m); }
        return "items";
    }

    public String rolldown(){// The use case rolling down the inventory
        if (player.getInventory().getLength() % 2 == 1){
            if (current + 2 > 2 * m){presenter.bot_items();}
            else {current += 2; presenter.items(current,m); return "items";}
        }
        else {
            if (current + 2 >= 2 * m){presenter.bot_items(); }
            else {current += 2; presenter.items(current,m); return "items";}
        }
        return "items";
    }

    public String hit1(){// The use case using the first skill
        r = rand.nextInt(10);
        boss.setRandint(r);
        if (r == 4 || r == 5){bindingRounds = 3;}
        bindingRounds -= 1;
        message = player.hit(boss, basic_attack);
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit2(){// The use case using the second skill
        if (used1 == 0){presenter.skill_not_available(); return "attack";}
        used1 -= 1;
        r = rand.nextInt(10);
        boss.setRandint(r);
        if (r == 4 || r == 5){bindingRounds = 3;}
        bindingRounds -= 1;
        message = player.hit(boss, player.getSkills().getFirst());
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit3(){// The use case using the third skill
        if (used2 == 0){presenter.skill_not_available();return "attack";}
        used2 -= 1;
        r = rand.nextInt(10);
        boss.setRandint(r);
        if (r == 4 || r == 5){bindingRounds = 3;}
        bindingRounds -= 1;
        message = player.hit(boss, player.getSkills().get(1));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String hit4(){// The use case using the forth skill
        if (used3 == 0){presenter.skill_not_available();return "attack";}
        used3 -= 1;
        r = rand.nextInt(10);
        boss.setRandint(r);
        if (r == 4 || r == 5){bindingRounds = 3;}
        bindingRounds -= 1;
        message = player.hit(boss, player.getSkills().get(2));
        presenter.player_message(message.getFirst());
        return "player_message";
    }

    public String player_message(){// The use case presenting the message
        presenter.enemy_message(message.getLast());
        return "enemy_message";
    }

    public String enemy_message(){// The use case presenting the message
        if (player.getHealth()<=0){presenter.lost(); return "lost";}
        else if (boss.getHealth()<=0){presenter.won(); return "won";}
        presenter.attacked();
        return  "attack";
    }

    public String finished(){// The reward and finishing use case
        player.add_key();
        player.setMoney(player.getMoney() + 50);
        presenter.finished();
        return "finished";
    }

    public void setBindingRounds(int rounds){
        bindingRounds = rounds;
    }

    public int getBindingRounds(){
        return bindingRounds;
    }
}
