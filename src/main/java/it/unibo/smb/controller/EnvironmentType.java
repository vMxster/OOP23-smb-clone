package it.unibo.smb.controller;

/**
 * Enum representing different types of environments in the game.
 */
public enum EnvironmentType {

    /**
     * The forest environment.
     */
    FOREST("Forest"),

    /**
     * The factory environment.
     */
    FACTORY("Factory");

    private final String name;

    /**
     * Constructs a new EnvironmentType with the specified name.
     * @param name The name of the environment.
     */
    EnvironmentType(final String name) {
        this.name = name;
    }

    /**
     * Gets the name of the environment.
     * @return The name of the environment.
     */
    public String getName() {
        return this.name;
    }
}
