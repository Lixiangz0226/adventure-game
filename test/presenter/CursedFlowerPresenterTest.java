package presenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CursedFlowerPresenterTest {

    JTextArea mainTextArea;
    JButton choice1, choice2, choice3, choice4;
    CursedFlowerPresenter presenter;

    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        presenter = new CursedFlowerPresenter(mainTextArea, choice1, choice2, choice3, choice4);
    }

    @Test
    void start() {
        presenter.start();

        assertEquals("The cursed flower shines with a strange luster", mainTextArea.getText());
        assertEquals("Use purification potion", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void not_obtained() {
        presenter.not_obtained();

        assertEquals("You don't have a purification potion", mainTextArea.getText());
    }

    @Test
    void purified() {
        presenter.purified();

        assertEquals("The strange luster disappeared, but the flower shot a dim light pointing at a " +
                "patch of grass", mainTextArea.getText());
        assertEquals("Dig from it", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void dug() {
        presenter.dug();

        assertEquals("You found a crossbow. When you're picking it up, you could feel the heat of " +
                "the immortal flame burning at the front.", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void gotten() {
        presenter.gotten();

        assertEquals("You got Flame Crossbow.", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void finish() {
        presenter.finish();

        assertEquals("The flower is purified.", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }
}