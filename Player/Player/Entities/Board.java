package Player.Entities;
import Player.Entities.Tile;

/**
 * Board contains the 2D array of tiles that make up the GameView.
 * @author bwbonanno
 *
 */

public class Board{
	final int TOTAL_NUM_TILES = 6;
	//list of tiles
	Tile tiles[][];
	//list of characters
	char layout[][];
	
	/**
	 * Constructor for the board class that assumes the board is not a theme level.
	 * 
	 * @param l Character array representing valid layout of board
	 */
	public Board(char[][] l){
		this.layout = l;
		tiles = new Tile[TOTAL_NUM_TILES][TOTAL_NUM_TILES];
		
		initializeTiles();
	}
	
	
	/**
	 * Constructor for the board class where you can specify if this is a theme board.
	 * 
	 * If it's not a theme board we will use the default dictionary.
	 * 
	 * @param l 2D Character Array representing layout of places where tiles can be placed
	 * @param theme Theme for current level
	 */
	public Board(char[][] l, boolean theme){
		this.layout = l;
		tiles = new Tile[TOTAL_NUM_TILES][TOTAL_NUM_TILES];
		if(theme == true)
			initializeTilesTheme();
		else
			initializeTiles();
	}
	
	
	/**
	 * Returns position that a tile should move up to.
	 * returns the original position if there is no where to move up to.
	 * 
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return Position that the tile should move up to
	 */
	public Position canMoveUp(int x, int y) {

		for(int yCounter = 0; yCounter < y ; yCounter++) {
			if(tiles[x][yCounter] == null) {
				
			}  else if(tiles[x][yCounter].getLetter().isEmpty()) {
				return new Position(x , yCounter);
			}
		}
		
		return new Position(x , y);
	}
	
	/**
	 * Instead of randomly generating tiles, we fill the grid
	 * with pre-determined tiles specified by the theme file.
	 * 
	 * @return true on success
	 * @return false on failure
	 */
	public boolean initializeTilesTheme(){
		boolean init = true;
		
		for (int x = 0; x < TOTAL_NUM_TILES; x++){
			for(int y = 0; y < TOTAL_NUM_TILES; y++){
				char c = layout[y][x];
				if(c != '"'){
					c = Character.toLowerCase(c);
					if(c == 'q')
						tiles[x][y] = new Tile(x,y,"qu");
					else if (c == '%')
						tiles[x][y] = new Tile(x,y);
					else
						tiles[x][y] = new Tile(x,y,Character.toString(c));
				}
			}
		}
		
		return init;
	}
	
	/**
	 * Randomly generates letters for the tiles with proper weighting.
	 * 
	 * @return true on success
	 * @return false on failure
	 */
	public boolean initializeTiles(){
		boolean init = true;
		
		for(int x = 0; x < TOTAL_NUM_TILES; x++){
			for(int y = 0; y < TOTAL_NUM_TILES; y++){
				if(isValid(y,x) == true)
					tiles[x][y] = new Tile(x,y);
			}
		}
		
		return init;
	}

	/**
	 * Determines if the board is valid.
	 * @param xCoord X Coordinate
	 * @param yCoord Y Coordinate
	 * @return boolean representing whether or not tile can be placed in location
	 */
	public boolean isValid(int xCoord, int yCoord){
		return layout[xCoord][yCoord] == 'O';
	}
	
	/**
	 * Get 2D tile Array
	 * @return the 2 dimensional tile array.
	 */
	public Tile[][] getTiles(){ return tiles; }
	
	/**
	 * Gets Board Layout
	 * @return the 2 dimensional character array used to generate the tile array.
	 */
	public char[][] getLayout() { return layout; }
	
	/**
	 * Set the tile at the given X,Y location 
	 * @param x X location
	 * @param y Y location
	 * @param t Tile
	 */
	public void setTile(int x, int y, Tile t){
		tiles[x][y] = t;
	}
	
	
}
