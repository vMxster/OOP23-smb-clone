package it.unibo.view.window;

/**
 * The GameWindow interface represents a window for a game application.
 * It defines methods for initializing window properties and the game panel.
 */
public interface GameWindow {

    enum PanelType { GAME, MENU, SCOREBOARD }
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
     * Initializes the game panel, setting up its layout and content.
     * This method is responsible for creating and configuring the game panel
     * that will be displayed within the game window.
     */
    void initializeGamePanel();
    
    /**
     * This method set visible the current panel.
     */
    void setPanelVisible();

    /**
     * This method is responsible for switching between different panels within the game window.
     */
    void switchPanel(PanelType type);
}
