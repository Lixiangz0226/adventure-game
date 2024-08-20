package UseCaseInteracter;

import entities.stat_entities.Player;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
class SlotMachineInteracterTest {

    Player player = new Player("Dante", 50);
    SlotMachineInteracter SlotMachine = new SlotMachineInteracter(new JTextArea(), new JButton(), new JButton(), new JButton(),
            new JButton(), player);

    @org.junit.jupiter.api.Test
    void play() {
        assert SlotMachine.play().equals("play");
    }

    @org.junit.jupiter.api.Test
    void result() {
        //Check if the slot machine rejects players without money
        player.setMoney(0);
        assert SlotMachine.result().equals("play");
        //Check if the slot machine accepts players with money
        player.setMoney(100);
        assert SlotMachine.result().equals("result");
    }

    @org.junit.jupiter.api.Test
    void broken() {
        player.setMoney(0);
        assert SlotMachine.result().equals("play");
        //Check if the player received 500 gold
        player.setMoney(100);
        SlotMachine.broken();
        assertEquals(player.getMoney(), 600);
        assert SlotMachine.broken().equals("broken");
    }

    @org.junit.jupiter.api.Test
    void finish() {
        assert SlotMachine.finish().equals("finish");
    }
}