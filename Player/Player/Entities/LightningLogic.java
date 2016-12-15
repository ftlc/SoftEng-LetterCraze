package Player.Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Player.Boundaries.LevelView;

public class LightningLogic extends Logic {

	int timer;
	Timer actualTimer;

	/**
	 * Lightning Logic Constructor - Initializes timer value
	 * @param l Level corresponding to this logic
	 */
	public LightningLogic(Level l) {
		super(l);
		this.timer = -1;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize Entities corresponding to File for Lightning Level
	 * @param path Path to config file
	 * @return boolean representing success
	 */
	@Override
	public boolean readFile(String path) {

		String currLine = null; // Buffer for current line being read

		int lineCount = 0; // Keeps track of which section
							// of file is being read
		try {
			// Re-open file //
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((currLine = br.readLine()) != null) {
				currLine = currLine.trim(); // Strips extra spaces
				switch (lineCount) {
				case 0:
					// Star Amounts //
					currLine = br.readLine(); // Skips '-'
					int starAmounts[] = new int[3]; // Holds thresholds for
													// star values
					for (int i = 0; i < 3; i++) {
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					// Create new Star //
					level.setStar(new Star(starAmounts[0], starAmounts[1], starAmounts[2]));
					break;
				case 1:
					// Timer Value //
					currLine = br.readLine().trim();
					int timer = Integer.parseInt(currLine); // Timer length
					this.timer = timer; 

					// Sets what third box will represent //
					// (Level-Type Specific) //
					this.thirdBox = "Timer\n" + String.valueOf(timer);

					break;
				case 2:
					// Read in board layout //
					char[][] layout = new char[6][6];
					for (int i = 0; i < 6; i++) {
						currLine = br.readLine();
						// Sets each row to character array //
						// From file //
						layout[i] = currLine.toCharArray();
					}
					level.setBoard(new Board(layout)); // Create Board
					break;
				case 3:
					// High Score //
					currLine = br.readLine().trim();
					// Stores stars previously scored //
					level.setHighScore(Integer.parseInt(currLine));
				}

				lineCount++; // Next section of file being read //
			}
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Lightning specific version of play word - performs general operations and ensures timer has not run out
	 * @return boolean representing whether or not word was valid to play
	 */
	@Override 
	public boolean playWord(){
		boolean returnVal = false;
		if (timer <=0 ){
			return returnVal;
		}
		returnVal = super.playWord();
		return returnVal;
	}
	
	/**
	 * Can Move Be Undone?
	 * @return false - moves cannot be undone in Lightning level
	 */
	@Override
	public boolean canUndo(){
		return false;
	}
	
	/**
	 * Start timer for level 
	 * @param levelView Level View corresponding to level
	 * @return boolean representing whether or not timer was started
	 */
	@Override
	public boolean startTimer(LevelView levelView){
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				if (timer > 0) {
					timer--;
					thirdBox = "Timer\n" + String.valueOf(timer);
					levelView.updateThirdBox();
				}
				
			}
		};
		
		actualTimer = new Timer("LightningTimer");
		actualTimer.scheduleAtFixedRate(task, 1000, 1000);
	
		return true;
	}
	
	/**
	 * Stop timer for level
	 * @return boolean representing whether or not timer was started
	 */
	@Override
	public boolean stopTimer(){
		actualTimer.cancel();		
		return true;
	}

}
