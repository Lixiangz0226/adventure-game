package OutsideEntities;

public class Skill {
    /**
     * Skills are special attacks that have different effects
     *  that can be used by players and bosses. Each has a string
     *     <name>.
     */

    private String name;
    private final int duration;
    private int times;

    public Skill(String name, int duration, int times){
        this.name = name;
        this.duration = duration;
        this.times = times;
    }

    public String getName(){return name;}

    public int getDuration(){return duration;}

    public int getTimes(){return times;}
}

class Defend extends Skill{
    /* The skill that makes player invincible for two rounds, and can be used twice. */
    public Defend(){super("Defend", 2, 2);}
}

class Double_Edge extends Skill{
    /* The skill deals 30 to the enemy but receives 10 damage. */
    public Double_Edge(){super("Double_Edge", 0, 1);}
}

class Charge extends Skill{
    /* The skill doubles the damage dealt in the next round. */
    public Charge(){
        super("Charge", 1, 1);
    }
}
