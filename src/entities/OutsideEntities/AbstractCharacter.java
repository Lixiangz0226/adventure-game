
package entities.OutsideEntities;

public abstract class AbstractCharacter {
    /**
     * Represents a character in the game, which can be either a player or a monster.
     * A character has a name and a certain amount of health.
     */
    private String name;
    private int health;

    public AbstractCharacter(String name, int health){
        this.name = name; this.health = health;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int hp){
        health = hp;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}