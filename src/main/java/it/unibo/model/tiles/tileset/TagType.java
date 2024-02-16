package it.unibo.model.tiles.tileset;

/**
 * Enum representing different types of tags used in a tileset.
 */
public enum TagType {

    /**
     * Represents the "tileset" tag.
     */
    TILESET("tileset"),

    /**
     * Represents the "image" tag.
     */
    IMAGE("image"),

    /**
     * Represents the "width" tag.
     */
    WIDTH("width"),

    /**
     * Represents the "height" tag.
     */
    HEIGHT("height"),

    /**
     * Represents the "map" tag.
     */
    MAP("map"),

    /**
     * Represents the "source" tag.
     */
    SOURCE("source");

    private final String tagName;

    /**
     * Constructs a TagType enum with the given tag name.
     *
     * @param tagName The name of the tag.
     */
    TagType(final String tagName) {
        this.tagName = tagName;
    }

    /**
     * Returns the string representation of this TagType.
     *
     * @return The string representation of this TagType.
     */
    @Override
    public String toString() {
        return this.tagName;
    }

}
