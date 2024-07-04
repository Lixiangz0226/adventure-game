package entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Room {
    /**
     * A Room is separate parts in a map. Players can
    travel between different rooms. Each room has different
    string <name>, possible List of items <items>,
    List of Characters <characters>, Event <event> and
    List of Interactable_objects <interactable_objects>.
    */
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;

    private String name;
    private Event event;
    private Room up;
    private Room down;
    private Room left;
    private Room right;

    public Room(String name, Event event, Room up, Room down, Room left, Room right, JTextArea mainTextArea,
                JButton choice1, JButton choice2, JButton choice3, JButton choice4,
                Player player) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.event = event;
        this.name = name;
    }
}



