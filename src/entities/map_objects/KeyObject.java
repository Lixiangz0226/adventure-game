package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

//A key object that can be picked up by thr player, then it disappears from the map and player gains +1 hasKey attribute
public class KeyObject extends Object {

    public KeyObject() {

        name = "Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Key.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = false;

    }
}
