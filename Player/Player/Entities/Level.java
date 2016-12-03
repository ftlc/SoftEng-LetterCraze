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

	public Level(String path) {
		this.path = path;
		this.score = 0;
		this.star = new Star(0,0,0);
		this.maxMoves = 0;
		this.timer = 0;
		this.dictionary = new Dictionary();
		
		readLevel(path);
	}
	
	public boolean readLevel(String path) {
		String currLine = null;
		try {
			// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((currLine = br.readLine().trim()) != null) {
				System.out.println(currLine);
				if (currLine.equals("P")) {
					System.out.println("PUZZLE INIT");
					br.close();
					return puzzleInit(path);
				} else if (currLine.equals("L")) {
					return lightningInit(path);
				} else if (currLine.equals("T")) {
					return themeInit(path);
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean puzzleInit(String path) {
		String currLine = null;
		int lineCount = 0;
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
					this.maxMoves = Integer.parseInt(currLine);
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
	public boolean lightningInit(String path) {
		String currLine = null;
		int lineCount = 0;
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
					this.timer = Integer.parseInt(currLine);
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
	public boolean themeInit(String path) {
		String currLine = null;
		int lineCount = 0;
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
					this.theme = currLine;
					break;
				case 2:
					// Read in Dictionary up to Line //
					while(!(currLine = br.readLine().trim()).equals("-")){
						dictionary.addWord(currLine);
						System.out.println(currLine);
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
}
