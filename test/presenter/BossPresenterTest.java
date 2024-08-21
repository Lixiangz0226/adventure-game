package presenter;


import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Items.PurificationPotion;
import entities.stat_entities.Monsters.Cursed_Tree;
import entities.stat_entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;


import static org.junit.jupiter.api.Assertions.*;

class BossPresenterTest {

    JLabel hpLabelNumber, enemyhp;
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private JLabel weaponLabel;
    private JPanel backPanel;
    private Player player;
    private Cursed_Tree boss;
    private BossPresenter presenter;


    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        weaponLabel = new JLabel();
        backPanel = new JPanel();
        hpLabelNumber = new JLabel();
        enemyhp = new JLabel();
        player = new Player("Dave",50);
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new PurificationPotion());
        boss = new Cursed_Tree();

        presenter =  new BossPresenter(mainTextArea, choice1, choice2, choice3, choice4, hpLabelNumber, enemyhp, weaponLabel, backPanel, player, boss);
    }

    @Test
    void testStart() {
        presenter.start(6);

        assertFalse(backPanel.isVisible());
        assertEquals("You look up at the Cursed Tree that reaches over 30 meters. " +
                "As you sense its wicked presence, you understand the final battle has come.", mainTextArea.getText());
        assertEquals("Attack", choice1.getText());
        assertEquals("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void testItems() {
        presenter.items(0, 1);

        assertTrue(backPanel.isVisible());
        assertEquals("Choose the item you wanna use:", mainTextArea.getText());
        assertEquals("Life Potion", choice1.getText());
        assertEquals("Purification Potion", choice2.getText());
        assertEquals("Previous Page", choice3.getText());
        assertEquals("Next Page", choice4.getText());

    }

    @Test
    void testEmptyInventory() {
        player.getInventory().removeAll();
        presenter.empty_inventory();

        assertTrue(backPanel.isVisible());
        assertEquals("Your inventory is empty!", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("Previous Page", choice3.getText());
        assertEquals("Next Page", choice4.getText());
    }

    @Test
    void testTopItems() {
        presenter.top_items();

        assertEquals("You are already at the top of your inventory.\nChoose the item you wanna use:", mainTextArea.getText());

    }

    @Test
    void testBotItems() {
        presenter.bot_items();

        assertEquals("You are already at the bottom of your inventory.\nChoose the item you wanna use:", mainTextArea.getText());
    }

    @Test
    void attack() {
        presenter.attack();

        assertTrue(backPanel.isVisible());
        assertEquals("There's no way back!", mainTextArea.getText());
        assertEquals("Basic attack", choice1.getText());
        assertEquals(player.getSkills().get(0).getName(), choice2.getText());
        assertEquals(player.getSkills().get(1).getName(), choice3.getText());
        assertEquals(player.getSkills().get(2).getName(), choice4.getText());
    }

    @Test
    void attacked() {
        presenter.attacked();

        assertTrue(backPanel.isVisible());
        assertEquals("Don't give up!", mainTextArea.getText());
        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("1000" ,enemyhp.getText());
        assertEquals("Basic attack", choice1.getText());
        assertEquals(player.getSkills().get(0).getName(), choice2.getText());
        assertEquals(player.getSkills().get(1).getName(), choice3.getText());
        assertEquals(player.getSkills().get(2).getName(), choice4.getText());
    }

    @Test
    void renewHP() {
        presenter.renewHP();

        assertEquals("50" ,hpLabelNumber.getText());
    }

    @Test
    void renewWeapon() {
        presenter.renewWeapon();
        assertEquals("Weapon: " + "Knife" ,weaponLabel.getText());
    }

    @Test
    void player_message() {
        presenter.player_message("I am a loser");

        assertFalse(backPanel.isVisible());
        assertEquals("I am a loser", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void enemy_message() {
        presenter.enemy_message("I am a bigger loser");

        assertFalse(backPanel.isVisible());
        assertEquals("I am a bigger loser", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void won() {
        presenter.won();

        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("1000" ,enemyhp.getText());
        assertEquals("You won! The Cursed Tree turned to ashes and fell to the ground.", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Next", choice4.getText());
    }

    @Test
    void lost() {
        presenter.lost();

        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("1000" ,enemyhp.getText());
        assertEquals("YOU DIED", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void skill_not_available() {
        presenter.skill_not_available();

        assertEquals("You have used the maximum times of this skill.", mainTextArea.getText());
    }

    @Test
    void finished() {
        presenter.finished();

        assertFalse(backPanel.isVisible());
        assertEquals("Only ashes were left on the ground", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }
}