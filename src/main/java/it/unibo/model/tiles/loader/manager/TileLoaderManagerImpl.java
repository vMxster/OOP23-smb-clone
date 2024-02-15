package it.unibo.model.tiles.loader.manager;

import java.util.List;
import java.util.Optional;

import it.unibo.commons.Point2D;
import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.DocumentExtractorImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.loader.factory.gameobjects.TileLoaderGameObjectsFactoryImpl;
import it.unibo.model.tiles.loader.factory.stationary.TileLoaderStationaryFactoryImpl;
import it.unibo.model.tiles.loader.gameobjects.TileLoaderGameObjects;
import it.unibo.model.tiles.loader.stationary.TileLoaderStationary;
import it.unibo.model.tiles.manager.TileManager;
/**
 * The implementation of the TileLoaderManager interface is responsible for managing the loading 
 * of StationaryTiles and GameObjects from a TMX file.
*/
public class TileLoaderManagerImpl implements TileLoaderManager {

    private final TileManager tileManager;
    private final TileLoaderGameObjects tileLoaderGameObjects;
    private final TileLoaderStationary tileLoaderStationary;

    /**
     * Constructs a TileLoaderManagerImpl with the specified TileManager and TMX file.
     *
     * @param tileManager The tile manager responsible for managing tiles in the game.
     * @param tmx         The path to the TMX file containing tile information.
     */
    public TileLoaderManagerImpl(final TileManager tileManager, final String tmx) {
        this.tileManager = tileManager;
        final DocumentExtractor documentExtractor = new DocumentExtractorImpl(tmx);
        this.tileLoaderGameObjects = new TileLoaderGameObjectsFactoryImpl()
            .createTileLoaderGameObjects(this, documentExtractor);
        this.tileLoaderStationary = new TileLoaderStationaryFactoryImpl()
            .createTileLoaderStationary(this, documentExtractor);
    }

    /**
     * Loads stationary tiles and objects from the TMX file.
     */
    @Override
    public void load() {
        this.tileLoaderStationary.load();
        this.tileLoaderGameObjects.load();
    }

    @Override
    public final String trim(final String s) {
        return s.contains(".") ? s.replaceAll("\\s+", "") : s;
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
    public final MeatBoy getMeatBoy() {
        return this.tileManager.getMeatBoy();
    }

    @Override
    public final BandageGirl getBandageGirl() {
        return this.tileManager.getBandageGirl();
    }

    @Override
    public final List<List<Optional<Tile>>> getStationary() {
        return this.tileManager.getStationary();
    }

    @Override
    public final List<Tile> getTiles() {
        return this.tileManager.getTiles();
    }

    @Override
    public final void setPlatform(final Platform platform) {
        this.tileManager.setPlatform(platform);
    }

    @Override
    public final void setSaw(final CircularSaw circularSaw) {
        this.tileManager.setSaw(circularSaw);
    }

    @Override
    public final void setMeatBoyCoord(final Point2D<Double, Double> coord) {
        this.tileManager.setMeatBoyCoord(coord);
    }

    @Override
    public final void setBandageGirlCoord(final Point2D<Double, Double> coord) {
        this.tileManager.setBandageGirlCoord(coord);
    }

}
