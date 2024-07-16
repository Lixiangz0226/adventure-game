package entities;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage () {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Back_1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Back_2.png.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Front_1.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Front_2.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Lside_1.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Lside_2.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Rside_1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Rside_2.png.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update () {

        if(keyH.upPressed == true || keyH.downPressed == true ||
                keyH.rightPressed == true || keyH.leftPressed == true) {

            if(keyH.upPressed == true) {
                direction = "up";
            }
            else if(keyH.downPressed == true) {
                direction = "down";
            }
            else if(keyH.leftPressed == true) {
                direction = "left";
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);



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

    }

    public void pickUpObject(int i) {

        if(i != 999) {

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Key":
                    gp.obj[i] = null;
                    hasKey++;
                    break;
                case "Door":
                    if(hasKey > 0) {
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    break;
                case "Teleporter":
                    gp.obj[i] = null;
                    gp.player.speed = 10;









            }
        }


    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "right":
                if(spriteNumber == 1) {
                    image = right1;
                }
                if(spriteNumber == 2) {
                    image = right2;
                }
                break;

            case "left":
                if(spriteNumber == 1) {
                    image = left1;
                }
                if(spriteNumber == 2) {
                    image = left2;
                }
                break;

            case "down":
                if(spriteNumber == 1) {
                    image = down1;
                }
                if(spriteNumber == 2) {
                    image = down2;
                }
                break;

            case "up":
                if(spriteNumber == 1) {
                    image = up1;
                }
                if(spriteNumber == 2) {
                    image = up2;
                }
                break;
        };

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);



    }
}
