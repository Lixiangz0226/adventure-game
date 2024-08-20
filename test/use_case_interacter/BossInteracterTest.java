package UseCaseInteracter;

import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Monsters.Cursed_Tree;
import OutsideEntities.Monsters.Goblin;
import OutsideEntities.Monsters.Monster;
import OutsideEntities.Player;
import OutsideEntities.Weapons.Flame_Crossbow;
import OutsideEntities.Weapons.Knife;
import OutsideEntities.Weapons.Spear;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BossInteracterTest {

    Player player = new Player("Dante", 50);
    Cursed_Tree tree = new Cursed_Tree();
    BossInteracter Boss = new BossInteracter(new JTextArea(), new JButton(), new JButton(), new JButton(), new JButton(),
            new JLabel(), new JLabel(), new JLabel(), new JPanel(), player, tree);

    @Test
    void start() {
        assert Boss.start().equals("start");
    }

    @Test
    void attack() {
        assert Boss.attack().equals("attack");
    }

    @Test
    void items() {
        //Check if player is unable to access items when it's bind
        Boss.setBindingRounds(3);
        assert Boss.items().equals("start");
        //Check if player has empty inventory
        Boss.setBindingRounds(0);
        assert Boss.items().equals("empty_inventory");
        //Check if player can access items if they have at least one
        player.getInventory().addItem(new Life_Potion());
        assert Boss.items().equals("items");
    }

    @Test
    void use1() {
        player.getInventory().addItem(new Life_Potion());
        // Check if the first item in the inventory is life potion, check the return value and the change of health.
        assert (player.getInventory().getItem(0).getClass() == Life_Potion.class);
        assert Objects.equals(Boss.use1(), "empty_inventory");
        assert player.getHealth() == 70;
        // Check if the first item is a flame crossbow, the return value after equipped, the weapon equipped, and the
        // original weapon is in the inventory.
        player.getInventory().addItem(new Flame_Crossbow());
        assert (player.getInventory().getItem(0).getClass() == Flame_Crossbow.class);
        assert Objects.equals(Boss.use1(), "items");
        assert Objects.equals(player.getWeaponName(), "Flame Crossbow");
        assert Objects.equals(player.getInventory().getItem(0).getName(), "Knife");
        // Check return values, weapon equipping, and life potion usage.
        player.getInventory().addItem(new Life_Potion());
        assert Objects.equals(Boss.use1(), "items");
        assert Objects.equals(player.getInventory().getItem(0).getClass(), Life_Potion.class);
        assert Objects.equals(player.getHealth(), 70);
        assert Objects.equals(Boss.use1(), "items");
        assert Objects.equals(player.getHealth(), 90);
        assert Objects.equals(player.getWeaponName(), "Knife");
        assert Objects.equals(player.getInventory().getItem(0).getName(), "Flame Crossbow");
    }

    @Test
    void use2() {
        //Check if the first item in the player's inventory is a flame crossbow and the second items is a life potion
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        assert (player.getInventory().getItem(0).getClass() == Flame_Crossbow.class);
        assert (player.getInventory().getItem(1).getClass() == Life_Potion.class);
        //Check if the second item in the inventory (potion) is used
        assert (player.getInventory().getLength() == 2);
        Boss.use2();
        assertEquals(player.getHealth(), 70);
        assert (player.getInventory().getLength() == 1);
        // Check if the second item is a flame crossbow, the return value after equipped, the weapon equipped, and the
        // original weapon is in the inventory.
        player.getInventory().addItem(new Flame_Crossbow());
        assert (player.getInventory().getItem(1).getClass() == Flame_Crossbow.class);
        assert Objects.equals(Boss.use2(), "items");
        assert Objects.equals(player.getWeaponName(), "Flame Crossbow");
        assert Objects.equals(player.getInventory().getItem(1).getName(), "Knife");
    }

    @Test
    void rollup() {
        assert Boss.rollup().equals("items");
    }

    @Test
    void rolldown() {
        assert Boss.rolldown().equals("items");
    }

    @Test
    void hit1() {
        //Check if basic attack is used with the Knife
        assert Boss.hit1().equals("player_message");
        tree.setHealth(1000);
        player.setWeapon(new Knife());
        Boss.hit1();
        assertEquals(996, tree.getHealth());
        //Check if basic attack can be used multiple times
        Boss.hit1();
        assertEquals(992, tree.getHealth());
    }

    @Test
    void hit2() {
        //Check if defend can be used the first time and deals no damage
        assert Boss.hit2().equals("player_message");
        tree.setHealth(1000);
        Boss.hit2();
        assertEquals(1000, tree.getHealth());
        //Check if defend can't be used the second time
        assert Objects.equals(Boss.hit2(), "attack");
    }

    @Test
    void hit3() {
        //Check if double edge can be used the first time and deals 30 damage
        assert Boss.hit3().equals("player_message");
        Boss.hit3();
        assertEquals(973, tree.getHealth());
        //Check if double edge can't be used the second time
        assert Objects.equals(Boss.hit3(), "attack");
    }

    @Test
    void hit4() {
        //Check if charge can be used the first time and deals no damage
        assert Boss.hit4().equals("player_message");
        tree.setHealth(1000);
        Boss.hit4();
        assertEquals(1000, tree.getHealth());
        //Check if charge can't be used the second time
        assert Objects.equals(Boss.hit4(), "attack");
    }

    @Test
    void player_message() {
        Boss.hit1();
        assert Boss.player_message().equals("enemy_message");
    }

    @Test
    void enemy_message() {
        //Check if player losses when hp is equal to zero
        player.setHealth(0);
        assert Boss.enemy_message().equals("lost");
        //Check if player is losses when hp is below zero
        player.setHealth(-5);
        assert Boss.enemy_message().equals("lost");
        //Check if player wins the battle when the boss' hp is equal to zero
        player.setHealth(10);
        tree.setHealth(0);
        assert Boss.enemy_message().equals("won");
        //Check if player wins the battle when the boss' hp is below zero
        tree.setHealth(-5);
        assert Boss.enemy_message().equals("won");
        //Check if the battle continues if none of the characters died
        tree.setHealth(10);
        assert Boss.enemy_message().equals("attack");
    }

    @Test
    void finished() {
        player.setKey(0);
        player.setMoney(0);
        Boss.finished();
        //Check if the victory rewards a golden key
        assertEquals(1, player.getKey());
        //Check if the player gained victory gold
        assertEquals(50, player.getMoney());
        assert Boss.finished().equals("finished");
    }

    @Test
    void setBindingRounds(){
        Boss.setBindingRounds(3);
        assertEquals(3, Boss.getBindingRounds());
    }

    @Test
    void getBindingRounds(){
        Boss.setBindingRounds(3);
        assertEquals(3, Boss.getBindingRounds());
    }
}