package entities;

import java.util;

class NPC extends Characters{
    """An NPC is an interactable Character to Players.
    An NPC can generate dialogues with Players.
    """
    private String dialogue;

    public NPC(String dialogue){this.dialogue = dialogue;}
}
