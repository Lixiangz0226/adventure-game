package entities;

import java.util.*;

class Map{
   /**
     * A Map is a hashmap of rooms as nodes of a graph and the values will
     * be the room to go to from one room. The graph will
     * be bidirectional. The map indicates either daytime or
     *     nighttime <day>.
     */

    public static HashMap<Room, HashMap<String, String>> world_map = new HashMap<>();
    private  boolean day;
    private Room startRoom;
    private Room playerRoom;

    public void addRoom(Room room) {
        HashMap<String, String> adjacent_rooms = new HashMap<>();
        adjacent_rooms.put("North", room.n);
        adjacent_rooms.put("South", room.s);
        adjacent_rooms.put("West",room.w);
        adjacent_rooms.put("East",room.e);
        Map.world_map.put(room, adjacent_rooms);
    }

    public void getDay () {

    }

    public void changeDay () {

    }

    public void displayMap () {

    }
    }
}
