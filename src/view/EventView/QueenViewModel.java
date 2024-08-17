package view.EventView;

public class QueenViewModel extends EventViewModel{
    /**
     * The view model of Queen slime event
     */
    public QueenViewModel() {// Constructor
        super();
        getChoice1().setActionCommand("c1qs");
        getChoice2().setActionCommand("c2qs");
        getChoice3().setActionCommand("c3qs");
        getChoice4().setActionCommand("c4qs");
    }
}
