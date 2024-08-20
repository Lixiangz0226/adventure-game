package UseCaseInteracter;

import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Player;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInfoInteracterTest {
    Player player = new Player("Dante", 50);
    PlayerInfoInteracter Info = new PlayerInfoInteracter(player, new JTextArea(), new JButton(), new JButton(), new JButton(),
            new JButton());

    @Test
    void start() {
        assert Info.start().equals("start");
    }

    @Test
    void inventory() {
        //description of life potion is stated int he inventory
        player.getInventory().addItem(new Life_Potion());
        Info.start();
        assert Info.inventory().equals("inventory");
    }

    @Test
    void upInv() {
        assert Info.upInv().equals("inventory");
    }

    @Test
    void downInv() {
        player.getInventory().addItem(new Life_Potion());
        Info.start();
        assert Info.downInv().equals("inventory");
    }

    @Test
    void skills() {
        Info.start();
        assert Info.skills().equals("skills");
    }

    @Test
    void upSkill() {
        Info.start();
        assert Info.upSkill().equals("skills");
    }

    @Test
    void downSkill() {
        Info.start();
        assert Info.downSkill().equals("skills");
    }

    @Test
    void states() {
        Info.start();
        assert Info.states().equals("states");
    }

    @Test
    void upState() {
        Info.start();
        assert Info.upState().equals("states");
    }

    @Test
    void downState() {
        Info.start();
        assert Info.downState().equals("states");
    }
}