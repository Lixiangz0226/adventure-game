package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

//Door object prevents the player from going through, however it's collision can be turned off if the player's
//hasKey attribute is > 0
public class CavernDoor extends Object {

    public CavernDoor() {

        name = "CavernDoor";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Dark_Cavern_Gate.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
