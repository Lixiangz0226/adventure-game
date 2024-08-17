import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Items.PiggyBank;
import OutsideEntities.Player;
import OutsideEntities.Weapons.*;
import data_access.LoadPlayer;
import data_access.SavePlayer;

import java.io.IOException;

class SavePlayerTest {

    public static void main(String[] args) throws IOException {
        Player player = new Player("test", 1234);
        player.setKey(99);
        player.setMoney(888);
        player.setWeapon(new Spear());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new PiggyBank());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Flame_Crossbow());

        SavePlayer savePlayer = new SavePlayer(player);

        savePlayer.save();

        LoadPlayer loadPlayer = new LoadPlayer();
        loadPlayer.load();
    }
}