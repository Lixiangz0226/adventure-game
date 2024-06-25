package entities;

import java.util;

class Ineractable_object extends Item{
    """ An Interactable-object is an object in a room Players
    can interact with.
    """
    private String name;

    public Ineractable_object(String name){
        this.name = name;
    }
}
