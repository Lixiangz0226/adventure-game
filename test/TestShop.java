import OutsideEntities.Player;
import controller.EventController.ShopEvent;

public class TestShop {
    public static void main(String[] args) {
        Player player = new Player("Vergil", 100);
        player.setMoney(100);
        ShopEvent shop = new ShopEvent(player);
        shop.getWindow().setVisible(true);

        shop.run_event();
    }
}
