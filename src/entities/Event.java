package entities;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


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
        this.items = new ArrayList<Item>();
        this.prices = new ArrayList<Integer>();
        this.items.add(new Flame_Crossbow()); this.items.add(new Life_Potion());
        this.items.add(new Golden_Key());
        this.prices.add(40); this.prices.add(15); this.prices.add(30);


    }

}
