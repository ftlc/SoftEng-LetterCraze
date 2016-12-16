package Player.Entities;

import Player.Entities.*;
import java.util.ArrayList;

public class Move {
	Level level;
	Tile[][] tiles;
	int score;
	
	/**
	 * Move Constructor - Create new move for undo purposes
	 * @param l Level where move was made
	 * @param t 2D array of all board tiles at time of move
	 * @param s Score that move was worth
	 */
	public Move(Level l, Tile[][] t, int s){
		this.level = l;		
		this.score = s;
		this.tiles = new Tile[6][6];
		
		initTiles(t);
	}
	
	/**
	 * Deep Copy Tiles
	 * @param tilesToCopy 2D Array of tiles to copy
	 */
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
	
	/**
	 * Undo a move - set board letters to those saved here
	 * @return boolean representing whether or not move was successfully undone
	 */
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
