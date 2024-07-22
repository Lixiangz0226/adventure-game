package TextGame.entities;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Room {
    /**
     * A Room is separate parts in a map. Players can
     travel between different rooms. Each room has different
     string <name>, possible List of items <items>,
     List of Characters <characters>, Event <event> and
     List of Interactable_objects <interactable_objects>.
     */

    /**
     private JTextArea mainTextArea;
     private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
     private Player player;

     private List<Item> items;
     private List<Character> characters;
     private List<Interactable_object> interactable_objects;
     private Event events;
     */
    private String name;
    private String description;
    private Room n;
    private Room s;
    private Room w;
    private Room e;
    private Event event;
    JButton c1, c2, c3, c4;
    JTextArea mainTextArea;
    Container con;
    private Player player;

    public Room(String name, String description, Room n, Room s, Room w, Room e, Event event,  Player player, Container con) {
    /**
    this.name = name;
    this.characters = characters;
    this.interactable_objects = interactable_objects;
    this.items = items;
    this.mainTextArea = mainTextArea;
    this.choice1 = choice1; this.choice2 = choice2; this.choice3 = choice3; this.choice4 = choice4;
    */
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        this.event = event;
        this.name = name;
        this.description = description;
        this.con = con;

    }

    public Room(String name, String description, Event event, Player player, Container con) {
        this.name = name;
        this.description = description;
        this.event = event;
        this.n = null;
        this.s = null;
        this.w = null;
        this.e = null;
        this.player = player;
        this.con = con;
    }

    public void run_room(){event.run_event();}

    public Room getN() {return n;}

    public Room getS() {return s;}

    public Room getW() {return w;}

    public Room getE() {return e;}

    public void setN(Room n) {this.n = n; if (!this.equals(n.getS())){n.setS(this);}}

    public void setS(Room s) {this.s = s; if (!this.equals(s.getN())){s.setN(this);}}

    public void setW(Room w) {this.w = w; if (!this.equals(w.getE())){w.setE(this);}}

    public void setE(Room e) {this.e = e; if (!this.equals(e.getW())){e.setW(this);}}

    public String getName(){return name;}

}