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

class GuidingPresenterTest {
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private JPanel backPanel;
    private JLabel hpLabelNumber, enemyhp;
    private Player player;
    private Monster monster;
    private GuidingPresenter presenter;

    @BeforeEach
    void setUp() {
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

         presenter = new GuidingPresenter(choice1, choice2, choice3, choice4, backPanel,
                mainTextArea, hpLabelNumber, enemyhp, player, monster);
    }

    @Test
    void chasing() {
        presenter.chasing();

        assertEquals("A Goblin is chasing a ten-year-old kid!", mainTextArea.getText());
        assertEquals("Fight", choice1.getText());
        assertEquals("Items", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void talk1() {
        presenter.talk1();

        assertEquals("The little kid: Thanks! You are so powerful! Why?", mainTextArea.getText());
        assertEquals("I'm well trained.", choice1.getText());
        assertEquals("This doesn't matter.", choice2.getText());
        assertEquals("But why are you here?", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void talk2() {
        presenter.talk2();

        assertEquals("The little kid: My Grandpa was a great warrior. I'm going to beat that evil and withered tree, just like grandpa!", mainTextArea.getText());
        assertEquals("Leave it to me.", choice1.getText());
        assertEquals("That's why I'm here!", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void talk3() {
        presenter.talk3();

        assertEquals("The little kid: Really!? Can you find my grandpa's crossbow? It will help you, I promise!", mainTextArea.getText());
        assertEquals("Why will it help?", choice1.getText());
        assertEquals("Go home, little friend.", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void talk4() {
        presenter.talk4();

        assertEquals("The little kid: It always burns and never goes out. It can burn that tree to ashes!", mainTextArea.getText());
        assertEquals("I'll find that crossbow.", choice1.getText());
        assertEquals("Where is it?", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void talk5() {
        presenter.talk5();

        assertEquals("My dad said it was buried near a strange flower. Good luck!", mainTextArea.getText());
        assertEquals("Thank you, warrior!", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void start() {
        presenter.start();

        assertFalse(backPanel.isVisible());
        assertEquals("Kill the Bat!", mainTextArea.getText());
        assertEquals("Attack", choice1.getText());
        assertEquals("Items", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void items() {
    presenter.items(0,1);
    assertTrue(backPanel.isVisible());

    assertEquals("Choose the item you wanna use:", mainTextArea.getText());
    assertEquals("Life Potion", choice1.getText());
    assertEquals("Purification Potion", choice2.getText());
    assertEquals("Previous Page", choice3.getText());
    assertEquals("Next Page", choice4.getText());

    }


    @Test
    void empty_inventory() {
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
    void top_items() {
        presenter.top_items();

        assertEquals("You are already at the top of your inventory.\nChoose the item you wanna use:", mainTextArea.getText());
    }

    @Test
    void attack() {
        presenter.attack();

        assertTrue(backPanel.isVisible());
        assertEquals("Put it in action!", mainTextArea.getText());
        assertEquals("Basic attack", choice1.getText());
        assertEquals(player.getSkills().get(0).getName(), choice2.getText());
        assertEquals(player.getSkills().get(1).getName(), choice3.getText());
        assertEquals(player.getSkills().get(2).getName(), choice4.getText());
    }

    @Test
    void bot_items() {
        presenter.bot_items();

        assertEquals("You are already at the bottom of your inventory.\nChoose the item you wanna use:", mainTextArea.getText());
    }

    @Test
    void attacked() {
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
    void player_message() {
        presenter.player_message("I am ");

        assertFalse(backPanel.isVisible());
        assertEquals("I am ", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void enemy_message() {
        presenter.enemy_message("I am the ");
        assertFalse(backPanel.isVisible());
        assertEquals("I am the ", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void won() {
        presenter.won();

        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("50" ,enemyhp.getText());
        assertEquals("You won! You found 30$ and a golden key!", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Next", choice4.getText());
    }

    @Test
    void lost() {
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
    void finished() {
        presenter.finished();

        assertFalse(backPanel.isVisible());
        assertEquals("The Bat you defeated never moved again", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Next", choice4.getText());
    }

    @Test
    void skill_not_available() {
        presenter.skill_not_available();

        assertEquals("You have used the maximum times of this skill.", mainTextArea.getText());
    }

    @Test
    void renewhp() {
        presenter.renewhp();
        assertEquals("50" ,hpLabelNumber.getText());
        assertEquals("50" ,enemyhp.getText());
    }
}

