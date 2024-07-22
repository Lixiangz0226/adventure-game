
package TextGame.entities;

public abstract class Character {
    /**
     * Represents a character in the game, which can be either a player or a monster.
     * A character has a name and a certain amount of health.
     */
    private String name;
    private int health;

    public Character(String name, int health) { this.name = name; this.health=health; }

    public String getName() { return name; }

    public int getHealth() { return health; }

    public void setHealth(int hp) { health = hp; }
}
