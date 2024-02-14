package it.unibo.model.level;

import java.util.List;
import java.util.Optional;

import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.manager.TileManager;
import it.unibo.model.tiles.manager.TileManagerImpl;
import it.unibo.commons.Point2D;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;

/**
 * Implementation of the Level interface that reads a tmx file and creates a level from it.
 */
public class LevelImpl implements Level {

    private final TileManager tileManager;
    private final MeatBoy meatBoy;
    private final BandageGirl bandageGirl;
    private final Point2D<Double, Double> meatBoyStartCoord;

    /**
     * Constructs a new instance of LevelImpl with the specified tmx file.
     *
     * @param tmx The URL to the tmx file representing the level.
     */
    public LevelImpl(final String tmx) {
        this.tileManager = new TileManagerImpl(tmx);
        this.meatBoy = this.tileManager.getMeatBoy();
        this.bandageGirl = this.tileManager.getBandageGirl();
        this.meatBoyStartCoord = new Point2D<>(
            this.meatBoy.getX(),
            this.meatBoy.getY());
    }

    @Override
    public final MeatBoy getMeatBoy() {
        return this.meatBoy;
    }

    @Override
    public final Point2D<Double, Double> getMeatBoyStartCoord() {
        return this.meatBoyStartCoord.copy();
    }

    @Override
    public final BandageGirl getBandageGirl() {
        return this.bandageGirl;
    }

    @Override
    public final List<List<Optional<Tile>>> getStationary() {
        return this.tileManager.getStationary();
    }

    @Override
    public final List<Platform> getPlatforms() {
        return this.tileManager.getPlatforms();
    }

    @Override
    public final List<CircularSaw> getSaws() {
        return this.tileManager.getSaws();
    }

    @Override
    public final int getNumCols() {
        return this.tileManager.getNumCols();
    }

    @Override
    public final int getNumRows() {
        return this.tileManager.getNumRows();
    }

}
