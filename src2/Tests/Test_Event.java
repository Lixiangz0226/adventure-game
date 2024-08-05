package Tests;

import OutsideEntities.*;
import OutsideEntities.Items.*;
import OutsideEntities.Monsters.*;
import OutsideEntities.States.PiggyBanking;
import OutsideEntities.Weapons.*;
import controller.EventHandler.*;

import java.awt.Container;

import javax.swing.*;

//Tests the functionality of the events in rooms
public class Test_Event {

    public static void main(String[] args) {
        new Test_Event();
    }

    //Creates the event screen
    public Test_Event() {
//        test_shop0();
        test_battle();
//        test_Queen_Slime_event();
//        test_boss();
//        test_guide();
//        test_Mysery_Box();
//        test_Slot_Machine();
//        test_Flower();
        test_info();
    }


    //Simulates a shop event with 99999 money
    public void test_shop0() {
        Player player = new Player("Vergil", 100);
        player.setMoney(50);
        ShopEvent0 shop = new ShopEvent0(player);
        shop.run_event();
        while (shop.shopOpened) {
            // Wait until shopOpened is false
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test_Queen_Slime_event(){
        Player player = new Player("Vergil", 25);
        QueenSlimeEvent queen = new QueenSlimeEvent(player);
        queen.run_event();
    }


    //Simulates a battle event with weapons and potions
    public void test_battle(){
        Player player = new Player("Vergil", 10);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Spear());
        player.getInventory().addItem(new Staff());

        BattleEvent battle = new BattleEvent(player, new Bat());
        battle.run_event();
    }

    public void test_boss(){
        Player player = new Player("Vergil", 300);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());

        CursedTreeEvent cursedTree = new CursedTreeEvent(player);
        cursedTree.run_event();
    }

    public void test_guide(){
        Player player = new Player("Vergil", 30);
        GuidingEvent event = new GuidingEvent(player);
        event.run_event();
    }

    public void test_Mysery_Box(){
        Player player = new Player("Vergil", 50);
        MysteryBoxEvent event = new MysteryBoxEvent(player);
        event.run_event();
    }

    public void test_Slot_Machine(){
        Player player = new Player("Vergil", 50);
        player.setMoney(500);
        SlotMachineEvent event = new SlotMachineEvent(player);
        event.run_event();
    }

    public void test_Flower(){
        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new PurificationPotion());
        CursedFlowerEvent event = new CursedFlowerEvent(player);
        event.run_event();
    }

    public void test_info(){
        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new PurificationPotion());
        player.add_state(new PiggyBanking());
        PlayerInfo event = new PlayerInfo(player);
        event.run_event();
    }
}
