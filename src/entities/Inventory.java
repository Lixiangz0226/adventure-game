package entities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    """ Inventories store items in a list of items items.
    """

    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
