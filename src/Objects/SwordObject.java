package Objects;

import OutsideEntities.Weapons.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;


public class SwordObject extends AbstractObject{

    Weapon containedWeapon;

    public SwordObject() {
        name = "Sword";

        Battle_Axe battle_axe = new Battle_Axe();


        int randomInteger = new Random().nextInt(99) + 1;

        if (randomInteger >= 1 && randomInteger <= 33) {
            containedWeapon = new Katana();
        }

        else if (randomInteger >= 33 && randomInteger <= 66) {
            containedWeapon = new Battle_Axe();
        }

        else if (randomInteger >= 66 && randomInteger <= 100) {
            containedWeapon = null;
        }


        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Sword.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = false;

    }

    public Weapon getContainedWeapon() {
        return containedWeapon;
    }
}
