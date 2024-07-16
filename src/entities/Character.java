
package entities;

public abstract class Character {
    private String name;
    private int health;

    public Character(String name, int health) { this.name = name; this.health=health; }

    protected Character() { /* compiled code */ }

    public String getName() { return name; }

    public int getHealth() { return health; }

    public void setHealth(int hp) { health = hp; }
}