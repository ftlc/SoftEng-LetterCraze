package Player.Entities;
import java.util.Dictionary;

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
	Logic logic;
	Dictionary dictionary;

	public Level(String path) {
		this.path = path;
		this.board = new Board(new char[TOTAL_NUM_TILES][TOTAL_NUM_TILES]);
		this.score = 0;
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
}
