package TextGame.entities.Monsters;

import TextGame.entities.States.State;

import java.util.List;

public class Goblin extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin() {
        super("Goblin", 24, 6);
        setMessage("The goblin stabbed you with a knife, dealt ");}
}
