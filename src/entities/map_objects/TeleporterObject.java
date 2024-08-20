package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

//Teleports the player to a set coordinates, can be used repeatedly and does not disappear from the map after use
public class TeleporterObject extends Object {

    public TeleporterObject() {

        name = "Teleporter";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Key.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
