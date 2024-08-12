package entities.OutsideEntities.States;

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
    private int maxrounds;

    public State(int rounds, String name){
        /* Initializer */
        this.name = name;
        this.rounds = rounds;
        this.maxrounds = rounds;
    }

    public void count(){/* Count down the rounds. */this.rounds -= 1;}

    public String getName(){return this.name;}

    public int getrounds(){return this.rounds;}

    public void renewRounds(){rounds = maxrounds;}

    public void setRounds(int rounds){this.rounds = rounds;}

    public String getDescription(){return this.description;}

    public void setDescription(String description){this.description = description;}
}





