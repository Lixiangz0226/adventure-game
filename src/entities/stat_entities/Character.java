
package entities.stat_entities;

public abstract class Character {
    /**
     * Represents a character in the game, which can be either a player or a monster.
     * A character has a name and a certain amount of health.
     */
    private String name;
    private int health;

    public Character(String name, int health){// Constructor
        this.name = name; this.health = health;
    }

    public void setName(String name) {// Set name
        this.name = name;
    }

    public String getName(){// Return name
        return name;
    }

    public int getHealth(){// Return health
        return health;
    }

    public void setHealth(int hp){// Set health
        health = hp;
    }

    public void takeDamage(int damage) {// Getting damage
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {// Return alive boolean
        return this.health > 0;
    }
}