package Tests;

import entities.OutsideEntities.Items.PurificationPotion;
import entities.Player;
import controller.EventController.CursedFlowerEvent;

public class TestCursedFlower {

    public static void main(String[] args) {
        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new PurificationPotion());
        CursedFlowerEvent event = new CursedFlowerEvent(player);
        event.getWindow().setVisible(true);

        event.run_event();
    }
}
