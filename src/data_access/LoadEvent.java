package data_access;

import controller.GamePanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoadEvent {
    /**
     *
     */
    File myEvent = new File("src\\data_access\\Events.txt");


    public void load(GamePanel gp) throws FileNotFoundException {
        // Load the events' info from the file saved
        if (!myEvent.exists()) {
        }
        Scanner myReader = new Scanner(myEvent);

        // Cursed Flower(string)
        gp.cursedFlower.position = myReader.nextLine();
        // Cursed Tree(boolean)
        gp.cursedTree.status = myReader.nextLine().equals("true");
        // MysteryBox(string)
        gp.mystery.position = myReader.nextLine();
        // Shop(two booleans)
        List boughts = Arrays.stream(myReader.nextLine().split(",")).toList();
        ArrayList result = new ArrayList();
        result.add(boughts.getFirst().equals("true"));
        result.add(boughts.getLast().equals("true"));
        gp.shop.setBoughts(result);
        // SlotMachine(int)
        gp.machine.times = Integer.parseInt(myReader.nextLine());
        // Bat1
        gp.bat1.status = myReader.nextLine().equals("true");
        // Bat2
        gp.bat2.status = myReader.nextLine().equals("true");
        // Bat3
        gp.bat3.status = myReader.nextLine().equals("true");
        // Goblin
        gp.goblin.status = myReader.nextLine().equals("true");

        myReader.close();
    }
}

