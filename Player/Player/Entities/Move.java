package Player.Entities;

import Player.Entities.*;
import java.util.ArrayList;

public class Move {
	Level level;
	Tile[][] tiles;
	int score;
	
	public Move(Level l, Tile[][] t, int s){
		this.level = l;		
		this.score = s;
		this.tiles = new Tile[6][6];
		
		initTiles(t);
	}
	
	public void initTiles(Tile[][]tilesToCopy){
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if(tilesToCopy[x][y] != null){
					Tile newTile = new Tile(x, y, tilesToCopy[x][y].getLetter());
					tiles[x][y] = newTile;
				}
			}
		}
	}
	
	public boolean undo(){
		boolean completed = true;
		Board b = level.getBoard();
		Tile[][] t = b.getTiles();
		
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if(t[x][y] != null)
					t[x][y].setLetter(tiles[x][y].getLetter());
			}
		}
		
		level.setScore(level.getScore() - score);
		
		return completed;
	}

}
