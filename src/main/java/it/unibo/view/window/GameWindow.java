package it.unibo.view.window;

/**
 * The GameWindow interface represents a window for a game application.
 * It defines methods for initializing window properties and the game panel.
 */
public interface GameWindow {

    /**
     * Paints the content of the game window.
     * This method is responsible for updating and rendering the content of the game window.
     * It should be called whenever the content needs to be refreshed or repainted.
     */
    void paint();

    /**
     * This method is responsible for showing a graphical message or UI elements
     * indicating the player's victory.
     */
    void displayVictoryMessage();

    /**
     * This method is responsible for switching between different panels within the game window.
     */
    void switchPanel();

}
