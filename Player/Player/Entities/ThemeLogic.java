package Player.Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThemeLogic extends Logic {
	String theme;

	/**
	 * Constructor for Theme Logic - initializes theme 
	 * @param l Level corresponding to this logic
	 */
	public ThemeLogic(Level l) {
		super(l);
		this.theme = "Not initialized";
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize Entities corresponding to File for Theme Level
	 * @param path Path to config file
	 * @return boolean representing success
	 */
	@Override
	public boolean readFile(String path) {

		String currLine = null; // Buffer for current line being read

		int lineCount = 0; // Keeps track of which section
							// of file is being read
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((currLine = br.readLine()) != null) {
				currLine = currLine.trim(); // Remove Extra Spaces //
				switch (lineCount) {
				case 0:
					// Star Amounts //
					currLine = br.readLine();
					int starAmounts[] = new int[3];
					for (int i = 0; i < 3; i++) {
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					level.setStar(new Star(starAmounts[0], starAmounts[1], starAmounts[2]));
					break;
				case 1:
					// Theme Name //
					currLine = br.readLine().trim();
					String theme = currLine;
					this.theme = theme; // temp

					// Sets what third box will represent //
					// (Level-Type Specific) //
					this.thirdBox = "Theme:\n" + theme;

					break;
				case 2:
					Dictionary dictionary = new Dictionary(true);
					// Read in Dictionary up to Line //
					while (!(currLine = br.readLine().trim()).equals("-")) {
						dictionary.addWord(currLine);
					}
					level.setDictionary(dictionary);
					break;
				case 3:
					char[][] board = new char[6][6];
					for (int i = 0; i < 6; i++) {
						// Store each line as character array //
						board[i] = currLine.toCharArray();
						currLine = br.readLine().trim();
					}
					level.setBoard(new Board(board, true)); // Create new board
															// with
															// themeInitTiles()
					break;
				case 4:
					// Store Highest Star Value scored //
					level.setHighScore(Integer.parseInt(currLine));
				}

				lineCount++;
			}
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Reconstruct level from file (because theme levels are need specific letters from file)
	 * @return boolean representing success
	 */
	@Override
	public boolean resetBoard(){
		level.setScore(0);
		level.reconstruct();
		
		return true;
	}
	/**
	 * Override regenLetters because letters cannot be regenerated in Theme Level
	 * @return false - letters cannot be regenerated
	 */
	@Override
	public boolean regenLetters(){
		return false;
	}
	/**
	 * Set Theme to Name
	 * @param name String to set Theme to
	 */
	public void setThemeName(String name){
		this.theme = name;
		this.thirdBox = "Theme\n" + name;
	}

}
