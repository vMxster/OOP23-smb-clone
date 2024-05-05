package it.unibo.smb.view.panel;

import it.unibo.smb.commons.Constants;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serial;
import java.util.Objects;

/**
 * A panel used to display a loading screen while the game is loading.
 */
public class LoadingPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 1;
    private final ImageIcon loadingIcon;

    /**
     * Constructs a new LoadingPanel with the loading screen ImageIcon.
     */
    public LoadingPanel() {
        loadingIcon = new ImageIcon(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource("loadingscreen.png")));
        setPreferredSize(
                new Dimension(
                        (int) (loadingIcon.getIconWidth() * Constants.SCALE_PROPORTION),
                        (int) (loadingIcon.getIconHeight() * Constants.SCALE_PROPORTION)));
    }

    @Override
    protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Image image = loadingIcon.getImage();
        g.drawImage(
                image,
                0,
                0,
                (int) (image.getWidth(this) * Constants.SCALE_PROPORTION),
                (int) (image.getHeight(this) * Constants.SCALE_PROPORTION),
                this);
    }

}
