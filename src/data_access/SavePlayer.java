package data_access;

import OutsideEntities.Items.Item;
import OutsideEntities.Player;

import java.io.*;

public class SavePlayer {
    File file = new File("src\\data_access\\Player.txt");
    Player player;

    public SavePlayer(Player player) throws IOException {
        this.player = player;
    }

    public void save() throws IOException {
        file.delete();
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write(player.getName());
        writer.newLine();
        writer.write("" + player.getHealth());
        writer.newLine();
        writer.write("" + player.getKey());
        writer.newLine();
        writer.write("" + player.getMoney());
        writer.newLine();
        writer.write(player.getWeaponName());
        writer.newLine();
        for (Item i: player.getInventory().getItems()){
            writer.write(i.getName() + ",");
        }
        writer.newLine();

        writer.close();
    }

}
