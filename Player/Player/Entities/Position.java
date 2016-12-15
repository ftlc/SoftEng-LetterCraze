package Player.Entities;

public class Position {
	
	int x;
	int y;
	
	/** 
	 * Position constructor - create new Position object
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Get X Coordinate of this position
	 * @return Integer representing X Coordinate
	 */
	public int getX() { return x; }
	/**
	 * Get Y Coordinate of this position
	 * @return Integer representing Y Coordinate
	 */
	public int getY() { return y; }
}
