package Player.Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PuzzleLogic extends Logic {

	int maxMoves;
	public PuzzleLogic(Level l) {
		super(l);
		this.maxMoves = -1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean playWord(){
		boolean returnVal = super.playWord();
		if(returnVal == true){
			maxMoves--;
			this.thirdBox = "Max Moves\n" + String.valueOf(maxMoves);
		}
		
		return returnVal;
	}
	@Override
	protected int scoreToAdd(Word theWord) {
		return theWord.getWordScore();
	}

	// Initialize Entities for Puzzle Level //
	// by reading from file //
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

					// Sets what third box will represent //
					// (Level-Type Specific) //
					this.thirdBox = "Max Moves\n" + String.valueOf(maxMoves);

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

}
