package entities;

import java.util.ArrayList;


class Event{
    /*
      An event takes place in rooms, and can be
    encountered by Players.
    */
}

class Shop_Event0 extends Event{
    /**
     * One shop with three items on sell.
     */
    private ArrayList<Item> items;
    private ArrayList<Integer> prices;

    public Shop_Event0() {
        this.items = new ArrayList();
        this.prices = new ArrayList();

    }

}
