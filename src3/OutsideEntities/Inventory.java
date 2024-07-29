package OutsideEntities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    /**
     * Inventories store items in a list of Item objects.
     */

    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items); // Return a copy to protect encapsulation
    }

    public Item getItem(int id) {
        if (id >= 0 && id < items.size()) {
            return items.get(id);
        } else {
            throw new IndexOutOfBoundsException("Invalid item ID");
        }
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int getLength() {
        return this.items.size();
    }
}
