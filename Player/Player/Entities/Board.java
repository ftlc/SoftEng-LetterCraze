package Player.Entities;
import Player.Entities.Tile;

public class Board{
	final int TOTAL_NUM_TILES = 6;
	//list of tiles
	Tile tiles[][];
	//list of characters
	char layout[][];
	
	public Board(char[][] l){
		this.layout = l;
		tiles = new Tile[TOTAL_NUM_TILES][TOTAL_NUM_TILES];
		
		initializeTiles();
	}
	
	public boolean initializeTiles(){
		boolean init = true;
		
		for(int x = 0; x < TOTAL_NUM_TILES; x++){
			for(int y = 0; y < TOTAL_NUM_TILES; y++){
				tiles[x][y] = new Tile(x,y);
			}
		}
		
		return init;
	}
	// Assumes X is .brd marking for tile existing //
	public boolean isValid(int xCoord, int yCoord){
		return layout[xCoord][yCoord] == 'O';
	}
	
	// Getters //
	public Tile[][] getTiles(){ return tiles; }
	public char[][] getLayout() { return layout; }
	
}
