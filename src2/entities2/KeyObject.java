package entities2;

import javax.imageio.ImageIO;
import java.io.IOException;

public class KeyObject extends SuperObject {

    public KeyObject() {

        name = "Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Resoures/New_Piskel-1.png.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }
}
