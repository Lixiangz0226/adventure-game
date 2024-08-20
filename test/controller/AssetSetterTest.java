package controller;

import Objects.DoorObject;
import Objects.GoalDoor;
import Objects.KeyObject;
import Objects.Object;
import Objects.SuperKey;
import entities.Entity;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the AssetSetter class.
 * 
 * This class verifies that objects and NPCs are correctly instantiated and 
 * placed on the game maps by the AssetSetter.
 */
class AssetSetterTest {

    GamePanel gp;
    AssetSetter assetSetter;

    @BeforeEach
    void setUp() throws IOException {
        // Mock the GamePanel class
        gp = new GamePanel();

        // Mock the obj and npc arrays with a specific size
        gp.obj = new Object[4][10];  // Assuming 4 maps and up to 10 objects per map
        gp.npc = new Entity[4][10];      // Assuming 4 maps and up to 10 NPCs per map

        // Mock the tileSize property
        gp.tileSize = 32;  // Example tile size, adjust as needed

        // Initialize AssetSetter with the mocked GamePanel
        assetSetter = new AssetSetter(gp);
    }

    @BeforeEach
    void setObject() {
        // Act: Call the setObject method
        assetSetter.setObject();

        // Assert: Check if objects are placed correctly
        assertTrue(gp.obj[0][0] instanceof KeyObject);
        assertEquals(13 * gp.tileSize, gp.obj[0][0].x);
        assertEquals(8 * gp.tileSize, gp.obj[0][0].y);

        assertTrue(gp.obj[0][1] instanceof DoorObject);
        assertEquals(8 * gp.tileSize, gp.obj[0][1].x);
        assertEquals(6 * gp.tileSize, gp.obj[0][1].y);

        assertTrue(gp.obj[0][2] instanceof GoalDoor);
        assertEquals(7 * gp.tileSize, gp.obj[0][2].x);
        assertEquals(0 * gp.tileSize, gp.obj[0][2].y);

        assertTrue(gp.obj[0][3] instanceof SuperKey);
        assertEquals(7 * gp.tileSize, gp.obj[0][3].x);
        assertEquals(8 * gp.tileSize, gp.obj[0][3].y);

    }

    @Test
    void setNPC() {
        // Act: Call the setNPC method
        assetSetter.setNPC();

        // Assert: Check if NPCs are placed correctly on map 0
        assertTrue(gp.npc[0][0] instanceof NPC_Guide);
        assertEquals(4 * gp.tileSize, gp.npc[0][0].x);
        assertEquals(4 * gp.tileSize, gp.npc[0][0].y);

        assertTrue(gp.npc[0][1] instanceof Goblin);
        assertEquals(7 * gp.tileSize, gp.npc[0][1].x);
        assertEquals(4 * gp.tileSize, gp.npc[0][1].y);

        // Assert: Check NPCs on map 1
        assertTrue(gp.npc[1][2] instanceof Bat1);
        assertEquals(9 * gp.tileSize, gp.npc[1][2].x);
        assertEquals(4 * gp.tileSize, gp.npc[1][2].y);

        assertTrue(gp.npc[1][3] instanceof Bat2);
        assertEquals(4 * gp.tileSize, gp.npc[1][3].x);
        assertEquals(3 * gp.tileSize, gp.npc[1][3].y);

        assertTrue(gp.npc[1][4] instanceof Bat3);
        assertEquals(5 * gp.tileSize, gp.npc[1][4].x);
        assertEquals(6 * gp.tileSize, gp.npc[1][4].y);

        // Assert: Check NPCs on map 2
        assertTrue(gp.npc[2][5] instanceof CursedFlower);
        assertEquals(5 * gp.tileSize, gp.npc[2][5].x);
        assertEquals(6 * gp.tileSize, gp.npc[2][5].y);

        // Assert: Check NPCs on map 3
        assertTrue(gp.npc[3][5] instanceof CursedTree);
        assertEquals(4 * gp.tileSize, gp.npc[3][5].x);
        assertEquals(1 * gp.tileSize, gp.npc[3][5].y);
    }
}
