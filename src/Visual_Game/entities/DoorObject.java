package Visual_Game.entities;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DoorObject extends SuperObject {

    public DoorObject() {

        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door_left.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
