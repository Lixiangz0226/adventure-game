package controller;

import Objects.DoorObject;
import Objects.GoalDoor;
import Objects.KeyObject;
import Objects.SuperKey;
import entities.*;
import entities.Goblin;
import entities.NPC_Guide;




public class AssetSetter {

    GamePanel gp;

    /**
     * @param gp
     */
    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    //Create and load in the various objects onto specific tiles of the map, each object is represented by a
    //specific index on the obj array
    public void setObject() {

        int mapNumber = 0;

        gp.obj[mapNumber][0] = new KeyObject();
        gp.obj[mapNumber][0].x = 13 * gp.tileSize;
        gp.obj[mapNumber][0].y = 8 * gp.tileSize;

        gp.obj[mapNumber][1] = new DoorObject();
        gp.obj[mapNumber][1].x = 8 * gp.tileSize;
        gp.obj[mapNumber][1].y = 6 * gp.tileSize;

        gp.obj[mapNumber][2] = new GoalDoor();
        gp.obj[mapNumber][2].x = 7 * gp.tileSize;
        gp.obj[mapNumber][2].y = 0 * gp.tileSize;

        gp.obj[mapNumber][3] = new SuperKey();
        gp.obj[mapNumber][3].x = 7 * gp.tileSize;
        gp.obj[mapNumber][3].y = 8 * gp.tileSize;
    }

    //Create and ;oad in the npc entity into specific coordinates
    public void setNPC() {

        int mapNumber = 0;

        gp.npc[mapNumber][0] = new NPC_Guide(gp);
        gp.npc[mapNumber][0].x = gp.tileSize * 4;
        gp.npc[mapNumber][0].y = gp.tileSize * 4;

        gp.npc[mapNumber][1] = new Goblin(gp);
        gp.npc[mapNumber][1].x = gp.tileSize * 7;
        gp.npc[mapNumber][1].y = gp.tileSize * 4;


        mapNumber = 1;
        gp.npc[mapNumber][2] = new Bat1(gp);
        gp.npc[mapNumber][2].x = gp.tileSize * 9;
        gp.npc[mapNumber][2].y = gp.tileSize * 4;

        gp.npc[mapNumber][3] = new Bat2(gp);
        gp.npc[mapNumber][3].x = gp.tileSize * 4;
        gp.npc[mapNumber][3].y = gp.tileSize * 3;

        gp.npc[mapNumber][4] = new Bat3(gp);
        gp.npc[mapNumber][4].x = gp.tileSize * 5;
        gp.npc[mapNumber][4].y = gp.tileSize * 6;

        mapNumber = 2;
        //gp.npc[mapNumber][5] = new CursedFlower(gp);
        //gp.npc[mapNumber][5].x = gp.tileSize * 5;
        //gp.npc[mapNumber][5].y = gp.tileSize * 6;

        mapNumber = 3;
        gp.npc[mapNumber][5] = new CursedTree(gp);
        gp.npc[mapNumber][5].x = gp.tileSize * 4;
        gp.npc[mapNumber][5].y = gp.tileSize;


    }

}
