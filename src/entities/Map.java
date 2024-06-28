package entities;

import java.util.*;

class Map{
    /**
     * A Map is a 2-dimensional plane that contains a List
     *     of Lists of <rooms> and indicates either daytime or
     *     nightime <day>.
     */

    private List<List<Room>> rooms;
    private boolean day;

    public Map(List<List<Room>> rooms){
        this.day = true;
        this.rooms = rooms;
    }
}
