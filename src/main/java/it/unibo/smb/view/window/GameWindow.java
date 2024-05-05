package it.unibo.smb.view.window;

import it.unibo.smb.controller.EnvironmentType;
import it.unibo.smb.controller.GameController;

/**
 * The GameWindow interface represents a window for a game application.
 * It defines methods for initializing window properties and the game panel.
 */
public interface GameWindow {

    /**
     * Enumeration representing different types of panels in a game or application.
     * Possible values include GAME, MENU, SCOREBOARD, LEVELS, and LOADING.
     */
    enum PanelType { GAME, MENU, SCOREBOARD, LEVELS, LOADING }

    /**
     * Starts the game window with the specified environment type and game controller.
     *
     * @param env        The environment type of the game.
     * @param controller The game controller managing the game logic.
     */
    void start(EnvironmentType env, GameController controller);

    /**
     * Updates the statistics displayed in the game window.
     */
    void updateStats();

    /**
     * Paints the content of the game window.
     * This method is responsible for updating and rendering the content of the game window.
     * It should be called whenever the content needs to be refreshed or repainted.
     *
     * @param centiSeconds  Time in hundredths of a second.
     * @param currentDeaths Number of deaths in the current session.
     */
    void paint(int centiSeconds, int currentDeaths);

    /**
     * Displays a graphical message or UI elements indicating the player's victory.
     */
    void displayVictoryMessage();

    /**
     * Sets the current panel visible.
     */
    void setPanelVisible();

    /**
     * Switches between different panels within the game window.
     *
     * @param type The type of panel to set.
     */
    void switchPanel(PanelType type);
}
