package use_case_interacter;

import entities.stat_entities.Items.PurificationPotion;
import entities.stat_entities.Player;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CursedFlowerInteracterTest {
    Player player = new Player("Dante", 50);
    CursedFlowerInteracter CursedFlower = new CursedFlowerInteracter(new JTextArea(), new JButton(), new JButton(), new JButton(),
            new JButton(), player);

    @Test
    void start() {
        assert CursedFlower.start().equals("start");
    }

    @Test
    void purified() {
        //Check if not having purification potion rejects purification
        assert CursedFlower.purified().equals("start");
        //Check if having purification potion proceeds purification
        player.getInventory().addItem(new PurificationPotion());
        assert CursedFlower.purified().equals("purified");
        //Check if purification potion gets used up after the purification
        assert CursedFlower.purified().equals("start");
    }

    @Test
    void dug() {
        assert CursedFlower.dug().equals("dug");
    }

    @Test
    void gotten() {
        //Check if player obtained the flame crossbow
        CursedFlower.gotten();
        assertEquals(player.getInventory().getItem(0).getName(), "Flame Crossbow");
        assert CursedFlower.gotten().equals("gotten");
    }

    @Test
    void finish() {
        assert CursedFlower.finish().equals("finish");
    }
}