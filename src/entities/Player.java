package entities;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    // private Inventory inventory;
    private List<Skill> skills;
    private int money;

    public Player(String name, int health) {
        super(name, health);
        // this.inventory = new Inventory();
        this.skills = new ArrayList<>();
        this.money = 0;
    }

    /* public Inventory getInventory() {
        return inventory;
    } */

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
