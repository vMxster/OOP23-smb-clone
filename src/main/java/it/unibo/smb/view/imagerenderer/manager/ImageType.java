package it.unibo.smb.view.imagerenderer.manager;

/**
 * The ImageType enum represents different types of images used in the application.
 */
public enum ImageType {
    /**
     * Image representing the character Meat Boy.
     */
    MEAT_BOY("meatboy.png"),

    /**
     * Image representing the Saws.
     */
    SAWS("buzzsaw2.png"),

    /**
     * Image representing the Forest's Background.
     */
    FORESTBG("forestbg.png"),

    /**
     * Image representing the Factory's Background.
     */
    FACTORYBG("factorybg.png");

    private final String imageName;

    /**
     * Constructs an ImageType enum constant with the specified image name.
     *
     * @param imageName The name of the image file.
     */
    ImageType(final String imageName) {
        this.imageName = imageName;
    }

    /**
     * Returns the name of the image file associated with this ImageType.
     *
     * @return The name of the image file.
     */
    @Override
    public String toString() {
        return this.imageName;
    }

}
