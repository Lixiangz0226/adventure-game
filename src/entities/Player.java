package entities;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    """ A Player is the only controllable character for the user.
    A Player has a string name, an int health, a list of State state_set,
    an Inventory inventory and a list of Skill skill_set.
    """
    private Inventory inventory;
    private List<Skill> skills;
    private List<State> states;
    private int money;

    public Player(String name, int health) {
        super(name, health);
        this.inventory = new Inventory();
        this.skills = new ArrayList<>();
        this.money = 0;
        this.states = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
