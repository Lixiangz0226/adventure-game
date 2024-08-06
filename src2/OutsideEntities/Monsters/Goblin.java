package OutsideEntities.Monsters;

import OutsideEntities.States.State;

import java.util.List;

public class Goblin extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin() {
        super("Goblin", 24, 3, 1,0.8,false, 20);
        setMessage("The goblin stabbed you with a knife, dealt ");}
}
