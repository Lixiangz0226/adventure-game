package entities.stat_entities.Skills;

public class Double_Edge extends Skill{
    /** The skill deals 30 to the enemy but receives 10 damage. */
    public Double_Edge(){super("Double_Edge", 0, 1);
    setDescription("Double_Edge: The user damages the enemy with 30 but looses 10 HP. " +
            "This skill can be used once in a battle.\n");}
}
