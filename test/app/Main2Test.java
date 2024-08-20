package app;

import controller.GamePanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Main2Test {

    @Test
    void mainTest() throws IOException {
        // Run the main method
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Elden Keys");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();

        // Check JFrame properties
        assertEquals("Elden Keys", window.getTitle(), "The JFrame title should be 'Elden Keys'");
        assertNotNull(window, "The JFrame should not be null");
        assertFalse(window.isResizable(), "The JFrame should not be resizable");
        assertTrue(window.isVisible(), "The JFrame should be visible");

        // Check the content of the JFrame
        Component[] components = window.getContentPane().getComponents();
        assertEquals(1, components.length, "The JFrame should contain exactly one component");

        assertTrue(components[0] instanceof GamePanel, "The component in the JFrame should be an instance of GamePanel");

        gamePanel = (GamePanel) components[0];
        assertNotNull(gamePanel, "The GamePanel should not be null");
    }

}