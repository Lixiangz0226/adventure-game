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

    private List<Item> items;
    private List<Character> characters;
    private List<Interactable_object> interactable_objects;
    private Event events;
    private String name;
    private Room up;
    private Room down;
    private Room left;
    private Room right;

    public Room(String name, Room up, Room down, Room left, Room right, List<Item> items, List<Character> characters,
                List<Interactable_object> interactable_objects,
                JTextArea mainTextArea,
                JButton choice1, JButton choice2, JButton choice3, JButton choice4) {

        this.name = name;
        this.characters = characters;
        this.interactable_objects = interactable_objects;
        this.items = items;
        this.mainTextArea = mainTextArea;
        this.choice1 = choice1; this.choice2 = choice2; this.choice3 = choice3; this.choice4 = choice4;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
}



