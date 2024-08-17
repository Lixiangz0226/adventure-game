package view.EventView;

import javax.swing.*;
import java.awt.*;

public class ShopViewModel extends EventViewModel {
    /**
     * The view model of shop event
     */
    public ShopViewModel() {// Constructor
        getChoice1().setActionCommand("c1se");
        getChoice2().setActionCommand("c2se");
        getChoice3().setActionCommand("c3se");
        getChoice4().setActionCommand("c4se");
    }

}
