package Boundaries;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Entities.Level;

public class LevelView extends JFrame {

	Level theLevel;
	GameView theView;
	
	public LevelView(Level theLevel) {
		this.theLevel = theLevel;
		initFrame();
	}
	
	private void initFrame() {
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(470, 647, 298, 77);
		add(btnExit);
		
		JButton btnResetBoard = new JButton("Reset Board");
		btnResetBoard.setBounds(470, 359, 298, 77);
		add(btnResetBoard);
		
		JTextArea txtrSelectedWords = new JTextArea();
		txtrSelectedWords.setText("Selected Words\n");
		txtrSelectedWords.setEditable(false);
		txtrSelectedWords.setLineWrap(true);
		txtrSelectedWords.setVisible(true);
		
		JScrollPane scroll = new JScrollPane(txtrSelectedWords);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(12, 464, 407, 263);
		scroll.setVisible(true);
		
		add(scroll);
		
		JTextArea scoreArea = new JTextArea();
		scoreArea.setText("Score: \n\n 0");
		scoreArea.setEditable(false);
		scoreArea.setBounds(470, 37, 298, 70);
		add(scoreArea);
		
		JTextArea starArea = new JTextArea();
		starArea.setText("Stars: \n\n 0");
		starArea.setEditable(false);
		starArea.setBounds(470, 149, 298, 70);
		add(starArea);
		
		JTextArea timerArea = new JTextArea();
		timerArea.setText("(TIMER)");
		timerArea.setEditable(false);
		timerArea.setBounds(470, 257, 298, 70);
		add(timerArea);
		
		setTitle("Level View");
		setSize(800 , 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		theView = new GameView();
		theView.setSize(400 , 400);
		theView.setLocation(12 , 12);
		add(theView);
	}
	
	public void refresh() {
		theView.refresh();
	}
	
	public Level getLevel() {
		return theLevel;
	}
}
