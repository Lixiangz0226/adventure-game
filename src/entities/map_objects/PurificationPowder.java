package entities.map_objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PurificationPowder extends Object {

    public PurificationPowder() {

        name = "Powder";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Powder.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = false;

    }




}
