package Tests;

import OutsideEntities.Player;
import controller.EventController.SlotMachineEvent;

public class TestSlotMachine {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 50);
        player.setMoney(500);
        SlotMachineEvent event = new SlotMachineEvent(player);
        event.run_event();
    }
}
