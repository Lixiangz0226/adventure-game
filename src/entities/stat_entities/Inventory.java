package entities.stat_entities;

import entities.stat_entities.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    /**
     * Inventories store items in a list of Item objects.
     */

    private List<Item> items;

    public Inventory() {// Constructor
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {// Return a copy to protect encapsulation
        return new ArrayList<>(items);
    }

    public Item getItem(int id) {// Return the target item at index id
        if (id >= 0 && id < items.size()) {
            return items.get(id);
        } else {
            throw new IndexOutOfBoundsException("Invalid item ID");
        }
    }

    public void addItem(Item item) {// Add an item
        this.items.add(item);
    }

    public void removeItem(Item item) {// Remove an item
        this.items.remove(item);
    }

    public void removeAll(){// Removing all items
        items.removeAll(this.items);}

    public int getLength() {// Return the length of the inventory
        return this.items.size();
    }
}
