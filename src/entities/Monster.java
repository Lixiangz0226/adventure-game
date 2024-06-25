package entities;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character {

    private List<State> states;
    public String description;

    public Monster(String name, int health) {
        super(name, health);
        this.states = new ArrayList<>();
        this.description = "";
    }
}
