package entities;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.GamePanel;
import controller.KeyHandler;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class PlayerController extends AbstractEntity {

    //Player attributes
    KeyHandler keyH;
    int hasKey = 0;
    int hasSuperKey = 0;


    //text code, delete after test
    JFrame window;
    Container con;
    JTextArea mainTextArea;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    //Player constructor
    public PlayerController(GamePanel gp, KeyHandler keyH) {

        super(gp);
        this.keyH = keyH;

        //Create a solid rectangle that grants player collision attribute
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 15;
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

    //Load player sprites from the resource package
    public void getPlayerImage () {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Back_1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Back_2.png.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Front_1.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Front_2.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Lside_1.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Lside_2.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Rside_1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/resource/player/Rside_2.png.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Using the directPressed from the keyHandler, assign the position of the player
    //If no collision if affecting the player, change the player's x,y coordinates to simulate movement
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

            //check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //check npc collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //check event
            gp.eHandler.checkEvent();

            //if no collision is on, player is able to move
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

    //Incomplete method, need to be integrated with other code
    private void interactNPC(int i) {
        if (i != 999) {
            if(gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[gp.currentMap][i].speak();
            }

        }
        gp.keyH.enterPressed = false;

        //    if(gp.gameState == gp.dialogueState) {
        //        if (gp.npc[gp.currentMap][i].isEnemy == false) {
        //            gp.gameState = gp.shopState;
        //        }
        //        else if (gp.npc[gp.currentMap][i].isEnemy == true) {
        //            gp.gameState = gp.battleState;
        //        }
        //
        //    }
        //gp.keyH.FPressed = false;


    }

    //Depending on the name of the object, set object to null (to simulate pick up) and update the object's affect
    public void pickUpObject(int i) {

        if(i != 999) {

            String objectName = gp.obj[gp.currentMap][i].name;

            switch (objectName) {
                case "Key":
                    gp.obj[gp.currentMap][i] = null;
                    hasKey++;
                    break;

                case "Door":
                    if(hasKey > 0) {
                        gp.obj[gp.currentMap][i] = null;
                        hasKey--;
                    }
                    break;

                case "Teleporter":
                    System.out.println("You hit an object");

                case "Super_Key":
                    gp.obj[gp.currentMap][i] = null;
                    hasSuperKey++;
                    break;

                case "Goal_Door":
                    if(hasSuperKey > 0) {
                        gp.obj[gp.currentMap][i] = null;
                        hasSuperKey--;
                        break;
                    }

            }
        }

    }

    //Update the player sprite depending on the direction
    //Alternate between spriteNumber 1 or 2 every 12 ticks to create animation
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
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }

}
