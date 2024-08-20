package presenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenter.SlotMachinePresenter;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SlotMachinePresenterTest {
    private JButton choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;
    private SlotMachinePresenter presenter;

    @BeforeEach
    void setUp() {
        mainTextArea = new JTextArea();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        presenter = new SlotMachinePresenter(mainTextArea, choice1, choice2, choice3, choice4);
    }

    @Test
    void play() {
        presenter.play();

        assertEquals("Here's a slot machine. You can pay 50$ to play:", mainTextArea.getText());
        assertEquals("Play", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }

    @Test
    void lackOfMoney() {
        presenter.lackOfMoney();

        assertEquals("You don't have enough money! You can pay 50$ to play:", mainTextArea.getText());
    }

    @Test
    void result() {
        presenter.result(20);

        assertEquals("You won 20$", mainTextArea.getText());
        assertEquals("Next", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());

    }

    @Test
    void broken() {
        presenter.broken();

        assertEquals("This slot machine is not working.", mainTextArea.getText());
        assertEquals("Kick it", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("-", choice4.getText());
    }

    @Test
    void finish() {
        presenter.finish();

        assertEquals("The slot machine fell to the ground and gave out a \" BANG!\" sound." +
                "You got your 500$ back. Thank you for playing!", mainTextArea.getText());
        assertEquals("-", choice1.getText());
        assertEquals("-", choice2.getText());
        assertEquals("-", choice3.getText());
        assertEquals("Leave", choice4.getText());
    }
}