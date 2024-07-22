package view;


import use_case.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    //Attributes
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNumber;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNumber = new int[gp.maxScreenCol][gp.maxScreenRow];

        this.getTileImage();
        this.loadMap();
    }

    //Load the png files from resources
    public void getTileImage() {

        try {
            tile[0] = new Tile ();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/view/Forest_barrier.png.png"));
            tile[0].collision = true;

            tile[1] = new Tile ();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/view/Forest_ground.png.png"));

            tile[2] = new Tile ();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/view/Room_Floor.png"));

            tile[3] = new Tile ();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/view/Room_Wall.png"));
            tile[3].collision = true;

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Load the data from the map txt into the mapTileNumber array, which holds the where and what of each tiles in a
    //nested array
    public void loadMap () {

        try {
            InputStream is = getClass().getResourceAsStream("/maps/testmap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine();

                while(col < gp.maxScreenCol) {

                    char[] tileArray = new char[gp.maxScreenCol];
                    line.getChars(0, gp.maxScreenCol, tileArray, 0);
                    int num = Character.getNumericValue(tileArray[col]);
                    mapTileNumber[col][row] = num;
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

    //Using tile data provided by the mapTileNumber array, draw the map until it reaches the maxScreenCol/Row
    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNumber = mapTileNumber[col][row];

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
