package Player.Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PuzzleLogic extends Logic {

	int maxMoves;
	int movesRem;
	
	/**
	 * Puzzle Logic Constructor which initializes puzzle specific fields
	 * @param l Level corresponding to this logic 
	 */
	public PuzzleLogic(Level l) {
		super(l);
		this.maxMoves = -1;
		this.movesRem = -1;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Puzzle specific version of play word - performs general operations and also adjusts remaining moves
	 * @return boolean representing whether or not word was valid to play
	 */
	@Override
	public boolean playWord(){
		boolean returnVal = false;
		if(movesRem <= 0)
			return returnVal;
		returnVal= super.playWord();
		if(returnVal == true){
			movesRem--;
			this.thirdBox = "Moves Remaining\n" + String.valueOf(movesRem);
		}
		
		return returnVal;
	}
	
	/**
	 * Score to be added every time a move is made 
	 * @param theWord Word that has been played 
	 * @return Integer representing score to be added
	 */
	@Override
	public int scoreToAdd(Word theWord) {
		return theWord.getWordScore();
	}
	/**
	 * Generate new letters for all tiles on board and reset max moves
	 * @return boolean representing success
	 */
	@Override
	public boolean resetBoard(){
		boolean returnVal = super.resetBoard();
		movesRem = maxMoves;
		this.thirdBox = "Moves Remaining\n" + String.valueOf(movesRem);
		
		return returnVal;
	}


	/**
	 * Initialize Entities corresponding to File for Puzzle Level
	 * @param path Path to config file
	 * @return boolean representing success
	 */
	@Override
	public boolean readFile(String path) {

		String currLine = null; // Buffer for each line

		int lineCount = 0; // Keeps track of which section
							// of file is being read
		try {
			// Re-Open File //
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((currLine = br.readLine()) != null) {
				currLine = currLine.trim(); // Remove extra spaces
				switch (lineCount) {
				case 0:
					// Star Amounts //
					currLine = br.readLine(); // Skips '-'
					int starAmounts[] = new int[3]; // Stores thresholds for
													// Each star value
					for (int i = 0; i < 3; i++) {
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					// Create New Star //
					level.setStar(new Star(starAmounts[0], starAmounts[1], starAmounts[2]));
					break;
				case 1:
					// Maximum Number of Moves //
					currLine = br.readLine().trim();

					// Stores Max Number of Moves //
					maxMoves = Integer.parseInt(currLine);
					movesRem = maxMoves;

					// Sets what third box will represent //
					// (Level-Type Specific) //
					this.thirdBox = "Moves Remaining\n" + String.valueOf(movesRem);

					break;
				case 2:
					// Board Layout //
					char[][] layout = new char[6][6];
					for (int i = 0; i < 6; i++) {
						currLine = br.readLine();
						// Reads each line into Character Array //
						layout[i] = currLine.toCharArray();
					}
					level.setBoard(new Board(layout)); // Create new Board
					break;
				case 3:
					// High Score //
					currLine = br.readLine().trim();
					// Reads Highest Number of Stars Previously Stored
					level.setHighScore(Integer.parseInt(currLine));
				}

				lineCount++;
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Can move be undone? Readjusts moves remaining when move has been undone
	 * @return boolean representing whether or not moves can be undone in this level (True for puzzle)
	 */
	@Override
	public boolean undoMove(){
		movesRem++;
		this.thirdBox = "Moves Remaining\n" + String.valueOf(movesRem);
		return true;
	}
	/**
	 * Set Max Moves
	 * @param x Integer to set Max Moves to
	 */
	public void setMaxMoves(int x){
		this.maxMoves = x;
	}
	/**
	 * Set Moves Remaining
	 * @param x Integer to set Moves Remaining to
	 */
	public void setMovesRemaining(int x){
		this.movesRem = x;
		this.thirdBox = "Moves Remaining\n" + String.valueOf(movesRem);
	}

}
