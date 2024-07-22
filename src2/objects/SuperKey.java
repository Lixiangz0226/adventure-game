package objects;
import javax.imageio.ImageIO;
import java.io.IOException;

//A key object that can be picked up by thr player, then it disappears from the map and player gains +1 hasKey attribute
public class SuperKey extends SuperObject{

    public SuperKey() {

        name = "Super_Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Super_Key.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = false;

    }
}
