package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GoalDoor extends SuperObject{

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
