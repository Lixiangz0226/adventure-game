package Presenter;

import OutsideEntities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MysteryBoxPresenterTest {

    private JButton choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;
    private JLabel hpLabelNumber;
    private JLabel moneyNumber;
    private Player player;
    private MysteryBoxPresenter presenter;

    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        hpLabelNumber =  new JLabel();
        moneyNumber = new JLabel();
        player = new Player("Dave",50);
        presenter = new MysteryBoxPresenter(choice1, choice2, choice3, choice4, mainTextArea,hpLabelNumber,moneyNumber,player);
    }

    @Test
    void start() {
        presenter.start();
        assertEquals("Old witch: Come here, Young adventurer! I have four presents for you.", mainTextArea.getText());
        assertEquals("What are you doing?", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void talk() {
        presenter.talk();
        assertEquals("Old witch: The crystal ball has shown me: only you would break the seal and release the cursed soul from that tree. I'm just giving you a little push.", mainTextArea.getText());
        assertEquals("What are you giving me?", choice1.getText());
    }

    @Test
    void present1() {
        presenter.present1();
        assertEquals("Old witch: The first present has a 0% chance to be harmful. Are you gonna receive it?", mainTextArea.getText());
        assertEquals("Hmm, I'll take it.", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void received() {
        presenter.received("a healing potion");
        assertEquals("You received a healing potion", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void punished() {
        presenter.punished("You lost 10 health points.");
        assertEquals("You lost 10 health points.", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void present2() {
        presenter.present2();
        assertEquals("Old witch: The second present has a 30% chance to be harmful, but it's more valuable than the first one if you're lucky. Are you gonna receive it?", mainTextArea.getText());
        assertEquals("I'll take it.", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void present3() {
        presenter.present3();
        assertEquals("Old witch: The third present has a 50% chance to be harmful, but it's more valuable than the second one if you're lucky. Are you gonna receive it?", mainTextArea.getText());
        assertEquals("Grab it", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void present4() {
        presenter.present4();
        assertEquals("Old witch: The final present has a 70% chance to be harmful, but it's more valuable than the third one if you're lucky. Are you gonna receive it?", mainTextArea.getText());
        assertEquals("Just give it to me!", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void finish() {
        presenter.finish();
        assertEquals("Old witch: Don't get too greedy, my friend!", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }
}