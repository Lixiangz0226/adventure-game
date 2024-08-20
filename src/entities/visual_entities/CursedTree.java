package entities.visual_entities;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CursedTree extends Entity {


    public CursedTree(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 0;
        isEnemy = true;
        name = "CursedTree";

        solidAreaDefaultX = 50;
        solidAreaDefaultY = 300;
        solidArea = new Rectangle(0,0,310,60);

        setDialogue();
        getNPCImage();

    }

    //Load in npc sprite from the png files in resources
    public void getNPCImage () {


        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed tree-1.png (1).png"));

            death = ImageIO.read(getClass().getResourceAsStream("/resource/CursedTree/cursed_tree_death.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {

        dialogues[0] = "Oh ho ho";
        dialogues[1] = "You look like good fertilizers";


    }


    //Similar to the player who acts based on keyboard inputs, the npc moves by recieving a direction input through
    //a random integer generator that gives each direction a 25%. The actionLockChecker allows a period of time
    //for each action to last instead of switching to a new direction and action every instance. The checker updates
    //every 120 ticks
    public void setAction() {
        if (gp.cursedTree.status) {

            actionLockCounter++;

            if(actionLockCounter == 120) {
                Random random = new Random();
                int i = random.nextInt(100)+1;

                if(i <= 25) {
                    direction = "up";

                }

                if(i > 25 && i <= 50) {
                    direction = "down";

                }

                if(i > 50 && i <= 75) {
                    direction = "left";

                }

                if(i > 75 && i <= 100) {
                    direction = "right";

                }

                actionLockCounter = 0;

            }


        }
        else {

            direction = "dead";
        }

    }


    public void speak() {

        if(gp.cursedTree.status) {
            if(dialogues[dialogueIndex] == null){
                dialogueIndex = 0;
            }
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;

            switch (gp.playerController.direction) {
                case "up":
                    direction = "front";
                    break;

                case "down":
                    direction = "front";
                    break;

                case "left":
                    direction = "front";
                    break;

                case "right":
                    direction = "front";
                    break;


            }
        }



    }

    public void draw(Graphics2D g2) {

        BufferedImage image = up1;


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


        g2.drawImage(image, x, y, gp.tileSize*8, gp.tileSize*8, null);

    }

}
