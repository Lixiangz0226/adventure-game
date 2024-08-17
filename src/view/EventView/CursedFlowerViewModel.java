package view.EventView;

public class CursedFlowerViewModel extends EventViewModel{
    /**
     * The view model of cursed flower event
     */
    public CursedFlowerViewModel() {//Constructor
        super();
        getChoice1().setActionCommand("c1");
        getChoice2().setActionCommand("c2");
        getChoice3().setActionCommand("c3");
        getChoice4().setActionCommand("c4");
    }
}
