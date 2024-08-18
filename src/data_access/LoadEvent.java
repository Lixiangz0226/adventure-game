package data_access;

import OutsideEntities.Player;
import controller.EventController.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadEvent {

    File myEvent = new File("src\\data_access\\Events.txt");


    public LoadEvent() {// Constructor
    }

    public void loadEvent() throws FileNotFoundException {
        // Load the player's info from the file and return the player saved
        if (!myEvent.exists()) {
        }
        Scanner myReader = new Scanner(myEvent);

        // flower
        String name = myReader.nextLine();
        //
        int hp = Integer.parseInt(myReader.nextLine());
        Player player = new Player(name, hp);
        // Keys
        player.setKey(Integer.parseInt(myReader.nextLine()));
        // Money
        player.setMoney(Integer.parseInt(myReader.nextLine()));
        // Weapon

    }
}

