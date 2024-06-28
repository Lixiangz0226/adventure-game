package entities;

import java.util.*;

class NPC extends Character{
    /**
     * An NPC is an interactable Character to Players.
     *     An NPC can generate dialogues with Players.
     */

    private String dialogue;

    public NPC(String name, int health, String dialogue){
        super(name, health);
        this.dialogue = dialogue;}
}
