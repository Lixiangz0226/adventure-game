package entities.stat_entities.Skills;

public class Basic_attack extends Skill{
    /** The skill that can be used for infinite times. */
    public Basic_attack(){
        super("Basic_Attack", 0, 999);
        setDescription("Basic_Attack: Attack the enemy using the weapon the user is currently equipped. This skill can be used unlimitedly\n");
    }
}
