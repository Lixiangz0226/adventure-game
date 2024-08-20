package entities.stat_entities.Weapons;

public class Spear extends Weapon{
    /**
     *     A strong weapon against flying foes
      */
    public Spear(){
        super("Spear", 8, 1, 0.125, 0,true,
            true, 100);
        setDescription("Spear: Strong against flying foes\n");
    }
}