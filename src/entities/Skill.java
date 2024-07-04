package entities;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    /**
     * Skills are special attacks that have different effects
     *  that can be used by players and bosses. Each has a string
     *     <name>.
     */

    private String name;
    private final int duration;
    private int use;


    public Skill(String name){
        this.name = name;
        this.duration = 0;
        this.use = 0;
    }

    public String getName(){return name;}
}

class Defend extends Skill{
    private final int duration;

    public Defend(){
        super("Defend");
        this.duration = 2;
        this.use = 2;
    }
}

class Double_Edge extends Skill{
    public Double_Edge(){super("Double_Edge");}
}

class Charge extends Skill{
    public Charge(){super("Charge");}
}
