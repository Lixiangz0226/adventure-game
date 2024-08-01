package OutsideEntities.Skills;

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

