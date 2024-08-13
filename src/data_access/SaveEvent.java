package data_access;

import controller.GamePanel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveEvent {
    File file = new File("src\\data_access\\Player.txt");
    GamePanel gp;

    public SaveEvent(GamePanel gp) {this.gp = gp;}

    public void save() throws IOException {
        file.delete();
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // Cursed Flower()
        writer.write(gp.cursedFlower.position);
        writer.newLine();


        writer.close();
    }
}
