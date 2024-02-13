package it.unibo.controller;

import java.util.List;
import java.util.Optional;

import it.unibo.model.GameModel;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;

/**
 * Interface representing a Controller for Managing the SuperMeatBoy Game.
 */
public interface GameController {

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Retrieves the grid of tiles representing the stationary object.
     *
     * @return A list of lists of tiles, where each list represents a row of tiles.
     */
    List<List<Optional<Tile>>> getStationary();

    /**
     * Retrieves a list of CircularSaw present in the game.
     *
     * @return A list of CircularSaw.
     */
    List<CircularSaw> getSaws();

    /**
     * Retrieves a list of Platform present in the game.
     *
     * @return A list of Platform.
     */
    List<Platform> getPlatforms();

    /**
     * Returns the BandageGirl parsed from the TMX file.
     *
     * @return The BandageGirl parsed from the TMX file.
     */
    BandageGirl getBandageGirl();

    /**
     * Returns the MeatBoy parsed from the TMX file.
     *
     * @return The MeatBoy parsed from the TMX file.
     */
    MeatBoy getMeatBoy();

    /**
     * Retrieves the number of Map rows.
     *
     * @return The number of rows.
     */
    int getNumRows();

    /**
     * Retrieves the number of Map columns.
     *
     * @return The number of columns.
     */
    int getNumCols();

    /**
     * Retrieves the GameModel.
     *
     * @return The GameModel.
     */
    GameModel getGameModel();

    /**
     * Signals a victory event.
     * This method is called to indicate that the game has been won.
     */
    void victory();
}
