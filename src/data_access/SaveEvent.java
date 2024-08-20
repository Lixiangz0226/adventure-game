package data_access;

import controller.GamePanel;

import java.io.*;
import java.util.ArrayList;

public class SaveEvent {
    /**
     * Save all events to a file
     */
    File file = new File("src\\data_access\\Events.txt");


    public void save(GamePanel gp) throws IOException {// Save events
        file.delete();
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // Cursed Flower(string)
        writer.write(gp.cursedFlower.position);
        writer.newLine();
        // Cursed Tree(boolean)
        writer.write(gp.cursedTree.status + "");
        writer.newLine();
        // MysteryBox(string)
        writer.write(gp.mystery.position);
        writer.newLine();
        // Shop(two booleans)
        ArrayList list = gp.shop.getBoughts();
        writer.write(list.getFirst() + "," + list.getLast());
        writer.newLine();
        // SlotMachine(int)
        writer.write("" + gp.machine.times);
        writer.newLine();
        // Bat1
        writer.write("" + gp.bat1.status);
        writer.newLine();
        // Bat2
        writer.write("" + gp.bat2.status);
        writer.newLine();
        // Bat3
        writer.write("" + gp.bat3.status);
        writer.newLine();
        // Goblin
        writer.write("" + gp.goblin.status);
        writer.newLine();

        writer.close();
    }
}
