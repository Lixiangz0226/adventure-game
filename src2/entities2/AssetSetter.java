package entities2;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new KeyObject();
        gp.obj[0].x = 7 * gp.tileSize;
        gp.obj[0].y = 6 * gp.tileSize;

        gp.obj[1] = new DoorObject();
        gp.obj[1].x = 7 * gp.tileSize;
        gp.obj[1].y = 0 * gp.tileSize;

        gp.obj[2] = new TeleporterObject();
        gp.obj[2].x = 5 * gp.tileSize;
        gp.obj[2].y = 5 * gp.tileSize;

    }

}
