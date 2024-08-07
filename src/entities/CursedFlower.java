package entities;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CursedFlower extends AbstractEntity {




    public BufferedImage sp1, sp2, sp3;
    int i = 0;



    public CursedFlower(GamePanel gp) {
        super(gp);

        speed = 1;
        isEnemy = false;

        setDialogue();
        getNPCImage();



    }

    //Load in npc sprite from the png files in resources
    public void getNPCImage () {
        try {
            sp1 = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Cursed_Flower/Cursed Flower-1.png"));
            sp2 = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Cursed_Flower/Cursed Flower-2.png"));
            sp3 = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Cursed_Flower/Cursed Flower-3.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {
        dialogues[0] = "Hello kid";
        dialogues[1] = "Bye kid";
        dialogues[2] = "Go away kid";
        dialogues[3] = "I SAID GO AWAY";


    }


    //Similar to the player who acts based on keyboard inputs, the npc moves by recieving a direction input through
    //a random integer generator that gives each direction a 25%. The actionLockChecker allows a period of time
    //for each action to last instead of switching to a new direction and action every instance. The checker updates
    //every 120 ticks
    public void setAction() {
        actionLockCounter++;

        if(actionLockCounter == 60) {
            switch(i) {
                case 0:
                    direction = "sp1";
                    break;
                case 1:
                    direction = "sp2";
                    break;
                case 2:
                    direction = "sp3";
                    break;
            }
            actionLockCounter = 0;
            i = (i + 1) % 3;  // Reset i to 0 after it reaches 3

        }
    }

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
            case "sp1":
                image = sp1;
                break;

            case "sp2":
                image = sp2;
                break;
            case "sp3":
                image = sp3;
                break;
        }


        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }


}
