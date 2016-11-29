package Entities;
import Entities.Star;
import Entities.Word;
import Entities.Board;

public class Level {
	String path;
	Board board;
	Star star;
	int highscore;
	Logic logic;
	Dictionary dictionary;

	public Level(String path) {
		this.path = path;
	}
	
	public boolean saveHighScore(int score){
		boolean scoreHighest;
		if(score > highscore){
			scoreHighest = true;
			this.highscore = score;
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
}
