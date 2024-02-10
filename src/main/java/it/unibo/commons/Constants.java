package it.unibo.commons;

/**
 * This class provides constants used throughout the application.
 */
public final class Constants {

    /** The size of a tile in pixels. */
    public static final int TILE_SIZE = 20;

    /** The width of the screen. */
    public static final int SW = 800;

    /** The height of the screen. */
    public static final int SH = 600;

    /** The source map file path. */
    public static final String SOURCE_MAP = "file:./src/main/resources/factory1.tmx";

    /**
     * Private constructor to prevent instantiation.
     * Utility classes should not be instantiated.
     */
    private Constants() {
    }

}
