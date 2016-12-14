package Player.Entities;

import Player.Entities.*;
import java.util.ArrayList;

public class Move {
	Level level;
	ArrayList<Tile> tiles;
	int score;
	
	public Move(Level l, ArrayList<Tile> t, int s){
		this.level = l;
		this.tiles = t;		
		this.score = s;
	}
	
	public boolean undo(){
		boolean completed = true;
		
		Board board = level.getBoard();
		for(Tile t: tiles){
			board.setTile(t.getXCoord(), t.getYCoord(), t);
		}
		
		level.setScore(level.getScore() - score);
		
		return completed;
	}

}
