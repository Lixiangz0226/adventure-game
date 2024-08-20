package presenter;


import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Items.PurificationPotion;
import entities.stat_entities.Monsters.Bat;
import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class BattlePresenterTest {

    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private JPanel backPanel;
    private JLabel hpLabelNumber, enemyhp;
    private Player player;
    private Monster monster;
    private BattlePresenter presenter;

    @BeforeEach
    public void setUp()
    {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        backPanel = new JPanel();
        hpLabelNumber = new JLabel();
        enemyhp = new JLabel();
        player = new Player("Dave",50);
        player.getInventory().addItem(new Life_Potion());
        player.getInventory().addItem(new PurificationPotion());
        monster = new Bat();
        monster.setHealth(50);

        presenter = new BattlePresenter(choice1, choice2, choice3, choice4, backPanel, mainTextArea, hpLabelNumber, enemyhp, player, monster);
    }

    @Test
    void testStart() {
        presenter.start();

        assertFalse(backPanel.isVisible());
        assertEquals("Suddenly, a Bat leaped out from nowhere!", mainTextArea.getText());
        assertEquals("Attack", choice1.getText());
        assertEquals("Items", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Run", choice4.getText());
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
    void testAttack() {
        presenter.attack();

        assertTrue(backPanel.isVisible());
        assertEquals("Put it in action!", mainTextArea.getText());
        assertEquals("Basic attack", choice1.getText());
        assertEquals(player.getSkills().get(0).getName(), choice2.getText());
        assertEquals(player.getSkills().get(1).getName(), choice3.getText());
        assertEquals(player.getSkills().get(2).getName(), choice4.getText());

    }

    @Test
    void testBotItems() {
        presenter.bot_items();

        assertEquals("You are already at the bottom of your inventory.\nChoose the item you wanna use:", mainTextArea.getText());
    }

    @Test
    void testAttacked() {
        presenter.attacked();

        assertTrue(backPanel.isVisible());
        assertEquals("Continue your victorious pursuit!", mainTextArea.getText());
        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("50" ,enemyhp.getText());
        assertEquals("Basic attack", choice1.getText());
        assertEquals(player.getSkills().get(0).getName(), choice2.getText());
        assertEquals(player.getSkills().get(1).getName(), choice3.getText());
        assertEquals(player.getSkills().get(2).getName(), choice4.getText());
    }

    @Test
    void testPlayerMessage() {
        presenter.player_message("I am Beautiful");

        assertFalse(backPanel.isVisible());
        assertEquals("I am Beautiful", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void testEnemyMessage() {
        presenter.enemy_message("I am the most Beautiful");
        assertFalse(backPanel.isVisible());
        assertEquals("I am the most Beautiful", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void testWon() {
        presenter.won();

        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("50" ,enemyhp.getText());
        assertEquals("You won! You found 50$ and a golden key!", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Next", choice4.getText());
    }

    @Test
    void testLost() {
        presenter.lost();

        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("50" ,enemyhp.getText());
        assertEquals("YOU DIED", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void testFinished() {
        presenter.finished();

        assertFalse(backPanel.isVisible());
        assertEquals("The Bat you defeated never moved again", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void testSkillNotAvailable() {
        presenter.skill_not_available();

        assertEquals("You have used the maximum times of this skill.", mainTextArea.getText());
    }

    @Test
    void testRenewHP() {
        presenter.renewHP();
        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("50" ,enemyhp.getText());
    }
}
