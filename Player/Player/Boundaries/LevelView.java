package Player.Boundaries;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import Player.Controllers.LevelToMainMenuController;
import Player.Controllers.ResetBoardController;
import Player.Controllers.UndoController;
import Player.Entities.Level;
import Player.Entities.Model;
import Player.Entities.Word;

public class LevelView extends JFrame {

	Level theLevel;
	GameView gameView;
	MainMenuView mainMenu;
	JTextArea starArea;
	JTextArea scoreArea;
	JTextArea timerArea;
	JTextArea txtrSelectedWords;
	JButton btnExit;
	JButton btnResetBoard;
	JButton btnUndo;
	Model model;
	
	/**
	 * LevelView constructor
	 * @param theLevel which level to display
	 * @param mainMenu parent mainMenuView to return to on exit
	 * @param m model that is being represented
	 */
	public LevelView(Level theLevel, MainMenuView mainMenu, Model m) {
		this.theLevel = theLevel;
		this.mainMenu = mainMenu;
		this.model = m;
		this.starArea = new JTextArea();
		this.scoreArea = new JTextArea();
		this.timerArea = new JTextArea();
		initFrame();
	}
	
	/**
	 * Initialize the frame by adding all of the elements to it.
	 */
	private void initFrame() {
		
		Color c = new Color(229,229,229,100);
		Border b = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font f = new Font("TimesRoman", Font.PLAIN, 25);
				
		btnExit = new JButton("EXIT"); // Index 0
		btnExit.setFont(f);
		btnExit.addActionListener(new LevelToMainMenuController(this, mainMenu));
		btnExit.setBounds(470, 647, 298, 77);
		add(btnExit);
		
		btnResetBoard = new JButton("Reset Board"); // Index 1
		btnResetBoard.addActionListener(new ResetBoardController(theLevel, this));
		btnResetBoard.setFont(f);
		btnResetBoard.setBounds(470, 359, 298, 77);
		add(btnResetBoard);
		
		btnUndo = new JButton("Undo Move"); // Index 2
		btnUndo.addActionListener(new UndoController(this, theLevel));
		btnUndo.setFont(f);
		btnUndo.setBounds(470, 459, 298, 77);
		add(btnUndo);
		
		txtrSelectedWords = new JTextArea();
		txtrSelectedWords.setText("Selected Words\n");
		txtrSelectedWords.setFont(f);
		txtrSelectedWords.setOpaque(false);
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
		scoreArea.setOpaque(false);
		scoreArea.setBackground(c);
		scoreArea.setBorder(b);
		scoreArea.setEditable(false);
		scoreArea.setBounds(470, 37, 298, 70);
		add(scoreArea);
		
		starArea.setFont(f);
		starArea.setOpaque(false);
		starArea.setBackground(c);
		starArea.setBorder(b);
		starArea.setText("Stars\n" + Integer.toString(theLevel.getStar().calculateStars(theLevel.getScore())));
		starArea.setEditable(false);
		starArea.setBounds(470, 149, 298, 70);
		add(starArea);
		
		timerArea.setFont(f);
		timerArea.setOpaque(false);
		timerArea.setBackground(c);
		timerArea.setBorder(b);
		timerArea.setText(theLevel.getThirdBox());
		timerArea.setEditable(false);
		timerArea.setBounds(470, 257, 298, 70);
		add(timerArea);
		
		setTitle("LetterCraze");
		setSize(800 , 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		this.gameView = new GameView(this, theLevel);
		gameView.setSize(400 , 400);
		gameView.setOpaque(true);
		gameView.setLocation(12 , 12);
		add(gameView);
	}
	
	/**
	 * Updates the text within the timer box
	 */
	public void updateThirdBox(){
		timerArea.setText(theLevel.getThirdBox());
	}
	
	/**
	 * refreshes the levelview by clearing all of the fields
	 */
	public void refresh() {
		scoreArea.setText(null);
		starArea.setText(null);
		timerArea.setText(null);
		scoreArea.setText("Score\n" + Integer.toString(theLevel.getScore()));
		starArea.setText("Stars\n" + Integer.toString(theLevel.getStar().calculateStars(theLevel.getScore())));
		timerArea.setText(theLevel.getThirdBox());
		gameView.refresh();
	}
	
	/**
	 * Clears the selected words view
	 */
	public void clearSelectedWords(){
		txtrSelectedWords.setText("Selected Words\n");
	}
	
	/**
	 * Removes the most recently selected word from the list of selected words
	 */
	public void removeLastSelectedWord(){
		String text = txtrSelectedWords.getText();
		try {
			String noLineBreak = txtrSelectedWords.getText(0, text.length()-1);
			int lastLineBreak = noLineBreak.lastIndexOf("\n");
			txtrSelectedWords.setText(txtrSelectedWords.getText(0, lastLineBreak+1));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Clears the level and destroys the JFrame
	 */
	public void clearLevel() {
		this.dispose();
		gameView.setVisible(false);
		gameView.validate();
	}
	
	/**
	 * Adds a word to the selected words view
	 * @param w
	 */
	public void updateSelectedWords(Word w){
		txtrSelectedWords.append(w.toString());
	}
	
	/**
	 * Rebuilds the entire frame.
	 */
	public void reconstruct(){
		this.removeAll();
		initFrame();
	}
	
	/**
	 * gets the Level object
	 * @return
	 */
	public Level getLevel() { return theLevel; }
	
	/**
	 * Gets the parent MainMenuView object
	 * @return
	 */
	public MainMenuView getMainMenuView() { return mainMenu; }
	
	/**
	 * Gets the child GameView object
	 * @return
	 */
	public GameView getGameView() { return this.gameView; }
	
	/**
	 * Gets the JTextArea that holds the Star data
	 * @return
	 */
	public JTextArea getStarArea(){ return this.starArea; }
	
	/**
	 * Gets the JTextArea that holds the Score data
	 * @return
	 */
	public JTextArea getScoreArea() { return this.scoreArea; }
	
	/**
	 * Gets the JTextArea that holds the Timer data
	 * @return
	 */
	public JTextArea getTimerArea() { return this.timerArea; }
	
	/**
	 * Gets the JTextArea that holds the Selected Words data
	 * @return
	 */
	public JTextArea txtrSelectedWords() { return this.txtrSelectedWords; }
	
	/**
	 * Gets the JButton that is used to exit the level
	 * @return
	 */
	public JButton getBtnExit(){ return this.btnExit; }
	
	/**
	 * Gets the JButton that is used to reset the level
	 * @return
	 */
	public JButton getBtnResetBoard(){ return this.btnResetBoard; }
	
	/**
	 * Gets the Jbutton that is used to undo the last move
	 * @return
	 */
	public JButton getBtnUndo(){ return this.btnUndo; }
	
}
