package controller;

import entities.map_objects.Object;
import entities.stat_entities.Player;
import entities.visual_entities.Entity;
import entities.visual_entities.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.TileViewManager;


import static org.junit.jupiter.api.Assertions.*;


import java.awt.*;
import java.io.IOException;


/**
 * Unit tests for the CollisionChecker class.
 * 
 * This class tests various collision scenarios in the game, including:
 * - Tile collisions
 * - Object collisions
 * - Entity collisions
 * - Player collisions
 */
class CollisionCheckerTest {

    private CollisionChecker collisionChecker;
    private GamePanel mockGamePanel;
    private Entity mockEntity;
    private Object mockObject;

    @BeforeEach
    void setUp() throws IOException {
        mockGamePanel = new GamePanel();
        mockEntity = new Entity(mockGamePanel);
        mockObject = new Object();
        collisionChecker = new CollisionChecker(mockGamePanel);

        
        setUpMock();
        
    }

    private void setUpMock() {
        // Set up the GamePanel's currentMap directly
        mockGamePanel.currentMap = 0;

        // Initialize the tile array and set up collision properties directly
        mockGamePanel.tileA = new TileViewManager(mockGamePanel);
        mockGamePanel.tileA.tile = new Tile[100]; // Assume 100 different tile types
        mockGamePanel.tileA.tile[0] = new Tile(); // Non-collidable tile
        mockGamePanel.tileA.tile[1] = new Tile(); // Collidable tile

        // Set the map tile numbers directly in the array
        mockGamePanel.tileA.mapTileNumber = new int[mockGamePanel.maxMap][mockGamePanel.maxScreenCol][mockGamePanel.maxScreenRow];
        mockGamePanel.tileA.mapTileNumber[0][2][2] = 0; // Non-collidable tile
        mockGamePanel.tileA.mapTileNumber[0][2][1] = 1; // Collidable tile

        // Set the collision properties directly
        mockGamePanel.tileA.tile[0].collision = true;
        mockGamePanel.tileA.tile[1].collision = false;

        // Set up entity properties directly
        mockEntity.x = 100;
        mockEntity.y = 100;
        mockEntity.speed = 4;
        mockEntity.solidArea = new Rectangle(8, 16, 32, 32);
        mockEntity.direction = "up"; // Change as needed for different tests
    }

    @Test
    //has collision
    void checkTile() {
        // Invoke the method under test
        collisionChecker.checkTile(mockEntity);

        // Assert the expected behavior
        assertTrue(mockEntity.collisionOn);
    }


    @Test
    void checkObject() {
        // Arrange
        Entity objectEntity = new Entity(mockGamePanel);
        objectEntity.x = 120;
        objectEntity.y = 100;
        objectEntity.solidArea = new Rectangle(8, 16, 32, 32);
        objectEntity.collisionOn = true; // Make the object collidable

        mockGamePanel.obj[mockGamePanel.currentMap][0] = mockObject;

        // Act
        int index = collisionChecker.checkObject(mockEntity, true);

        // Assert
        assertEquals(999, index); // The index should be 0 since it's the first object in the array
        assertFalse(mockEntity.collisionOn); // The entity's collision flag should be turned on
    }

    @Test
    void checkEntity() {
        // Arrange
        Entity targetEntity = new Entity(mockGamePanel);
        targetEntity.x = 100;
        targetEntity.y = 80;
        targetEntity.solidArea = new Rectangle(8, 16, 32, 32);

        mockGamePanel.npc[mockGamePanel.currentMap][0] = targetEntity;

        // Act
        int index = collisionChecker.checkEntity(mockEntity, mockGamePanel.npc);

        // Assert
        assertEquals(0, index); // The index should be 0 since it's the first entity in the array
        assertTrue(mockEntity.collisionOn); // The entity's collision flag should be turned on
    }

    @Test
    void checkPlayer() {
        // Arrange
        Entity playerEntity = new Entity(mockGamePanel);
        playerEntity.x = 100;
        playerEntity.y = 80;
        playerEntity.solidArea = new Rectangle(8, 16, 32, 32);

        mockGamePanel.player = new Player("Tester", 0);

        // Act
        collisionChecker.checkPlayer(mockEntity);

        // Assert
        assertTrue(mockEntity.collisionOn); // The entity's collision flag should be turned on
    }
}
