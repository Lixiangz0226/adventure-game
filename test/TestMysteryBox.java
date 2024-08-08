import OutsideEntities.Player;
import controller.EventController.MysteryBoxEvent;

public class TestMysteryBox {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 50);
        MysteryBoxEvent event = new MysteryBoxEvent(player);
        event.getWindow().setVisible(true);

        event.run_event();
    }
}
