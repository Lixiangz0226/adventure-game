package entities.map_objects;

import entities.stat_entities.Items.Item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemsChestObject extends Object {

    Item containedItem;

    public ItemsChestObject(Item i) {

        name = "Item_Chest";
        containedItem = i;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resource/objects/HP_Chest.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
        collision = false;

    }

    public Item getContainedItem() {
        return containedItem;
    }
    public void setContainedItem(Item i) {
        containedItem = i;
    }
}
