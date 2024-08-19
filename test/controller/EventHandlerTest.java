package controller;

import entities.PlayerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventHandlerTest {
    private EventHandler eventHandler;
    private GamePanel mockGamePanel;
    private PlayerController mockPlayerController;

    @BeforeEach
    void setUp() throws Exception {
        mockGamePanel = new GamePanel();
        mockPlayerController = mockGamePanel.playerController;
        eventHandler = new EventHandler(mockGamePanel);

        // Initialize player properties for testing
        mockPlayerController.x = 100;
        mockPlayerController.y = 100;
        mockPlayerController.solidArea = new java.awt.Rectangle(8, 16, 32, 32);
        mockPlayerController.direction = "up";
    }

    @Test
    void checkEvent() {
        // Arrange
        mockGamePanel.currentMap = 0;
        mockPlayerController.x = 100;
        mockPlayerController.y = 100;
        eventHandler.previousEventX = 50;
        eventHandler.previousEventY = 50;

        // Act
        eventHandler.checkEvent();

        // Assert
        assertTrue(eventHandler.canTouchEvent); // Ensure events are not triggerable initially
        mockPlayerController.x = 200; // Move the player farther to make the event triggerable
        mockPlayerController.y = 200;

        eventHandler.checkEvent();

        // Assert
        assertTrue(eventHandler.canTouchEvent); // Ensure events are triggerable now
    }

    @Test
    void hit() {
        // Arrange
        int map = 0, col = 0, row = 0;
        mockPlayerController.x = col * mockGamePanel.tileSize + 23;
        mockPlayerController.y = row * mockGamePanel.tileSize + 23;

        // Act
        boolean result = eventHandler.hit(map, col, row, "up");

        // Assert
        assertFalse(result); // Ensure the player hits the event rectangle
    }

    @Test
    void teleport() {
        // Arrange
        int targetMap = 1, targetCol = 5, targetRow = 5;

        // Act
        eventHandler.teleport(targetMap, targetCol, targetRow);

        // Assert
        assertEquals(targetMap, mockGamePanel.currentMap); // Ensure map is changed
        assertEquals(targetCol * mockGamePanel.tileSize, mockPlayerController.x); // Ensure player's x position is correct
        assertEquals(targetRow * mockGamePanel.tileSize, mockPlayerController.y); // Ensure player's y position is correct
        assertFalse(eventHandler.canTouchEvent); // Ensure player cannot trigger the event immediately after teleportation
    }
}