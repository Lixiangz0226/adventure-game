package entities2;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DoorObject extends SuperObject {

    public DoorObject() {

        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Resoures/door_left.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
