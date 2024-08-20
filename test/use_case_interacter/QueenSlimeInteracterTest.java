package use_case_interacter;

import entities.stat_entities.Player;
import org.junit.jupiter.api.Test;
import use_case_interacter.QueenSlimeInteracter;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class QueenSlimeInteracterTest {
    Player player = new Player("Dante", 50);
    QueenSlimeInteracter Queen = new QueenSlimeInteracter(new JTextArea(), new JButton(), new JButton(), new JButton(),
            new JButton(), player);

    @Test
    void start() {
        assert Queen.start().equals("start");
    }

    @Test
    void saved() {
        //Check if saving the queen rewards a key
        player.setKey(0);
        Queen.saved();
        assertEquals(player.getKey(), 1);
        assert Queen.saved().equals("saved");
    }

    @Test
    void killed() {
        //Check if killing the queen rewards 200 gold
        player.setMoney(100);
        Queen.killed();
        assertEquals(player.getMoney(), 300);
        assert Queen.killed().equals("killed");
    }
}