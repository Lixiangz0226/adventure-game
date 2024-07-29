package controller;

import entities.AbstractEntity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(AbstractEntity entity) {

        //LeftX and RightX makes up the width of the solid rectangle of the player entity
        //TopY and BottomY makes up the length of the solid rectangle of the player entity
        //Here solidArea.x = 8, solidArea.Y = 16, solidArea.height = 32, solidArea.width = 32
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftX/gp.tileSize;
        int entityRightCol = entityRightX/gp.tileSize;
        int entityTopRow = entityTopY/gp.tileSize;
        int entityBottomRow = entityBottomY/gp.tileSize;

        //Note the player can hit at most two tiles at once due to its size, hence we only need to check
        //tileNumber1 and 2
        int tileNumber1, tileNumber2;

        //The switch statement checks the tile the player is hitting depending on his direction, then checks
        //if they have collision. If either tiles do, player collision is turned on, and both player and entity have
        // collision therefore preventing player to continue moving
        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileA.mapTileNumber[entityLeftCol][entityTopRow];
                tileNumber2 = gp.tileA.mapTileNumber[entityRightCol][entityTopRow];
                if(gp.tileA.tile[tileNumber1].collision == true || gp.tileA.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomY + entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileA.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNumber2 = gp.tileA.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tileA.tile[tileNumber1].collision == true || gp.tileA.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileA.mapTileNumber[entityLeftCol][entityTopRow];
                tileNumber2 = gp.tileA.mapTileNumber[entityLeftCol][entityBottomRow];
                if(gp.tileA.tile[tileNumber1].collision == true || gp.tileA.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileA.mapTileNumber[entityRightCol][entityTopRow];
                tileNumber2 = gp.tileA.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tileA.tile[tileNumber1].collision == true || gp.tileA.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

        }

    }

    //Check if player is hitting any object, if true, we return the index of that object which corresponds to that
    //specific object's index in the array
    public int checkObject(AbstractEntity entity, boolean player) {

        int index = 999;

        //Go through the object array, locate the solid area of the player and the object, if they touch, index will
        //become i, then the code returns the index of the object the player just touched
        for(int i = 0; i < gp.obj.length; i++) {
            if(gp.obj[i] != null) {

                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

            }
        }

        return index;
    }

    //Functions nearly identical to checkObject
    public int checkEntity(AbstractEntity entity, AbstractEntity[] target) {
        int index = 999;

        for(int i = 0; i < target.length; i++) {
            if(gp.npc[i] != null) {

                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;

            }
        }

        return index;

    }

    //Check if the entity is hitting the player, if true, turn on entity collision
    public void checkPlayer(AbstractEntity entity) {

        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.y + entity.solidArea.y;

        gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;

        switch (entity.direction) {
            case "up":
                entity.solidArea.y -= entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entity.solidArea.y += entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entity.solidArea.x -= entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entity.solidArea.x += entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;

        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

    }
}
