import OutsideEntities.Player;
import OutsideEntities.Weapons.Flame_Crossbow;
import controller.EventController.PlayerInfo;
import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Items.PurificationPotion;
import OutsideEntities.States.PiggyBanking;
import controller.GamePanel;

public class TestPlayerInfo {
    public static void main(String[] args) {

        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new PurificationPotion());
        player.addState(new PiggyBanking());
        PlayerInfo event = new PlayerInfo(player, new GamePanel());
        event.getWindow().setVisible(true);
        event.runEvent();
    }
}
