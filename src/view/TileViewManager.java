package view;


import controller.GamePanel;
import entities.visual_entities.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Manages the tiles and maps for the game, including loading tile images and map data.
 */

public class TileViewManager {

    //Attributes
    GamePanel gp;
    public Tile[] tile;
    public int[][][] mapTileNumber;

    /**
     * Constructs a TileViewManager instance and initializes tiles and map data.
     *
     * @param gp The GamePanel instance that this TileViewManager will interact with.
     */

    public TileViewManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[20];
        mapTileNumber = new int[gp.maxMap][gp.maxScreenCol][gp.maxScreenRow];

        this.getTileImage();
        this.loadMap("/resource/maps/starting_forest.txt",0);
        this.loadMap("/resource/maps/dark_cavern.txt",1);
        this.loadMap("/resource/maps/dark_forest.txt",2);
        this.loadMap("/resource/maps/boss_chamber.txt",3);
    }

    /**
     * Loads tile images from resources and initializes the Tile objects.
     */

    //Load the png files from resources
    public void getTileImage() {

        try {
            tile[0] = new Tile ();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Starting_Forest/Forest_barrier.png.png"));
            tile[0].collision = true;

            tile[1] = new Tile ();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Starting_Forest/Forest_ground.png.png"));

            tile[2] = new Tile ();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Starting_Forest/Room_Floor.png"));

            tile[3] = new Tile ();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Starting_Forest/Room_Wall.png"));
            tile[3].collision = true;

            tile[4] = new Tile ();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Dark_Cavern/Cavern_Wall.png"));
            tile[4].collision = true;

            tile[5] = new Tile ();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Dark_Cavern/Cavern_Ground.png"));

            tile[6] = new Tile ();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Dark_Forest/Dark_Forest_Barrier.png"));
            tile[6].collision = true;

            tile[7] = new Tile ();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/resource/tile/Dark_Forest/Dark_Forest_ground.png-1.png.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Loads map data from a text file into the mapTileNumber array.
     *
     * @param filePath  The path to the map file.
     * @param mapNumber The index of the map to load.
     */

    public void loadMap (String filePath, int mapNumber) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            //Load the data from the map txt into the mapTileNumber array, which holds the where and what of each tiles in a
            //nested array

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine();

                while(col < gp.maxScreenCol) {

                    char[] tileArray = new char[gp.maxScreenCol];
                    line.getChars(0, gp.maxScreenCol, tileArray, 0);
                    int num = Character.getNumericValue(tileArray[col]);
                    mapTileNumber[mapNumber][col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol) {
                    col = 0;
                    row++;

                }
            }
            br.close();

        }catch(IOException e) {
            System.err.println(e);

        }
    }

    /**
     * Draws the tiles on the screen based on the mapTileNumber array.
     *
     * @param g2 The Graphics2D object used for drawing.
     */

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        //Using tile data provided by the mapTileNumber array, draw the map until it reaches the maxScreenCol/Row
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNumber = mapTileNumber[gp.currentMap][col][row];

            g2.drawImage(tile[tileNumber].image, x, y, gp.tileSize, gp.tileSize, null);

            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }

        }

    }

}
