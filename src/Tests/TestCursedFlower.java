package Tests;

import OutsideEntities.Items.PurificationPotion;
import OutsideEntities.Player;
import controller.EventController.CursedFlowerEvent;

public class TestCursedFlower {

    public static void main(String[] args) {
        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new PurificationPotion());
        CursedFlowerEvent event = new CursedFlowerEvent(player);
        event.run_event();
    }
}
