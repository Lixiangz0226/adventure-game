package entities;

import java.util;

public class State{
    """ A state of a character that affact the character
    every round. A state has an integer rounds counts down
    the duration left of the state. The string description
    stores the special effact of the state.
    """
    private int rounds;
    public String description;

    public State(int rounds, string description){
        this.description = description;
        this.rounds = rounds;
    }

    public count(){this.rounds -= 1}
}
