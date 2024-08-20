package entities.visual_entities;

import controller.GamePanel;
import controller.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//Super class for all entity classes
public class Entity {
    //Set up default attributes for all entities, override by subclasses if necessary
    protected GamePanel gp;
    public int x, y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, death;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea = new Rectangle(0,0,42,60);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    String dialogues[] = new String[20];
    int dialogueIndex = 0;

    public boolean isEnemy;
    public String name;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }


    public void setAction() {

    }
    public void setDialogues() {
    }

    public void speak() {

    }

    //Entities are unable to move via changing x,y coordinates if collisionOn is true
    //Update spriteCounter every 12 ticks
    public void update() {
        setAction();

        collisionOn = false;

        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkPlayer(this);

        if (collisionOn == false) {

            switch (direction) {
                case "up":
                    y  -= speed;
                    break;

                case "down":
                    y += speed;
                    break;

                case "left":
                    x -= speed;
                    break;

                case "right":
                    x += speed;
                    break;
            }

        }
        else {
            collisionOn = true;
        }

        spriteCounter++;
        if(spriteCounter > 12) {
            if(spriteNumber == 1) {
                spriteNumber = 2;
            }
            else if(spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;

        }

    }


    //Depending on the entity direction and spriteCounter, update the sprite of the entity
    public void draw(Graphics2D g2) {

        BufferedImage image = null;


        switch (direction) {
            case "right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                if (spriteNumber == 2) {
                    image = right2;
                }
                break;

            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                if (spriteNumber == 2) {
                    image = left2;
                }
                break;

            case "down":
                if (spriteNumber == 1) {
                    image = down1;
                }
                if (spriteNumber == 2) {
                    image = down2;
                }
                break;

            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                }
                if (spriteNumber == 2) {
                    image = up2;
                }
                break;

            case "dead":
                image = death;

        }


        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }


    public BufferedImage setup(String imagePath, int width, int height) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            image = uTool.scaleImage(image, width, height);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return image;
    }

}
