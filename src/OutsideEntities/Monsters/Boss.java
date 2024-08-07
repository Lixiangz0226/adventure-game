package OutsideEntities.Monsters;

import OutsideEntities.States.State;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Monster{

    public Boss(String name, int health, int damage, double physical_def, double magical_def, boolean flying, int gold_drop) {
        super(name, health, damage, physical_def, magical_def, flying, gold_drop);
    }

}
