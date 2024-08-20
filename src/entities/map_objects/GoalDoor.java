package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GoalDoor extends Object {

    public GoalDoor() {

        name = "Goal_Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Goal_Door.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;

    }


}
