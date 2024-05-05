package it.unibo.smb.controller;

/**
 * Enum representing different types of levels in the game.
 */
public enum LevelType {
    /**
     * The first level in the forest environment.
     */
    FOREST_LEVEL_1(EnvironmentType.FOREST, 1, "forest1.tmx"),

    /**
     * The second level in the forest environment.
     */
    FOREST_LEVEL_2(EnvironmentType.FOREST, 2, "forest2.tmx"),

    /**
     * The first level in the factory environment.
     */
    FACTORY_LEVEL_1(EnvironmentType.FACTORY, 1, "factory1.tmx"),

    /**
     * The second level in the factory environment.
     */
    FACTORY_LEVEL_2(EnvironmentType.FACTORY, 2, "factory2.tmx");

    private final EnvironmentType environment;
    private final int levelNumber;
    private final String tmxMap;

    /**
     * Constructs a new LevelType with the specified environment, level number, and source map.
     * @param environment The environment associated with the level.
     * @param levelNumber The level number.
     * @param tmxMap The source map file name.
     */
    LevelType(final EnvironmentType environment, final int levelNumber, final String tmxMap) {
        this.environment = environment;
        this.levelNumber = levelNumber;
        this.tmxMap = tmxMap;
    }

    /**
     * Gets the environment associated with the level.
     * @return The environment type.
     */
    public EnvironmentType getEnvironment() {
        return this.environment;
    }

    /**
     * Gets the level number.
     * @return The level number.
     */
    public int getLevelNumber() {
        return this.levelNumber;
    }

    /**
     * Gets the source map file name.
     * @return The source map file name.
     */
    public String getSourceMap() {
        return this.tmxMap;
    }

    /**
     * Gets the name of the level.
     * @return The name of the level (derived from the source map file name).
     */
    public String getName() {
        return this.tmxMap.substring(0, this.tmxMap.lastIndexOf('.'));
    }

}
