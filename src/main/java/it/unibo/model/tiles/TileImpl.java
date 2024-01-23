package it.unibo.model.tiles;

public class TileImpl implements Tile {

    private final int x;
    private final int y;
    private final String srcImage;
    
    public TileImpl(int x, int y, String srcImage) {
        this.x = x;
        this.y = y;
        this.srcImage = srcImage;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getSrcImage() {
        return this.srcImage;
    }

}
