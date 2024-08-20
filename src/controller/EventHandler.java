package controller;

//Tests the functionality of the battle or shop event in rooms
public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][][];

    int previousEventX, previousEventY;
    boolean canTouchEvent;

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

    public void teleport(int map, int col, int row) {

        gp.currentMap = map;
        gp.playerController.x = gp.tileSize * col;
        gp.playerController.y = gp.tileSize * row;
        previousEventX = gp.playerController.x;
        previousEventY = gp.playerController.y;
        canTouchEvent = false;

    }


}
