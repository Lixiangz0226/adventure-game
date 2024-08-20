package use_case_interacter;

import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Monsters.Goblin;
import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;
import entities.stat_entities.Weapons.Flame_Crossbow;
import entities.stat_entities.Weapons.Knife;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GuidingInteracterTest {

    Player player = new Player("Dante", 50);
    Monster goblin = new Goblin();
    GuidingInteracter Guide = new GuidingInteracter(new JButton(), new JButton(), new JButton(), new JButton(),
            new JPanel(), new JTextArea(), new JLabel(), new JLabel(), player, goblin);

    @Test
    void chasing() {
        assert Guide.chasing().equals("chasing");
    }

    @Test
    void start() {
        assert Guide.start().equals("start");
    }

    @Test
    void finished() {
        assert Guide.finished().equals("finished");
    }

    @Test
    void attack() {
        assert Guide.attack().equals("attack");
    }

    @Test
    void items() {
        //Check if the items command returns empty inventory when the player has no items
        assert Guide.items().equals("empty_inventory");
        //Check if items display when the player has items
        player.getInventory().addItem(new Life_Potion());
        assert Guide.items().equals("items");
    }

    @Test
    void useitem1() {
        player.getInventory().addItem(new Life_Potion());
        // Check if the first item in the inventory is life potion, check the return value and the change of health.
        assert (player.getInventory().getItem(0).getClass() == Life_Potion.class);
        assert Objects.equals(Guide.useitem1(), "empty_inventory");
        assert player.getHealth() == 70;
        // Check if the first item is a flame crossbow, the return value after equipped, the weapon equipped, and the
        // original weapon is in the inventory.
        player.getInventory().addItem(new Flame_Crossbow());
        assert (player.getInventory().getItem(0).getClass() == Flame_Crossbow.class);
        assert Objects.equals(Guide.useitem1(), "items");
        assert Objects.equals(player.getWeaponName(), "Flame Crossbow");
        assert Objects.equals(player.getInventory().getItem(0).getName(), "Knife");
        // Check return values, weapon equipping, and life potion usage.
        player.getInventory().addItem(new Life_Potion());
        assert Objects.equals(Guide.useitem1(), "items");
        assert Objects.equals(player.getInventory().getItem(0).getClass(), Life_Potion.class);
        assert Objects.equals(player.getHealth(), 70);
        assert Objects.equals(Guide.useitem1(), "items");
        assert Objects.equals(player.getHealth(), 90);
        assert Objects.equals(player.getWeaponName(), "Knife");
        assert Objects.equals(player.getInventory().getItem(0).getName(), "Flame Crossbow");
    }

    @Test
    void useitem2() {
        //Check if the first item in the player's inventory is a flame crossbow and the second items is a life potion
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        assert (player.getInventory().getItem(0).getClass() == Flame_Crossbow.class);
        assert (player.getInventory().getItem(1).getClass() == Life_Potion.class);
        //Check if the second item in the inventory (potion) is used
        assert (player.getInventory().getLength() == 2);
        Guide.useitem2();
        assertEquals(player.getHealth(), 70);
        assert (player.getInventory().getLength() == 1);
        // Check if the second item is a flame crossbow, the return value after equipped, the weapon equipped, and the
        // original weapon is in the inventory.
        player.getInventory().addItem(new Flame_Crossbow());
        assert (player.getInventory().getItem(1).getClass() == Flame_Crossbow.class);
        assert Objects.equals(Guide.useitem2(), "items");
        assert Objects.equals(player.getWeaponName(), "Flame Crossbow");
        assert Objects.equals(player.getInventory().getItem(1).getName(), "Knife");
    }

    @Test
    void rollup() {
        assert Guide.rollup().equals("items");
    }

    @Test
    void rolldown() {
        assert Guide.rolldown().equals("items");
    }

    @Test
    void hit1() {
        //Check if basic attack is used with the Knife
        assert Guide.hit1().equals("player_message");
        goblin.setHealth(24);
        player.setWeapon(new Knife());
        Guide.hit1();
        assertEquals(19, goblin.getHealth());
        //Check if basic attack can be used multiple times
        Guide.hit1();
        assertEquals(14, goblin.getHealth());
    }

    @Test
    void hit2() {
        //Check if defend can be used the first time and deals no damage
        assert Guide.hit2().equals("player_message");
        goblin.setHealth(24);
        Guide.hit2();
        assertEquals(24, goblin.getHealth());
        //Check if defend can't be used the second time
        assert Objects.equals(Guide.hit2(), "attack");
    }

    @Test
    void hit3() {
        //Check if double edge can be used the first time and deals 30 damage
        assert Guide.hit3().equals("player_message");
        goblin.setHealth(50);
        Guide.hit3();
        assertEquals(50, goblin.getHealth());
        //Check if double edge can't be used the second time
        assert Objects.equals(Guide.hit3(), "attack");
    }

    @Test
    void hit4() {
        //Check if charge can be used the first time and deals no damage
        assert Guide.hit4().equals("player_message");
        Guide.hit4();
        goblin.setHealth(24);
        assertEquals(24, goblin.getHealth());
        //Check if charge can't be used the second time
        assert Objects.equals(Guide.hit4(), "attack");
    }

    @Test
    void playerMessage() {
        Guide.hit1();
        assert Guide.playerMessage().equals("enemy_message");
    }

    @Test
    void enemyMessage() {
        //Check if player losses when hp is equal to zero
        player.setHealth(0);
        assert Guide.enemyMessage().equals("lost");
        //Check if player is losses when hp is below zero
        player.setHealth(-5);
        assert Guide.enemyMessage().equals("lost");
        //Check if player wins the battle when the monster's hp is equal to zero
        player.setHealth(10);
        goblin.setHealth(0);
        assert Guide.enemyMessage().equals("won");
        //Check if player wins the battle when the monster's hp is below zero
        goblin.setHealth(-5);
        assert Guide.enemyMessage().equals("won");
        //Check if the battle continues if none of the characters died
        goblin.setHealth(10);
        assert Guide.enemyMessage().equals("attack");
    }

    @Test
    void won() {
        player.setKey(0);
        player.setMoney(0);
        Guide.won();
        //Check if the victory rewards a golden key
        assertEquals(1, player.getKey());
        //Check if the player gained victory gold
        assertEquals(20, player.getMoney());
        assert Guide.won().equals("finished");
    }

    @Test
    void talk1() {
        assert Guide.talk1().equals("talk1");
    }

    @Test
    void talk2() {
        assert Guide.talk2().equals("talk2");
    }

    @Test
    void talk3() {
        assert Guide.talk3().equals("talk3");
    }

    @Test
    void talk4() {
        assert Guide.talk4().equals("talk4");
    }

    @Test
    void talk5() {
        assert Guide.talk4().equals("talk4");
    }
}