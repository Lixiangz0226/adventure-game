package data_access;

import controller.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoadEventTest {
    private GamePanel gp;
    private SaveEvent saveEvent;
    private LoadEvent loadEvent;

    @BeforeEach
    void setUp() throws IOException {
        gp = new GamePanel();
        saveEvent = new SaveEvent();
        loadEvent = new LoadEvent();
    }

    @Test
    void load() throws IOException {
        // Test original state
        saveEvent.save(gp);
        loadEvent.load(gp);
        assertEquals(gp.cursedFlower.position, "start");
        assertEquals(gp.cursedTree.status, true);
        assertEquals(gp.mystery.position, "");
        assertEquals(gp.shop.getBoughts().getFirst(), false);
        assertEquals(gp.shop.getBoughts().getLast(), false);
        assertEquals(gp.machine.times, 0);
        assertEquals(gp.bat1.status, true);
        assertEquals(gp.bat2.status, true);
        assertEquals(gp.bat3.status, true);
        assertEquals(gp.goblin.status, true);

        // Test complex state
        gp.cursedFlower.position = "finish";
        gp.cursedTree.status = false;
        gp.mystery.position = "finish";
        ArrayList list = new ArrayList();
        list.add(true);
        list.add(true);
        gp.shop.setBoughts(list);
        gp.machine.times = 10;
        gp.bat1.status = false;
        gp.bat2.status = false;
        gp.bat3.status = false;
        gp.goblin.status = false;

        saveEvent.save(gp);
        loadEvent.load(gp);

        assertEquals(gp.cursedFlower.position, "finish");
        assertEquals(gp.cursedTree.status, false);
        assertEquals(gp.mystery.position, "finish");
        assertEquals(gp.shop.getBoughts().getFirst(), true);
        assertEquals(gp.shop.getBoughts().getLast(), true);
        assertEquals(gp.machine.times, 10);
        assertEquals(gp.bat1.status, false);
        assertEquals(gp.bat2.status, false);
        assertEquals(gp.bat3.status, false);
        assertEquals(gp.goblin.status, false);
    }
}