package Player.Entities;
import Player.Entities.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Player.Entities.Board;
import Player.Entities.Star;
import Player.Entities.Word;

public class Level {
	final int TOTAL_NUM_TILES = 6;
	String path;
	Position lastSelectedPosition;
	int num;
	Board board;
	Star star;
	int score;
	int highScore;
	int maxMoves; // temp
	int timer; // temp
	String theme; //temp
	Logic logic;
	Dictionary dictionary;
	String thirdBox;
	ArrayList<Tile> currSelectedWord;
	ArrayList<Tile> lastSelectedWord;
	ArrayList<Word> selectedWords;
	boolean selectingWord;

	public Level(String path, int num) {
		this.path = path;
		this.num = num;
		this.score = 0;
		this.star = new Star(0,0,0);
		this.maxMoves = 0;
		this.timer = 0;
		this.thirdBox = "null";
		this.selectingWord = false;
		this.currSelectedWord = new ArrayList<Tile>();
		this.lastSelectedWord = new ArrayList<Tile>();
		this.selectedWords = new ArrayList<Word>();
		readLevel(path);
	}
	
	
	
	// Determine Level Type from First Line //
	//              of File                //
	public boolean readLevel(String path) {
		String currLine = null; // Buffer for line being read 
		try {
			// Open File //
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((currLine = br.readLine().trim()) != null) {
				if (currLine.equals("P")) { // Puzzle Case 
					br.close();
					return puzzleInit(path);
				} else if (currLine.equals("L")) { // Lightning Case
					br.close();
					return lightningInit(path);
				} else if (currLine.equals("T")) { // Theme Case
					br.close();
					return themeInit(path);
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean hasWord(String s) {
		return this.dictionary.hasWord(s);
	}
	
	// Initialize Entities for Puzzle Level //
	//         by reading from file        //
	public boolean puzzleInit(String path) {

		this.dictionary = new Dictionary();
		String currLine = null; // Buffer for each line 
		
		int lineCount = 0; // Keeps track of which section 
						   // of file is being read
		try {
			// Re-Open File //
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((currLine=br.readLine()) != null){
				currLine = currLine.trim(); // Remove extra spaces
				switch(lineCount){
				case 0:
					// Star Amounts //
					currLine=br.readLine(); // Skips '-'
					int starAmounts[] = new int[3]; // Stores thresholds for
													// Each star value
					for(int i = 0; i < 3; i++){
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					// Create New Star //
					this.star = new Star(starAmounts[0], starAmounts[1], starAmounts[2]);
					break;
				case 1:
					// Maximum Number of Moves //
					currLine = br.readLine().trim();
					
					// Stores Max Number of Moves //
					int maxMoves = Integer.parseInt(currLine);
					this.maxMoves = maxMoves; // temp
					
					// Sets what third box will represent //
					//        (Level-Type Specific)      //
					this.thirdBox = "Max Moves\n" + String.valueOf(maxMoves);
					
					break;
				case 2:
					// Board Layout //
					char[][] layout = new char[6][6];
					for (int i = 0; i < 6; i++){
						currLine = br.readLine();
						// Reads each line into Character Array //
						layout[i] = currLine.toCharArray();
					}
					this.board = new Board(layout); // Create new Board 
					break;
				case 3:
					// High Score //
					currLine = br.readLine().trim();
					// Reads Highest Number of Stars Previously Stored
					this.highScore = Integer.parseInt(currLine);
				}
					
				
				lineCount++;
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// Initialize Entities for Lightning Level //
	//          by reading from file          //
	public boolean lightningInit(String path) {

		this.dictionary = new Dictionary();
		String currLine = null; // Buffer for current line being read 
		
		int lineCount = 0; // Keeps track of which section 
		   				   // of file is being read
		try {
			// Re-open file //
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((currLine=br.readLine()) != null){
				currLine = currLine.trim(); // Strips extra spaces
				switch(lineCount){
				case 0:
					// Star Amounts //
					currLine=br.readLine(); // Skips '-'
					int starAmounts[] = new int[3]; // Holds thresholds for
													// star values
					for(int i = 0; i < 3; i++){
						currLine = br.readLine().trim(); 
						starAmounts[i] = Integer.parseInt(currLine);
					}
					// Create new Star //
					this.star = new Star(starAmounts[0], starAmounts[1], starAmounts[2]); 
					break;
				case 1:
					// Timer Value //
					currLine = br.readLine().trim();
					int timer = Integer.parseInt(currLine); // Timer length 
					this.timer = timer; // temp
					
					// Sets what third box will represent //
					//        (Level-Type Specific)      //
					this.thirdBox = "Timer\n"+ String.valueOf(timer);
					
					break;
				case 2:
					// Read in board layout //
					char[][] layout = new char[6][6];
					for (int i = 0; i < 6; i++){
						currLine = br.readLine();
						// Sets each row to character array //
						//            From file             // 
						layout[i] = currLine.toCharArray(); 
					}
					this.board = new Board(layout); // Create Board
					break;
				case 3:
					// High Score //
					currLine = br.readLine().trim();
					// Stores stars previously scored //
					this.highScore = Integer.parseInt(currLine); 
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
	// Initialize Entities for Theme Level //
	//        by reading from file        //
	public boolean themeInit(String path) {

		this.dictionary = new Dictionary(true);
		String currLine = null; // Buffer for current line being read
		
		int lineCount = 0; // Keeps track of which section 
		   				   // of file is being read
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((currLine=br.readLine()) != null){
				currLine = currLine.trim(); // Remove Extra Spaces //
				switch(lineCount){
				case 0:
					// Star Amounts //
					currLine=br.readLine();
					int starAmounts[] = new int[3];
					for(int i = 0; i < 3; i++){
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					this.star = new Star(starAmounts[0], starAmounts[1], starAmounts[2]);
					break;
				case 1:
					// Theme Name //
					currLine = br.readLine().trim();
					String theme = currLine;
					this.theme = theme; // temp
					
					// Sets what third box will represent //
					//        (Level-Type Specific)      //
					this.thirdBox = "Theme:\n"+ theme;
					
					break;
				case 2:
					// Read in Dictionary up to Line //
					while(!(currLine = br.readLine().trim()).equals("-")){
						dictionary.addWord(currLine);
					}
					break;
				case 3:
					char[][] board = new char[6][6];
					for (int i = 0; i < 6; i++){
						// Store each line as character array //
						board[i] = currLine.toCharArray();
						currLine = br.readLine().trim();
					}
					this.board = new Board(board, true); // Create new board
														 // with themeInitTiles()
					break;
				case 4:
					// Store Highest Star Value scored //
					this.highScore = Integer.parseInt(currLine);
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
	
	public boolean saveHighScore(int score){
		boolean scoreHighest;
		if(score > highScore){
			scoreHighest = true;
			this.highScore = score;
		}
		else{
			scoreHighest = false;
		}
		
		return scoreHighest;
	}
	public void reconstruct(){
		readLevel(path);
	}
	
	public void addWord(Word w){
		this.selectedWords.add(w);
	}
	
	public void addCurrTile(Tile t){
		this.currSelectedWord.add(t);
	}
	

	
	// Getters and Setters //
	public Board getBoard() { return board; }
	public Star getStar() { return star; }
	public int getScore() { return score; }
	public int getHighScore() { return highScore; }
	public Logic getLogic() { return logic; }
	public Dictionary getDictionary() { return dictionary; }
	public int getTimer() { return timer; }
	public String getThirdBox() { return thirdBox; }
	public ArrayList<Tile> getCurrSelectedWord() { return currSelectedWord; }
	public ArrayList<Tile> getLastSelectedWord() { return lastSelectedWord; }
	public boolean getSelectingWord() { return selectingWord; }
	public int getLevelNum() { return num; }
	public Position getLastSelectedPosition() { return lastSelectedPosition; }
	public ArrayList<Word> getSelectedWords() { return selectedWords; }
	
	public void setSelectingWord(boolean b) {
		this.selectingWord = b;
	}
	
	public void setCurrSelectedWord(ArrayList<Tile> t) {
		this.currSelectedWord = t;
	}
	
	public void setLastSelectedWord(ArrayList<Tile> t) {
		this.lastSelectedWord = t;
	}
	
	public void setLastSelectedPosition(Position p){
		this.lastSelectedPosition = p;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public void addScore(int score){
		this.score += score;
	}
}
