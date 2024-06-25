package entities;

import java.util.ArrayList;
import java.util.List;

public class Room {
    """A Room is separate parts in a map. Players can
    travel between different rooms. Each room has different
    string <name>, possible List of items <items>,
    List of Characters <characters>, Event <event> and
    List of Interactable_objects <interactable_objects>.
"""

    private String name;
    private List<Item> items;
    private List<Character> characters;
    private Event event;
    private List<Interactable_objects> interactable_objects;

    public Room(String name) {
        this.items = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.event = new Event();
        this.interactable_objects = new ArrayList<>();
    }
}
