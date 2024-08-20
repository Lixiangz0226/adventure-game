package entities.stat_entities.Weapons;

public class Knife extends Weapon {
    /**
     *     The basic weapon
      */
    public Knife(){
        super("Knife", 5, 1, 0, 0, true,
            false, 50);
        setDescription("Knife: The basic weapon the player originally had.\n");
    }
}
