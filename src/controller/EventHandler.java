package controller;

//Tests the functionality of the battle or shop event in rooms
/**
 * The EventHandler class manages and checks the occurrence of specific events
 * in rooms, such as battle or shop events. It is responsible for detecting
 * player interactions with event tiles and handling the effects of these events.
 */

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][][];

    int previousEventX, previousEventY;
    boolean canTouchEvent;

    /**
     * Constructs an EventHandler with a reference to the GamePanel.
     * Initializes the event rectangles for all possible locations in the game.
     *
     * @param gp The game panel where all game elements are managed.
     */

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new EventRect[gp.maxMap][gp.maxScreenCol][gp.maxScreenRow];

        int map = 0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col < gp.maxScreenCol && row < gp.maxScreenRow) {

            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if (col == gp.maxScreenCol) {
                col = 0;
                row++;

                if (row == gp.maxScreenRow) {
                    row = 0;
                    map++;
                }
            }

        }

    }

    /**
     * Checks for player interaction with any event in the current room.
     * Triggers the event if conditions are met, such as the player being in
     * the right location and having the correct direction.
     */

    public void checkEvent() {
        int xDistance = Math.abs(gp.playerController.x - previousEventX);
        int yDistance = Math.abs(gp.playerController.y - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent == true) {
            if (hit(0, 0, 5,"any")) {
                teleport(1, 15, 5);
            }
            else if(hit(1, 15, 5, "any")) {
                teleport(0, 1, 5);
            }
            else if (hit(0, 15, 5,"any")) {
                teleport(2, 0, 5);
            }
            else if (hit(2, 0, 5,"any")) {
                teleport(0, 15, 5);
            }
            else if (hit(0, 7, 0,"any")) {
                teleport(3, 7, 11);
            }
            else if (hit(3, 7, 11,"any")) {
                teleport(0, 7, 0);
            }


        }
    }

    /**
     * Checks if the player has triggered an event at the specified map, column, and row.
     *
     * @param map The map index where the event is being checked.
     * @param col The column index within the map where the event is being checked.
     * @param row The row index within the map where the event is being checked.
     * @param reqDirection The required direction the player must be facing to trigger the event.
     * @return true if the event is triggered; false otherwise.
     */

    public boolean hit(int map, int col, int row, String reqDirection) {

        boolean hit = false;

        if(map == gp.currentMap) {
            gp.playerController.solidArea.x = gp.playerController.x + gp.playerController.solidArea.x;
            gp.playerController.solidArea.y = gp.playerController.y + gp.playerController.solidArea.y;
            eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;

            if(gp.playerController.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
                if(gp.playerController.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;

                    previousEventX = gp.playerController.x;
                    previousEventY = gp.playerController.y;

                }

            }
            gp.playerController.solidArea.x = gp.playerController.solidAreaDefaultX;
            gp.playerController.solidArea.y = gp.playerController.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }

        return hit;

    }

    /**
     * Teleports the player to a specified location on the map.
     * Updates the player's position and prevents immediate retriggering of the event.
     *
     * @param map The map index to teleport the player to.
     * @param col The column index within the map where the player will be teleported.
     * @param row The row index within the map where the player will be teleported.
     */

    public void teleport(int map, int col, int row) {

        gp.currentMap = map;
        gp.playerController.x = gp.tileSize * col;
        gp.playerController.y = gp.tileSize * row;
        previousEventX = gp.playerController.x;
        previousEventY = gp.playerController.y;
        canTouchEvent = false;

    }


}
