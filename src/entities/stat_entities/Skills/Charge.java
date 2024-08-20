package entities.stat_entities.Skills;

public class Charge extends Skill{
    /** The skill doubles the damage dealt in the next round. */
    public Charge(){
        super("Charge", 1, 1);
        setDescription("Charge: The user deals no damage this round, but doubled the damage dealt in next round. " +
                "This skill can be used once in a battle.\n");
    }
}
