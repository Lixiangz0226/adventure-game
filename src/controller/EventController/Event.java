package controller.EventController;

import UseCaseInteracter.EventInteracter;
import view.EventView.EventViewModel;

import java.awt.*;

public abstract class Event{
    /**
      An event takes place in rooms, and can be
    encountered by Players.
    */
    EventViewModel viewModel;
    EventInteracter interacter;

    public Boolean opened = true;
    public boolean status;

    abstract public void runEvent();

    abstract public Window getWindow ();
}
