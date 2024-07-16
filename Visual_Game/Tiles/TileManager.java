package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

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

    public void getTileImage() {

        try {
            tile[0] = new Tile ();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Forest_barrier.png.png"));
            tile[0].collision = true;

            tile[1] = new Tile ();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Forest_ground.png.png"));

            tile[2] = new Tile ();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("New Piskel-1.png.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

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
