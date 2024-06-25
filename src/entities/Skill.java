package entities;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    """Skills are special attacks that has different effacts
    an can be used by players and bosses. Each has a string
    <name>, int <damage> and List of State <effact>.
    """
    private String name;
    private int damage;
    private List<State> effect;

    public Skill(String name){
        this.name = name;
        this.damage = 0;
        this.effect = new ArrayList<>();
    }

}
