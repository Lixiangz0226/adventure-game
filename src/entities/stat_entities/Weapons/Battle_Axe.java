package entities.stat_entities.Weapons;

public class Battle_Axe extends Weapon{
    /**
     * Does huge damage, but takes a turn to recharge and a chance to miss
      */

    public Battle_Axe(){
        super("Battle Axe", 25, 0.7, 0.125, 0,
            true, false, 200);
        setDescription("Battle Axe: It does huge damage, but takes a turn to recharge and a chance to miss\n");
    }
}
