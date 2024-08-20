package use_case_interacter;

import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Items.PiggyBank;
import entities.stat_entities.Weapons.Katana;
import entities.stat_entities.Weapons.Spear;
import entities.stat_entities.Weapons.Staff;
import entities.stat_entities.Player;
import presenter.MysteryBoxPresenter;

import javax.swing.*;
import java.util.Random;

public class MysteryBoxInteracter extends EventInteracter{
    /**
     * The use case interacter of mystery box event
     */
    private MysteryBoxPresenter presenter;
    private Player player;
    private Random rand = new Random();


    public MysteryBoxInteracter(JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                                JTextArea mainTextArea, Player player, JLabel hpLabelNumber, JLabel moneyNumber) {
        // Constructor
        this.player = player;
        this.presenter = new MysteryBoxPresenter(choice1, choice2, choice3, choice4, mainTextArea,
                 hpLabelNumber, moneyNumber, player);
    }

    public String start(){// The start use case
        presenter.start(); return "start";}

    public String talk(){// The story use case
        presenter.talk(); return "talk";}

    public String present1(){// The first present use case
        presenter.present1(); return "present1";}

    public String receive1(){// The use case randomly receiving present
        player.setMoney(player.getMoney() + 20);
        presenter.received("20$");
        return "receive1";
    }

    public String present2(){// The second present use case
        presenter.present2(); return "present2";}

    public String receive2(){// The use case randomly receiving different presents
        if (rand.nextInt(10) <= 2){
            // Unluckily
            if (rand.nextInt(2) == 0){
                // Lost money
                player.setMoney(player.getMoney() - 20);
                presenter.punished("You lost 20$");
            }
            else {
                // Lost health
                player.setHealth(player.getHealth() - 5);
                presenter.punished("You lost 5 HP");
            }
            return "receive2";
        }
        //luckily
        if (rand.nextInt(2) == 0){
            // Got money
            player.setMoney(player.getMoney() + 40);
            presenter.received("40$");
        }
        else {
            // Got Life Potion
            player.getInventory().addItem(new Life_Potion());
            presenter.received("a Life Potion");
        }
        return "receive2";
    }

    public String present3(){// The third present use case
        presenter.present3(); return "present3";}

    public String receive3(){// The use case randomly receiving different presents
        if (rand.nextInt(10) >= 5){
            // Unluckily
            if (rand.nextInt(2) == 0){
                // Lost money
                player.setMoney(player.getMoney() - 40);
                presenter.punished("You lost 40$");
            }
            else {
                // Lost health
                player.setHealth(player.getHealth() - 10);
                presenter.punished("You lost 10 HP");
            }
            return "receive3";
        }
        // Luckily
        int r = rand.nextInt(5);
        if (r == 0){
            // Got money
            player.setMoney(player.getMoney() + 120);
            presenter.received("120$");
        }
        else if (r == 1){
            // Got Life potion
            player.getInventory().addItem(new Life_Potion());
            player.getInventory().addItem(new Life_Potion());
            player.getInventory().addItem(new Life_Potion());
            presenter.received("three Life Potions");
        }
        else if (r == 2){
            // Got Katana
            player.getInventory().addItem(new Katana());
            presenter.received("Katana");
        }
        else if (r == 3){
            // Got Spear
            player.getInventory().addItem(new Spear());
            presenter.received("Spear");
        }
        else{
            player.getInventory().addItem(new Staff());
            presenter.received("Staff");
        }
        return "receive3";
    }

    public String present4(){// The forth present use case
        presenter.present4(); return "present4";}

    public String receive4(){// The use case randomly receiving different presents
        if (rand.nextInt(10) >= 3){
            // Unluckily
            if (rand.nextInt(2) == 0){
                // Lost money
                player.setMoney(player.getMoney() - 80);
                presenter.punished("You lost 80$");
            }
            else{
                // Lost health
                player.setHealth(player.getHealth() - 20);
                presenter.punished("You lost 20 HP");
            }
            return "receive4";
        }
        // Luckily
        int r = rand.nextInt(2);
        if (r == 0){
            // Got 10 Life Potions
            for (int i = 0; i < 10; i++){
                player.getInventory().addItem(new Life_Potion());
            }
            presenter.received("ten Life Potions");
        }
        else{
            // Got Piggy Bank
            player.getInventory().addItem(new PiggyBank());
            presenter.received("A Piggy Bank");
        }
        return "receive4";
    }

    public String finish(){// The finished use case
        presenter.finish();
        return "finish";
    }
}
