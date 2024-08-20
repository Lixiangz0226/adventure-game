package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

//Door object prevents the player from going through, however it's collision can be turned off if the player's
//hasKey attribute is > 0
public class ForestDoor1 extends Object {

    public ForestDoor1() {

        name = "ForestDoor1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Starting_Forest_Gate.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
