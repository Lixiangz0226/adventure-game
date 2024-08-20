package use_case_interacter;

import entities.stat_entities.Player;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MysteryBoxInteracterTest {

    Player player = new Player("Dante", 50);
    MysteryBoxInteracter Mysterybox = new MysteryBoxInteracter(new JButton(), new JButton(), new JButton(),
            new JButton(), new JTextArea(), player, new JLabel(), new JLabel());

    @Test
    void start() {
        assert Mysterybox.start().equals("start");
    }

    @Test
    void talk() {
        assert Mysterybox.talk().equals("talk");
    }

    @Test
    void present1() {
        assert Mysterybox.present1().equals("present1");
    }

    @Test
    void receive1() {
        //Check if the player receives 20 gold
        player.setMoney(100);
        Mysterybox.receive1();
        assertEquals(player.getMoney(), 120);
        assert Mysterybox.receive1().equals("receive1");
    }

    @Test
    void present2() {
        assert Mysterybox.present2().equals("present2");
    }

    @Test
    void receive2() {
        assert Mysterybox.receive2().equals("receive2");
    }

    @Test
    void present3() {
        assert Mysterybox.present3().equals("present3");
    }

    @Test
    void receive3() {
        assert Mysterybox.receive3().equals("receive3");
    }

    @Test
    void present4() {
        assert Mysterybox.present4().equals("present4");
    }

    @Test
    void receive4() {
        assert Mysterybox.receive4().equals("receive4");
    }

    @Test
    void finish() {
        assert Mysterybox.finish().equals("finish");
    }
}