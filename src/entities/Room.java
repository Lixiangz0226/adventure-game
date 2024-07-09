package entities;

import javax.swing.*;
import java.util.List;

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
    private String n;
    private String s;
    private String w;
    private String e;


    public Room(String name, String description, String n, String s, String w, String e) {
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
    }
    public String getN() {
        return n;
    }
    public void setN(String n) {
        this.n = n;
    }

    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }

    public String getW() {
        return w;
    }
    public void setW(String w) {
        this.w = w;
    }

    public String getE() {
        return e;
    }
    public void setE(String e) {
        this.e = e;
    }
}






