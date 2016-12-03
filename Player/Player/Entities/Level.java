package Player.Entities;
import Player.Entities.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Player.Entities.Board;
import Player.Entities.Star;
import Player.Entities.Word;

public class Level {
	final int TOTAL_NUM_TILES = 6;
	String path;
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
	String currSelectedWord;
	String lastSelectedWord;
	boolean selectingWord;

	public Level(String path) {
		this.path = path;
		this.score = 0;
		this.star = new Star(0,0,0);
		this.maxMoves = 0;
		this.timer = 0;
		this.dictionary = new Dictionary();
		this.thirdBox = "null";
		this.selectingWord = false;
		this.currSelectedWord = "";
		this.lastSelectedWord = "";
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
	
	// Initialize Entities for Puzzle Level //
	//         by reading from file        //
	public boolean puzzleInit(String path) {
		
		String currLine = null; // Buffer for each line 
		
		int lineCount = 0; // Keeps track of which section 
						   // of file is being read
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((currLine=br.readLine()) != null){
				currLine = currLine.trim();
				switch(lineCount){
				case 0:
					currLine=br.readLine();
					int starAmounts[] = new int[3];
					for(int i = 0; i < 3; i++){
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					this.star = new Star(starAmounts[0], starAmounts[1], starAmounts[2]);
					break;
				case 1:
					currLine = br.readLine().trim();
					int maxMoves = Integer.parseInt(currLine);
					this.maxMoves = maxMoves; // temp
					this.thirdBox = "Max Moves\n" + String.valueOf(maxMoves);
					break;
				case 2:
					char[][] layout = new char[6][6];
					for (int i = 0; i < 6; i++){
						currLine = br.readLine();
						layout[i] = currLine.toCharArray();
					}
					this.board = new Board(layout);
					break;
				case 3:
					currLine = br.readLine().trim();
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
	
	// Initialize Entities for Lightning Level //
	//          by reading from file          //
	public boolean lightningInit(String path) {
		
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
					currLine = br.readLine().trim();
					int timer = Integer.parseInt(currLine); // Timer length 
					this.timer = timer; // temp
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
		
		String currLine = null; // Buffer for current line being read
		
		int lineCount = 0; // Keeps track of which section 
		   				   // of file is being read
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((currLine=br.readLine()) != null){
				currLine = currLine.trim();
				switch(lineCount){
				case 0:
					currLine=br.readLine();
					int starAmounts[] = new int[3];
					for(int i = 0; i < 3; i++){
						currLine = br.readLine().trim();
						starAmounts[i] = Integer.parseInt(currLine);
					}
					this.star = new Star(starAmounts[0], starAmounts[1], starAmounts[2]);
					break;
				case 1:
					currLine = br.readLine().trim();
					String theme = currLine;
					this.theme = theme; // temp
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
						board[i] = currLine.toCharArray();
						currLine = br.readLine().trim();
					}
					this.board = new Board(board, true);
					break;
				case 4:
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
	public boolean initialize(){
		return false;
	}
	public boolean initializeView(){
		return false;
	}
	public boolean initializeControllers(){
		return false;
	}
	public void reconstruct(){
		return;
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
	public String getCurrSelectedWord() { return currSelectedWord; }
	public String getLastSelectedWord() { return lastSelectedWord; }
	public boolean getSelectingWord() { return selectingWord; }
	
	public void setSelectingWord(boolean b) {
		this.selectingWord = b;
	}
	
	public void setCurrSelectedWord(String s) {
		this.currSelectedWord = s;
	}
	
	public void setLastSelectedWord(String s) {
		this.lastSelectedWord = s;
	}
}
