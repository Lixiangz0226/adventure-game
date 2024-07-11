package entities;

import java.util.*;

class Map{
   /**
     * A Map is a hashmap of rooms as nodes of a graph and the values will
     * be the room to go to from one room. The graph will
     * be bidirectional. The map indicates either daytime or
     *     nighttime <day>.
     */

    public static HashMap<Room, HashMap<String, Room>> world_map = new HashMap<>();
    private  boolean day;
    private Room startRoom;
    private Room playerRoom;

    public void addRoom(Room room) {
        HashMap<String, Room> adjacent_rooms = new HashMap<>();
        adjacent_rooms.put("Up", room.up);
        adjacent_rooms.put("Down", room.down);
        adjacent_rooms.put("Right",room.right);
        adjacent_rooms.put("Left",room.left);
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
