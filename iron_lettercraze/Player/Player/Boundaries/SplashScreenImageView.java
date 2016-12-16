package Player.Boundaries;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SplashScreenImageView extends JPanel {

	Image i;
	
	/**
	 * Constructor for the SplashScreenImageView class, initializes the image,
	 * and prepares it to be displayed.
	 */
	public SplashScreenImageView() {
		i = new ImageIcon(getClass().getResource("Images/LetterCraze.png")).getImage();
	}
	
	/**
	 * Draws the image to the JPanel
	 */
	public void refresh() {		
		repaint();
	}

	/**
	 * Called by refresh() to draw the image to the JPanel.
	 */
	public void paint(Graphics g) {
		g.drawImage(i, 0 , 0, null);
	}
}
