package Player.Boundaries;


import javax.swing.JFrame;

import Player.Entities.Model;

public class SplashScreenView extends JFrame {
	
	/**
	 * Constructor for the SplashScreenView class
	 * @param m Model to pass to the MainMenuView spawned after the splash screen ends
	 */
	public SplashScreenView(Model m) {
		SplashScreenImageView s = new SplashScreenImageView();
		
		setSize(800 , 800);
		setLocationRelativeTo(null);
		setContentPane(s);
		setVisible(true);
		s.refresh();
		
		try {
			Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setVisible(false);
		dispose();
		MainMenuView menu = new MainMenuView(m);
	}
	
}
