package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestTile {

    private final Tile tile;

    @BeforeEach
    public void init() {
        tile = new TileImpl(1, 2, "image.png");
    }

    @Test
    public void testGetX() {
        assertEquals(1, tile.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(2, tile.getY());
    }

    @Test
    public void testGetSrcImage() {
        assertEquals("image.png", tile.getSrcImage());
    }

}
