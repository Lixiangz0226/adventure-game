package controller;

import entities.map_objects.DoorObject;
import entities.map_objects.GoalDoor;
import entities.map_objects.KeyObject;
import entities.visual_entities.Bat1;
import entities.visual_entities.NPC_Guide;
import entities.visual_entities.YoungKid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AssetSetterTest {

    private GamePanel gp;
    private AssetSetter assetSetter;

    @BeforeEach
    void setUp() throws IOException {
        // Initialize GamePanel and AssetSetter
        gp = new GamePanel();
        assetSetter = new AssetSetter(gp);
    }

    @Test
    void setObject() {
        // Call the method to set objects
        assetSetter.setObject();

        // Check the objects are correctly placed on the map
        assertTrue(gp.obj[0][0] instanceof KeyObject);
        assertEquals(13 * gp.tileSize, gp.obj[0][0].x);
        assertEquals(8 * gp.tileSize, gp.obj[0][0].y);

        assertTrue(gp.obj[0][1] instanceof DoorObject);
        assertEquals(8 * gp.tileSize, gp.obj[0][1].x);
        assertEquals(6 * gp.tileSize, gp.obj[0][1].y);

        assertTrue(gp.obj[0][2] instanceof GoalDoor);
        assertEquals(7 * gp.tileSize, gp.obj[0][2].x);
        assertEquals(0 * gp.tileSize, gp.obj[0][2].y);

        // Additional assertions can be added for other objects
    }

    @Test
    void setNPC() {
        // Call the method to set NPCs
        assetSetter.setNPC();

        // Check the NPCs are correctly placed on the map
        assertTrue(gp.npc[0][0] instanceof NPC_Guide);
        assertEquals(4 * gp.tileSize, gp.npc[0][0].x);
        assertEquals(4 * gp.tileSize, gp.npc[0][0].y);

        assertTrue(gp.npc[0][8] instanceof YoungKid);
        assertEquals(7 * gp.tileSize, gp.npc[0][8].x);
        assertEquals(2 * gp.tileSize, gp.npc[0][8].y);

        assertTrue(gp.npc[1][1] instanceof Bat1);
        assertEquals(9 * gp.tileSize, gp.npc[1][1].x);
        assertEquals(4 * gp.tileSize, gp.npc[1][1].y);

        // Additional assertions can be added for other NPCs
    }
}