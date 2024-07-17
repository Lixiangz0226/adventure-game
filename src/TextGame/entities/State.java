package TextGame.entities;

public class State{
    /**
     * A state of a character that affect the character
     *     every round. A state has an integer rounds counts down
     *     the duration left of the state. The string description
     *     stores the special effect of the state.
      */


    private int rounds;
    private String description;

    public State(int rounds, String description){
        this.description = description;
        this.rounds = rounds;
    }

    public void count(){this.rounds -= 1;}

    public String getdescription(){return this.description;}

    public int getrounds(){return this.rounds;}
}

class Defensive extends State {public Defensive(){super(2, "Defensive");}}

class Charging extends State {public Charging(){super(1, "Charging");}}





