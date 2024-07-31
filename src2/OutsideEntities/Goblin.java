package OutsideEntities;

import java.util.List;

public class Goblin extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin() {super("Goblin", 24, 6);}
}
