package presenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class QueenSlimePresenterTest {
    private JButton choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;
    private QueenSlimePresenter presenter;

    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        presenter = new QueenSlimePresenter(mainTextArea, choice1, choice2, choice3, choice4);
    }

    @Test
    void start() {
        presenter.start();

        assertEquals("The Queen slime was heavily injured, do you want to help her?", mainTextArea.getText());
        assertEquals("Help her", choice1.getText());
        assertEquals("Kill her", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void saved() {
        presenter.saved();

        assertEquals("You helped the Queen, and she rewards you with a golden key", mainTextArea.getText());
        assertEquals("Leave", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void killed() {
        presenter.killed();
        assertEquals("You killed the Queen, and she dropped 200 Golds.", mainTextArea.getText());
        assertEquals("Leave", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }
}