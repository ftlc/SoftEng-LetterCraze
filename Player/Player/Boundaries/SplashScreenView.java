package Player.Boundaries;


import javax.swing.JFrame;

import Player.Entities.Model;

public class SplashScreenView extends JFrame {
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
