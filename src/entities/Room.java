package entities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.math.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private JButton c1, c2, c3, c4;
    private JTextArea mainTextArea;
    private Container con;

    public Room(String name, String description, Room n, Room s, Room w, Room e, Event event, JButton c1, JButton c2,
                JButton c3, JButton c4, JTextArea mainTextArea, Container con) {
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
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.name = name;
        this.description = description;
        this.mainTextArea = mainTextArea;
        this.con = con;
    }

    public void run_room(){event.run_event();}

    public Room getN() {
        return n;
    }

    public Room getS() {
        return s;
    }

    public Room getW() {
        return w;
    }

    public Room getE() {
        return e;
    }


}






