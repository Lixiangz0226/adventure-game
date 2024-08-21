package presenter;

import entities.stat_entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInfoPresenterTest {
    private JTextArea mainTextArea;
    private JButton choice1, choice2, choice3, choice4;
    private PlayerInfoPresenter presenter;

    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        presenter = new PlayerInfoPresenter(mainTextArea, choice1, choice2, choice3, choice4, new JLabel(), new JLabel(),
                new Player("..", 50));
    }

    @Test
    void start() {
        presenter.start();

        assertEquals("Info:", mainTextArea.getText());
        assertEquals("Inventory", choice1.getText());
        assertEquals("Skills", choice2.getText());
        assertEquals("States", choice3.getText());
        assertEquals("Save Game", choice4.getText());
    }

    @Test
    void describe() {
        String description = "Dave has 50 HP.";
        presenter.describe(description);

        assertEquals(description, mainTextArea.getText());
        assertEquals("Previous", choice1.getText());
        assertEquals("Next", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());

    }
}