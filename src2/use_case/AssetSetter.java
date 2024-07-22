package use_case;

import entities.NPC_Guide;
import objects.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    //Create and load in the various objects onto specific tiles of the map, each object is represented by a
    //specific index on the obj array
    public void setObject() {

        gp.obj[0] = new KeyObject();
        gp.obj[0].x = 13 * gp.tileSize;
        gp.obj[0].y = 8 * gp.tileSize;

        gp.obj[1] = new DoorObject();
        gp.obj[1].x = 8 * gp.tileSize;
        gp.obj[1].y = 6 * gp.tileSize;

        gp.obj[2] = new GoalDoor();
        gp.obj[2].x = 7 * gp.tileSize;
        gp.obj[2].y = 0 * gp.tileSize;

        gp.obj[3] = new SuperKey();
        gp.obj[3].x = 7 * gp.tileSize;
        gp.obj[3].y = 8 * gp.tileSize;


    }

    //Create and ;oad in the npc entity into specific coordinates
    public void setNPC() {

        gp.npc[0] = new NPC_Guide(gp);
        gp.npc[0].x = gp.tileSize * 4;
        gp.npc[0].y = gp.tileSize * 4;

    }

}
