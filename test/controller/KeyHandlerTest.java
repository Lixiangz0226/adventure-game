package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class KeyHandlerTest {

    private KeyHandler keyHandler;
    private GamePanel gamePanel;

    @BeforeEach
    void setUp() throws Exception {
        gamePanel = new GamePanel();
        keyHandler = new KeyHandler(gamePanel);
    }

    @Test
    void keyTyped() {
        // No implementation in keyTyped, no need to test
    }

    @Test
    void keyPressed() {
        //W pressed
        gamePanel.gameState = gamePanel.playState;
        KeyEvent event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyHandler.keyPressed(event);
        assertTrue(keyHandler.upPressed);

        //S pressed
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        keyHandler.keyPressed(event);
        assertTrue(keyHandler.downPressed);

        //D pressed
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyHandler.keyPressed(event);
        assertTrue(keyHandler.rightPressed);

        //A pressed
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        keyHandler.keyPressed(event);
        assertTrue(keyHandler.leftPressed);

        //Enter pressed
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');
        keyHandler.keyPressed(event);
        assertTrue(keyHandler.enterPressed);

        //I pressed
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_I, 'I');
        keyHandler.keyPressed(event);
        assertEquals(gamePanel.infoState, gamePanel.gameState);

        //P pressed
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_P, 'P');
        keyHandler.keyPressed(event);
        assertEquals(gamePanel.pauseState, gamePanel.gameState);

    }

    @Test
    void keyReleased() {

        //W released
        gamePanel.gameState = gamePanel.playState;
        KeyEvent event = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyHandler.keyReleased(event);
        assertFalse(keyHandler.upPressed);

        //S released
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        keyHandler.keyReleased(event);
        assertFalse(keyHandler.downPressed);

        //D released
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyHandler.keyReleased(event);
        assertFalse(keyHandler.rightPressed);

        //A released
        gamePanel.gameState = gamePanel.playState;
        event = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        keyHandler.keyReleased(event);
        assertFalse(keyHandler.leftPressed);
    }
}