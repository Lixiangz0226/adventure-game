package entities.stat_entities.Skills;

public class Defend extends Skill{
    /** The skill that makes player invincible for two rounds, and can be used twice. */
    public Defend(){super("Defend", 2, 2);
    setDescription("Defense: The user cannot be damaged for two rounds. This skill can be used twice in a battle\n");}
}
