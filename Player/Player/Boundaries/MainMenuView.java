package Player.Boundaries;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Player.Controllers.MainMenuToLevelController;
import Player.Entities.Level;
import Player.Entities.Model;

public class MainMenuView extends JFrame {
	
	final int TOTAL_NUM_LEVELS = 15; // 15 levels in final build //
	
	JPanel[] levelButtons;
	Level[] levels;
	LevelView[] levelViews;
	Model model;
	
	
	public MainMenuView(Model m) {
		model = m;
		levelButtons = new JPanel[TOTAL_NUM_LEVELS];
		levels = model.getLevels();
		levelViews = new LevelView[TOTAL_NUM_LEVELS];
		
		initViews();
		initFrame();
	}
	
	// Create LevelViews for each Level //
	private void initViews(){
		for(int i = 0; i < TOTAL_NUM_LEVELS; i++){
			levelViews[i] = new LevelView(levels[i], this, model);
		}
	}
	
	// Create Builder.Main Menu Frame with Level Buttons //
	private void initFrame() {
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i = 0; i < TOTAL_NUM_LEVELS; i++){
			// Level that LevelView Corresponds To //
			Level theLevel = model.getLevels()[i];
			
			// JButton //
			JButton theButton = new JButton("Level "+Integer.toString((i+1)));
			theButton.addActionListener(new MainMenuToLevelController(this, levelViews[i]));
			
			// High Score Label //
			JLabel highScore = new JLabel("Stars: " + Integer.toString(theLevel.getHighScore()), SwingConstants.CENTER);
			
			// Place Button and Label on JPanel //
			levelButtons[i] = new JPanel(new BorderLayout());
			levelButtons[i].add(theButton, BorderLayout.CENTER);
			levelButtons[i].add(highScore, BorderLayout.SOUTH);
			
			if(i >= 3){
				highScore.setText("Locked");
				theButton.setEnabled(false);
			}
		}
		
		
		// ***** FORMATTING GENERATED BY WINDOW BUILDER ***** //
		// **********      PlEASE DO NOT TOUCH     **********//
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelButtons[0], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(levelButtons[1], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(levelButtons[2], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(levelButtons[3], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(levelButtons[4], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelButtons[5], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[6], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[7], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[8], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[9], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelButtons[10], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[11], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[12], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[13], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(levelButtons[14], GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addGap(60))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(levelButtons[3], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addComponent(levelButtons[4], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addComponent(levelButtons[2], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[1], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[0], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(levelButtons[5], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[6], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[7], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[8], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[9], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(104)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(levelButtons[10], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[11], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[12], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[13], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelButtons[14], GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setTitle("LetterCraze");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void reinitLevel(int num){
		levelViews[num] = new LevelView(levels[num], this, model);
		JButton theButton = (JButton)levelButtons[num].getComponent(0);
		theButton.removeActionListener(theButton.getActionListeners()[0]);
		theButton.addActionListener(new MainMenuToLevelController(this, levelViews[num]));
	}
	
	// Getters //
	public LevelView[] getLevelView() { return levelViews; }
	public Level[] getLevels() { return levels; }
	
}
