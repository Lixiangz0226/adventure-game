package entities.stat_entities.Monsters;

public class Bat extends Monster{
    /**
     * Common monster
     */
    public Bat() {
        super("Bat", 20, 3, 1,1,true, 30);
        setMessage("The bat flew and bit you, dealt ");}
}