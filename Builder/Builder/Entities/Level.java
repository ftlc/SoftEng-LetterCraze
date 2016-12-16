package Builder.Entities;

/**
 * Entity class that holds all the shared information
 * of all 3 types of levels like star values and board.
 * @author JuanLuis
 */
public class Level {

	int stars[];
	Board board;

	/**
	 * Constructor of the level object.
	 */
	public Level() {
		initValues();
	}

	/**
	 * Constructor for the level object
 	 * @param brd
	 */
	public Level(Board brd) {
		this.stars = new int[3];
		this.board = brd;
	}
	/**
	 * initializes the board and stars.
	 */
	void initValues() {
		this.stars = new int[3];
		this.board = new Board();
	}

	/**
	 * gives back the type of level: puzzle, lightning, theme.
	 * @return a string with the type of level it is.
	 */
	public String getLevelType() {
		return "";
	}

	/**
	 * Setter method that assigns the values to the stars.
	 * @param star1 first star value.
	 * @param star2 second star value.
	 * @param star3 third star value.
	 * @return true if values assigned.
	 */
/*	boolean assignStarValues(int star1, int star2, int star3)
	{
		stars[0] = star1;
		stars[1] = star2;
		stars[2] = star3;
		return true;
	}*/

	/**
	 * Getter method of the board of the level.
	 * @return the board of the level.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Setter method of the board.
	 * @param board wished to be assigned the level.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Getter of the star values.
	 * @return the star values of the level.
	 */
	public int[] getStars() {
		return stars;
	}

	/**
	 * Setter method of the different stars.
	 * @param s the star value to be assigned.
	 * @param i index of the star wished to be changed.
	 */
	public void setStarAt(int s, int i) {
		stars[i-1] = s;
		return;
	}

	/**
	 * Getter method for an individual star.
	 * @param i index of the wished star.
	 * @return returns the wished star value.
	 */
	public int getStarAt(int i) {
		return stars[i-1];
	}
	
	/**
	 * Setter for all the stars of the level entity.
	 * @param stars wished to be assigned to the level.
	 */
	public void setStars(int[] stars) {
		this.stars = stars;
	}


}
