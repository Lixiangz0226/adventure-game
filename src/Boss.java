import entities.Monster;
import entities.State;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Monster {

    private List<Skill> skills;

    public Boss(String name, int health) {
        super(name, health);
        this.skills = new ArrayList<>();
    }
}
