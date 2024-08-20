package entities.stat_entities.Weapons;

public class Flame_Crossbow extends Weapon{
    /**
     *     Can exert burning state on the enemy
      */
    public Flame_Crossbow() {
        super("Flame Crossbow", 12, 0.9, 0.125, 0.3, true,
                true, 200);
        setDescription("Flame Crossbow: A weapon that can exert burning state on the enemy\n");
    }
}