package entities.stat_entities.Weapons;

public class Staff extends Weapon{
    /**
     *     A weapon with basic magic damage.
      */
    public Staff() {
        super("Staff", 8, 1, 0.125, 0, false,
                false, 100);
        setDescription("Staff: Basic magic damage weapon.\n");
    }
}