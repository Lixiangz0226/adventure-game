package entities.stat_entities.Weapons;

public class Katana extends Weapon{
    /**
     *     The weapon has a double critical ratio.
      */
    public Katana(){
        super("Katana", 8, 1, 0.25, 0,true,
            false, 100);
        setDescription("Katana: Double critical ratio.\n");
    }
}