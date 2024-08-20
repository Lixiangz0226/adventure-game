import OutsideEntities.Items.*;
import OutsideEntities.Monsters.*;
import OutsideEntities.Player;
import OutsideEntities.Weapons.*;
import controller.EventController.*;
import controller.GamePanel;

import java.io.IOException;

public class TestBattle {
    public static void main(String[] args) throws IOException {
        Player player = new Player("Vergil", 50);
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Flame_Crossbow());
        player.getInventory().addItem(new Knife());
        player.getInventory().addItem(new Spear());
        player.getInventory().addItem(new Staff());

//        BattleEvent battle = new BattleEvent(player, new Bat());
        BattleEvent battle = new BattleEvent(player, new Goblin(), new GamePanel());

        battle.getWindow().setVisible(true);

        battle.runEvent();
    }
}
