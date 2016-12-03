package Player.Boundaries;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Player.Controllers.LevelToMainMenuController;
import Player.Entities.Level;
import Player.Entities.Model;

public class LevelView extends JFrame {

	Level theLevel;
	GameView gameView;
	MainMenuView mainMenu;
	JTextArea starArea;
	JTextArea scoreArea;
	Model model;
	
	public LevelView(Level theLevel, MainMenuView mainMenu, Model m) {
		this.theLevel = theLevel;
		this.mainMenu = mainMenu;
		this.model = m;
		this.starArea = new JTextArea();
		this.scoreArea = new JTextArea();
		initFrame();
	}
	
	private void initFrame() {
		
		Color c = new Color(229,229,229,100);
		Border b = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font f = new Font("TimesRoman", Font.PLAIN, 25);
				
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(f);
		btnExit.addActionListener(new LevelToMainMenuController(this, mainMenu));
		btnExit.setBounds(470, 647, 298, 77);
		add(btnExit);
		
		JButton btnResetBoard = new JButton("Reset Board");
		btnResetBoard.setFont(f);
		btnResetBoard.setBounds(470, 359, 298, 77);
		add(btnResetBoard);
		
		JTextArea txtrSelectedWords = new JTextArea();
		txtrSelectedWords.setText("Selected Words\n");
		txtrSelectedWords.setFont(f);
		txtrSelectedWords.setBackground(c);
		txtrSelectedWords.setEditable(false);
		txtrSelectedWords.setLineWrap(true);
		txtrSelectedWords.setVisible(true);
		
		JScrollPane scroll = new JScrollPane(txtrSelectedWords);
		scroll.setBackground(c);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(12, 464, 407, 263);
		scroll.setVisible(true);
		
		add(scroll);
		
		scoreArea.setText("Score\n" + Integer.toString(theLevel.getScore()));
		scoreArea.setFont(f);
		scoreArea.setBackground(c);
		scoreArea.setBorder(b);
		scoreArea.setEditable(false);
		scoreArea.setBounds(470, 37, 298, 70);
		add(scoreArea);
		
		starArea.setFont(f);
		starArea.setBackground(c);
		starArea.setBorder(b);
		starArea.setText("Stars\n" + Integer.toString(theLevel.getStar().calculateStars()));
		starArea.setEditable(false);
		starArea.setBounds(470, 149, 298, 70);
		add(starArea);
		
		JTextArea timerArea = new JTextArea();
		timerArea.setFont(f);
		timerArea.setBackground(c);
		timerArea.setBorder(b);
		timerArea.setText(theLevel.getThirdBox());
		timerArea.setEditable(false);
		timerArea.setBounds(470, 257, 298, 70);
		add(timerArea);
		
		setTitle("Level View");
		setSize(800 , 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		gameView = new GameView(this, theLevel);
		gameView.setSize(400 , 400);
		gameView.setLocation(12 , 12);
		add(gameView);
	}
	
	public void refresh() {
		scoreArea.setText("Score\n" + Integer.toString(theLevel.getScore()));
		starArea.setText("Stars\n" + Integer.toString(theLevel.getStar().calculateStars()));
		gameView.refresh();
	}
	
	// Getters //
	public Level getLevel() { return theLevel; }
	public MainMenuView getMainMenuView() { return mainMenu; }
	public GameView getGameView() { return gameView; }
	
}
