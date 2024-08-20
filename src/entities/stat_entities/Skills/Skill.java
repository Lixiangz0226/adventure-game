package entities.stat_entities.Skills;

public abstract class Skill {
    /**
     * Skills are special attacks that have different effects
     *  that can be used by players and bosses. Each has a string
     *     <name>.
     */

    private String name;
    private final int duration;
    private int times;
    private String description = "";

    public Skill(String name, int duration, int times){// Constructor
        this.name = name;
        this.duration = duration;
        this.times = times;
    }

    public String getName(){/* Retrun skill name */return name;}

    public int getDuration(){/* Return skill duration */return duration;}

    public int getTimes(){/* Return the skill maximum using times */return times;}

    public String getDescription(){/* Return the skill description */return description;}

    public void setDescription(String description){/* Set the skill description */this.description = description;}
}

