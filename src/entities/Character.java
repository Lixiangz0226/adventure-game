package entities;

public abstract class Character {
    /**
     * A Character with string name and int health is abstract and
    can be extended to child classes like Player(controllable),
    NPC(uncontrollable). If a character's health <= 0, then the character
    can't take any action.
    */
    private String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    protected Character() {
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int hp) {
        this.health = hp;
    }
}
