package entities;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String name;
    private int damage;
    private List<State> effect;

    public Skill(String name){
        this.name = name;
        this.damage = 0;
        this.effect = new ArrayList<>();
    }

}
