package OutsideEntities;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextArea;
import Event_Tester_Package.Event;

//Each room contains information about the rooms in its four directions
//The rooms have a name, description, and unique event that can run when the player enters the room
public class Room {

    //Room attributes
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
    private PlayerController player;

    //Room constructor with room designation
    public Room(String name, String description, Room n, Room s, Room w, Room e, Event event, PlayerController player, Container con) {

        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        this.event = event;
        this.name = name;
        this.description = description;
        this.con = con;
    }

    //Default room constructor
    public Room(String name, String description, Event event, PlayerController player, Container con) {
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

    //Runs the room event
    public void run_room(){event.run_event();}

    //Retrieves the room on its north, south, west, or east
    public Room getN() {return n;}
    public Room getS() {return s;}
    public Room getW() {return w;}
    public Room getE() {return e;}

    //Sets and connects rooms to their north, south, west, or east
    public void setN(Room n) {this.n = n; if (!this.equals(n.getS())){n.setS(this);}}
    public void setS(Room s) {this.s = s; if (!this.equals(s.getN())){s.setN(this);}}
    public void setW(Room w) {this.w = w; if (!this.equals(w.getE())){w.setE(this);}}
    public void setE(Room e) {this.e = e; if (!this.equals(e.getW())){e.setW(this);}}

    //Returns the name of the room
    public String getName(){return name;}

}
