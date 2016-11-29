package Boundaries;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controllers.MainMenuToLevelController;
import Entities.Level;

public class MainMenuView extends JFrame {
	
	final int TOTAL_NUM_LEVELS = 15;
	
	JButton[] levelButtons;
	Level[] levels;
	LevelView[] levelViews;
	
	
	public MainMenuView() {
		//Define layout here, just adding the 1 button for now
		levelButtons = new JButton[TOTAL_NUM_LEVELS];
		levels = new Level[TOTAL_NUM_LEVELS];
		levelViews = new LevelView[TOTAL_NUM_LEVELS];
		
		//There will need to be additional code here to properly instantiate the levels
		//from the files and store all the data in the objects.
		/*
		 * 
		 * FOR NOW THERE IS TEMPORARY CODE TO DEFINE LEVEL 1 SO THAT THE VIEWS CAN DRAW
		 * 
		 */
		levels[0] = new Level();
		levelViews[0] = new LevelView(levels[0]);
		
		levelButtons[0] = new JButton("Level 1");
		levelButtons[0].addActionListener(new MainMenuToLevelController(this , levelViews[0]));
		levelButtons[0].setSize(100 , 100);
		levelButtons[0].setLocation(350 , 350);
		
		
		
		initFrame();
	}
	
	
	
	private void initFrame() {
		setTitle("Main Menu");
		setSize(800 , 800);
		setLayout(null);
		setLocationRelativeTo(null);
		add(levelButtons[0]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
