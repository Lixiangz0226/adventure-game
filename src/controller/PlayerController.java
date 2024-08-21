package controller;

import javax.imageio.ImageIO;
import javax.swing.*;

import entities.map_objects.ItemsChestObject;
import entities.map_objects.SwordObject;
import entities.stat_entities.Items.PurificationPotion;
import entities.visual_entities.Entity;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The PlayerController class is responsible for managing the player's actions,
 * movement, and interactions within the game world. It extends the Entity class.
 */

public class PlayerController extends Entity {

    //Player attributes
    KeyHandler keyH;
    int hasKey = 0;
    int hasSuperKey = 0;

    //text code, delete after test
    JFrame window;
    Container con;
    JTextArea mainTextArea;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    /**
     * Constructor for the PlayerController class.
     *
     * @param gp   The GamePanel instance associated with this PlayerController.
     * @param keyH The KeyHandler instance used for detecting key inputs.
     */

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

    /**
     * Handles interaction with NPCs based on the player's proximity and key presses.
     *
     * @param i The index of the NPC to interact with.
     */

    //Incomplete method, need to be integrated with other code
    public void interactNPC(int i) {
        if (i != 999) {
            if (keyH.enterPressed) {
                gp.gameState = gp.dialogueState;
                gp.npc[gp.currentMap][i].speak();
            }


            if (keyH.FPressed) {
                System.out.println("Part 2 check");
                switch (gp.npc[gp.currentMap][i].name) {
                    case "Guide":
                        System.out.println("Shop active");
                        gp.gameState = gp.shopState;
                        break;

                    case "Goblin":
                        gp.gameState = gp.battleState;
                        break;

                    case "CursedTree":
                        gp.gameState = gp.bossState;
                        break;

                    case "Bat1":
                        gp.gameState = gp.bat1State;
                        break;

                    case "Bat2":
                        gp.gameState = gp.bat2State;
                        break;

                    case "Bat3":
                        gp.gameState = gp.bat3State;
                        break;

                    case "CursedFlower":
                        gp.gameState = gp.flowerState;
                        break;

                    case "SlotMachine":
                        gp.gameState = gp.slotState;
                        break;

                    case "MysteryBox":
                        gp.gameState = gp.boxState;
                        break;
                }

            }
            keyH.FPressed = false;
        }
        keyH.enterPressed = false;
    }

    /**
     * Handles picking up objects and applying their effects based on the object's name.
     *
     * @param i The index of the object to pick up.
     */

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
                    if(gp.player.getKey() > 5) {
                        gp.obj[gp.currentMap][i] = null;
                    }
                    break;

                case "ForestDoor1":
                    if (gp.playerController.hasSuperKey > 0) {
                        gp.obj[gp.currentMap][i] = null;
                    }
                    break;

                case "ForestDoor2":
                    if (gp.playerController.hasSuperKey > 0) {
                        gp.obj[gp.currentMap][i] = null;
                    }
                    break;

                case "Powder":
                    gp.obj[gp.currentMap][i] = null;
                    gp.player.getInventory().addItem(new PurificationPotion());

                    break;
                
                case "Item_Chest":
                    this.gp.player.getInventory().addItem(((ItemsChestObject) gp.obj[gp.currentMap][i]).getContainedItem());
                    this.gp.obj[this.gp.currentMap][i] = null;
                    break;

                    case "Sword":
                    SwordObject sword = (SwordObject) gp.obj[gp.currentMap][i];
                    if (sword.getContainedWeapon() == null) {
                        this.gp.obj[this.gp.currentMap][i] = null;
                    }
                    else {
                        gp.player.getInventory().addItem(((SwordObject) gp.obj[gp.currentMap][i]).getContainedWeapon());
                        this.gp.obj[this.gp.currentMap][i] = null;
                    }
                    break;

            }
        }

    }

    public void setDefaultValue() {
        x = 340;
        y = 150;
        speed = 4;
        direction = "up";
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

    /**
     * Updates the player's position and handles interactions based on the key inputs.
     * The player's coordinates change to simulate movement when no collision is detected.
     */

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

    /**
     * Draws the player's sprite on the screen based on the direction and current animation frame.
     * Alternates between spriteNumber 1 or 2 every 12 ticks to create animation.
     *
     * @param g2 The Graphics2D object used for drawing the sprite.
     */

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
