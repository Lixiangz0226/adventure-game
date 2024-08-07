package Tests;

import OutsideEntities.Player;
import controller.EventController.QueenSlimeEvent;

public class TestQueenSlime {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 25);
        QueenSlimeEvent queen = new QueenSlimeEvent(player);
        queen.getWindow().setVisible(true);

        queen.run_event();
    }
}
