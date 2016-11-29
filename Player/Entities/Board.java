package Entities;
import Entities.Tile;

public class Board{
	//list of tiles
	Tile tiles[] = new tiles[*];
	//list of characters
	char layout[] = new layout[*];
	
	public Board(Tile t, char l){
		this.tiles = t;
		this.layout = l;
	}
	public boolean isValid(int xCoord, int yCoord){
		if(xCoord == t.xCoord & yCoord == t.yCoord){
			valid = true
		}
		else{
			valid = false;
		}
		return valid;
	}
}
