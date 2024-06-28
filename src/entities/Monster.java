package entities;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character {
    /**
     * A Monster is the enemy of players, which can suffer from
     *     different states. A Monster can't take any action if  it's
     *     health <= 0.
     */


    private List<State> states;
    public String description;

    public Monster(String name, int health) {
        super(name, health);
        this.states = new ArrayList<>();
        this.description = "";
    }
}
