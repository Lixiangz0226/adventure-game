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
    private JTextArea mainTextArea;
    private JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    private Player player;

    private List<Item> items;
    private List<Character> characters;
    private List<Interactable_object> interactable_objects;
    private Event events;
    private String name;
    private String description;
    private int n;
    private int s;
    private int w;
    private int e;

    public Room(String name, String description, int n, int s, int w, int e) {
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
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }
    public void setS(int s) {
        this.s = s;
    }

    public int getW() {
        return w;
    }
    public void setW(int w) {
        this.w = w;
    }

    public int getE() {
        return e;
    }
    public void setE(int e) {
        this.e = e;
    }
}






