package entities.map_objects;

import controller.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

//Super class for all objects, can be over ride if necessary
public class Object {

    public BufferedImage image;
    public String name;
    public Boolean collision = false;
    public int x, y;
    public Rectangle solidArea = new Rectangle(0,0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        //if u want the item to move with u
        //int screenX = x - gp.player.x + gp.player.screenX;
        //int screenY = y - gp.player.y + gp.player.screenY;

        //if(x + gp.tileSize > gp.player.x - gp.player.screenX &&
                //x - gp.tileSize < gp.player.x + gp.player.screenX &&
                //y + gp.tileSize > gp.player.y - gp.player.screenY &&
                //y - gp.tileSize < gp.player.y + gp.player.screenY) {

            //g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }


}