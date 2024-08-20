package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

//Door object prevents the player from going through, however it's collision can be turned off if the player's
//hasKey attribute is > 0
public class DoorObject extends Object {

    public DoorObject() {

        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/door_left.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
