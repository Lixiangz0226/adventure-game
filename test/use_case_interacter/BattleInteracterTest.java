package use_case_interacter;

import entities.stat_entities.Player;
import entities.stat_entities.Monsters.Goblin;
import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Weapons.Flame_Crossbow;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Objects;

class BattleInteracterTest {
    Player player = new Player("Dante", 50);
    BattleInteracter interacter = new BattleInteracter(new JButton(), new JButton(), new JButton(), new JButton(),
            new JPanel(), new JTextArea(), new JLabel(), new JLabel(), player, new Goblin());

    @Test
    void useitem1() {
        player.getInventory().addItem(new Life_Potion());
        // Check if the first item in the inventory is life potion, check the return value and the change of health.
        assert (player.getInventory().getItem(0).getClass() == Life_Potion.class);
        assert Objects.equals(interacter.useitem1(), "empty_inventory");
        assert player.getHealth() == 70;
        // Check if the first item is a flame crossbow, the return value after equipped, the weapon equipped, and the
        // original weapon is in the inventory.
        player.getInventory().addItem(new Flame_Crossbow());
        assert (player.getInventory().getItem(0).getClass() == Flame_Crossbow.class);
        assert Objects.equals(interacter.useitem1(), "items");
        assert Objects.equals(player.getWeaponName(), "Flame Crossbow");
        assert Objects.equals(player.getInventory().getItem(0).getName(), "Knife");
        // Check return values, weapon equipping, and life potion usage.
        player.getInventory().addItem(new Life_Potion());
        assert Objects.equals(interacter.useitem1(), "items");
        assert Objects.equals(player.getInventory().getItem(0).getClass(), Life_Potion.class);
        assert Objects.equals(player.getHealth(), 70);
        assert Objects.equals(interacter.useitem1(), "items");
        assert Objects.equals(player.getHealth(), 90);
        assert Objects.equals(player.getWeaponName(), "Knife");
        assert Objects.equals(player.getInventory().getItem(0).getName(), "Flame Crossbow");
    }

    @Test
    void useitem2() {

    }
}