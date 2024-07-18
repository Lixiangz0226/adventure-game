package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TeleporterObject extends SuperObject{

    public TeleporterObject() {

        name = "Teleporter";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/New Piskel-1.png.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
