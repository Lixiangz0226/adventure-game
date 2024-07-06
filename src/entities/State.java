package entities;

public class State{
    /**
     * A state of a character that affect the character
     *     every round. A state has an integer rounds counts down
     *     the duration left of the state. The string description
     *     stores the special effect of the state.
      */


    private int rounds;
    private String description;
    private Effect effect;

    public State(int rounds, String description){
        this.description = description;
        this.rounds = rounds;
        this.effect = new Effect(description);
    }

    public void count(){this.rounds -= 1;}

    public String getdescription(){return this.description;}
}

class Effect {
    private String description;
    public Effect(String description){this.description = description;}
    public String getdescription(){return this.description;}
}
