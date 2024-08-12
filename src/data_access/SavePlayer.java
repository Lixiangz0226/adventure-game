package data_access;

import OutsideEntities.Items.Item;
import OutsideEntities.Player;

import java.io.*;
import java.lang.reflect.Constructor;

public class SavePlayer {
    File file = new File("src\\data_access\\Player.txt");
    Player player;

    public SavePlayer(Player player) throws IOException {
        // Constructor
        this.player = player;
    }

    public void save() throws IOException {
        // Save the player's info to a file
        file.delete();
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        // Name
        writer.write(player.getName());
        writer.newLine();
        // Health
        writer.write("" + player.getHealth());
        writer.newLine();
        // Keys
        writer.write("" + player.getKey());
        writer.newLine();
        // Money
        writer.write("" + player.getMoney());
        writer.newLine();
        // Weapon
        writer.write(player.getWeaponName());
        writer.newLine();
        // Inventory
        for (Item i: player.getInventory().getItems()){
            writer.write(i.getName() + ",");
        }
        writer.newLine();

        writer.close();
    }

}
