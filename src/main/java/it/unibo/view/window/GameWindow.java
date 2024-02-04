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
     * Initializes the properties of the game window, such as size, title, and behavior.
     * This method should be called to set up the initial configuration of the game window.
     */
    void initializeWindowProperties();

    /**
     * Initializes the game panel, setting up its layout and content.
     * This method is responsible for creating and configuring the game panel
     * that will be displayed within the game window.
     */
    void initializeGamePanel();

    /**
     * This method is responsible for showing a graphical message or UI elements
     * indicating the player's victory.
     */
    void displayVictoryMessage();
    
}

