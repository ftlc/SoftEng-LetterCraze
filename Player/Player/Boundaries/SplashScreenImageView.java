package Player.Boundaries;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SplashScreenImageView extends JPanel {

	Image i;
	
	public SplashScreenImageView() {
		i = new ImageIcon(getClass().getResource("Images/LetterCraze.png")).getImage();
	}
	
	public void refresh() {		
		repaint();
	}

	
	public void paint(Graphics g) {
		g.drawImage(i, 0 , 0, null);
	}
}
