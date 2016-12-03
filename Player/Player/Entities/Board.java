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
	
	public Board(char[][] l, boolean theme){
		this.layout = l;
		tiles = new Tile[TOTAL_NUM_TILES][TOTAL_NUM_TILES];
		if(theme == true)
			initializeTilesTheme();
		else
			initializeTiles();
	}
	
	public boolean initializeTilesTheme(){
		boolean init = true;
		
		for (int x = 0; x < TOTAL_NUM_TILES; x++){
			for(int y = 0; y < TOTAL_NUM_TILES; y++){
				char c = layout[x][y];
				if(c != '"'){
					if(c == 'Q')
						tiles[x][y] = new Tile(x,y,"Qu");
					else
						tiles[x][y] = new Tile(x,y,String.valueOf(c));
				}
			}
		}
		
		return init;
	}
	
	public boolean initializeTiles(){
		boolean init = true;
		
		for(int x = 0; x < TOTAL_NUM_TILES; x++){
			for(int y = 0; y < TOTAL_NUM_TILES; y++){
				if(isValid(x,y) == true)
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
