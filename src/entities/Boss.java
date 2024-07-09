package entities;

import entities.Monster;
import entities.State;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Monster {
    /**
     * The Boss is the strongest enemy of players. It has skills
    which is different from Monsters.
    */

    private List<Skill> skills;

    public Boss(String name, int health, int damage) {
        super(name, health, damage);
        this.skills = new ArrayList<>();
    }

    public List<Skill> getSkills() { return  this.skills; }
}
