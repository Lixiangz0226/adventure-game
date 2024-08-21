package controller;

import entities.map_objects.*;
import entities.stat_entities.Items.Life_Potion;
import entities.visual_entities.Goblin;
import entities.visual_entities.NPC_Guide;
import entities.visual_entities.*;

/**
 * The {@code AssetSetter} class is responsible for initializing and placing various objects and NPCs
 * on the game map. This class uses defined coordinates to set the locations of these assets on
 * different locations of different maps within the game.
 */

public class AssetSetter {

    GamePanel gp;


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
        gp.obj[mapNumber][3].x = 6 * gp.tileSize;
        gp.obj[mapNumber][3].y = 8 * gp.tileSize;

        gp.obj[mapNumber][4] = new PurificationPowder();
        gp.obj[mapNumber][4].x = 9 * gp.tileSize;
        gp.obj[mapNumber][4].y = 8 * gp.tileSize;

        gp.obj[mapNumber][5] = new ForestDoor1();
        gp.obj[mapNumber][5].x = 0 * gp.tileSize;
        gp.obj[mapNumber][5].y = 5 * gp.tileSize;

        gp.obj[mapNumber][6] = new ItemsChestObject(new Life_Potion());
        gp.obj[mapNumber][6].x = 3 * gp.tileSize;
        gp.obj[mapNumber][6].y = 3 * gp.tileSize;


        gp.obj[mapNumber][11] = new SwordObject();
        gp.obj[mapNumber][11].x = 3 * gp.tileSize;
        gp.obj[mapNumber][11].y = 8 * gp.tileSize;

        //gp.obj[mapNumber][6] = new ForestDoor2();
        //gp.obj[mapNumber][6].x = 15 * gp.tileSize;
        //gp.obj[mapNumber][6].y = 5 * gp.tileSize;

        gp.obj[mapNumber][9] = new KeyObject();
        gp.obj[mapNumber][9].x = 7 * gp.tileSize;
        gp.obj[mapNumber][9].y = 8 * gp.tileSize;

        mapNumber = 1;
        gp.obj[mapNumber][7] = new CavernDoor();
        gp.obj[mapNumber][7].x = 6 * gp.tileSize;
        gp.obj[mapNumber][7].y = 6 * gp.tileSize;

        mapNumber = 2;
        gp.obj[mapNumber][8] = new DoorObject();
        gp.obj[mapNumber][8].x = 10 * gp.tileSize;
        gp.obj[mapNumber][8].y = 5 * gp.tileSize;

        gp.obj[mapNumber][10] = new SuperKey();
        gp.obj[mapNumber][10].x = 14 * gp.tileSize;
        gp.obj[mapNumber][10].y = 9 * gp.tileSize;



    }

    //Create and ;oad in the npc entity into specific coordinates
    public void setNPC() {

        int mapNumber = 0;

        gp.npc[mapNumber][0] = new NPC_Guide(gp);
        gp.npc[mapNumber][0].x = gp.tileSize * 4;
        gp.npc[mapNumber][0].y = gp.tileSize * 4;

        gp.npc[mapNumber][8] = new YoungKid(gp);
        gp.npc[mapNumber][8].x = gp.tileSize * 7;
        gp.npc[mapNumber][8].y = gp.tileSize * 2;


        mapNumber = 1;
        gp.npc[mapNumber][1] = new Bat1(gp);
        gp.npc[mapNumber][1].x = gp.tileSize * 9;
        gp.npc[mapNumber][1].y = gp.tileSize * 4;

        gp.npc[mapNumber][2] = new Bat2(gp);
        gp.npc[mapNumber][2].x = gp.tileSize * 7;
        gp.npc[mapNumber][2].y = gp.tileSize * 7;

        gp.npc[mapNumber][3] = new Bat3(gp);
        gp.npc[mapNumber][3].x = gp.tileSize * 10;
        gp.npc[mapNumber][3].y = gp.tileSize * 6;

        gp.npc[mapNumber][8] = new MysteryBox(gp);
        gp.npc[mapNumber][8].x = gp.tileSize * 2;
        gp.npc[mapNumber][8].y = gp.tileSize * 6;

        mapNumber = 2;
        gp.npc[mapNumber][4] = new CursedFlower(gp);
        gp.npc[mapNumber][4].x = gp.tileSize * 6;
        gp.npc[mapNumber][4].y = gp.tileSize * 4;

        gp.npc[mapNumber][5] = new Goblin(gp);
        gp.npc[mapNumber][5].x = gp.tileSize * 3;
        gp.npc[mapNumber][5].y = gp.tileSize * 4;

        gp.npc[mapNumber][6] = new SlotMachine(gp);
        gp.npc[mapNumber][6].x = gp.tileSize * 12;
        gp.npc[mapNumber][6].y = gp.tileSize * 5;



        mapNumber = 3;
        gp.npc[mapNumber][7] = new CursedTree(gp);
        gp.npc[mapNumber][7].x = gp.tileSize * 4;
        gp.npc[mapNumber][7].y = gp.tileSize;


    }

}
