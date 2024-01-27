package it.unibo.commons;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {
    
    public static final int MEATBOY_WIDTH = 20;
	public static final int MEATBOY_HEIGHT = 20;
    public static final int TILE_SIZE = 20;
    public static final int PROPORTION = 2;

    public static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SW = (int) screen.getWidth();
    public static final int SH = (int) screen.getHeight();
    public static final String STRING_MAP = "file:./src/main/resources/factory1.tmx";

}
