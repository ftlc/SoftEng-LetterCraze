package Boundaries;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Entities.Level;

public class LevelView extends JFrame {

	Level theLevel;
	GameView theView;
	
	public LevelView(Level theLevel) {
		this.theLevel = theLevel;
		initFrame();
	}
	
	private void initFrame() {
		/*
		 * NOTE: The frame does not make itself visible.
		 * 		this is the job of the MainMenuToLevelController.
		 */
		
		setTitle("Level View");
		setSize(800 , 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		theView = new GameView();
		theView.setSize(400 , 400);
		theView.setLocation(50 , 50);
		add(theView);
	}
	
	public void refresh() {
		theView.refresh();
	}
	
	public Level getLevel() {
		return theLevel;
	}
}
