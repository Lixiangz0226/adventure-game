package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    /**
    Inventories store items in a list of Item items.
    */

    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {return items;}

    public Item getItem(int id) {return items.get(id);}

    public void addItem(Item item) {this.items.add(item);}

    public void removeItem(Item o) {this.items.remove(o);}

    public int get_length(){return this.items.size();}
    }

