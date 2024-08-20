package entities.stat_entities.States;

public abstract class State{
    /**
     * A state of a character that affect the character
     *     every round. A state has an integer rounds counts down
     *     the duration left of the state. The string description
     *     stores the special effect of the state.
      */


    private int rounds;
    private String name;
    private String description;
    private final int maxrounds;

    public State(int rounds, String name){//Constructor
        /* Initializer */
        this.name = name;
        this.rounds = rounds;
        this.maxrounds = rounds;
    }

    public void count(){/* Count down the rounds. */this.rounds -= 1;}

    public String getName(){/* Return state name */return this.name;}

    public int getRounds(){/* Return state rounds */return this.rounds;}

    public void renewRounds(){/* Set rounds to maxrounds */rounds = maxrounds;}

    public void setRounds(int rounds){/* Set rounds */this.rounds = rounds;}

    public String getDescription(){/* Return state description */return this.description;}

    public void setDescription(String description){/* Set state description */this.description = description;}
}





