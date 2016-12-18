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
		stars[i -1] = s;
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


	public void writeLevel(String FileName) {
		System.out.println("Level");
	}


	/**
	 * Method produces the 6 by 6 board of 0s and Xs indicating
	 * toggled and untoggled squares.
	 * @param s the string that holds the board values.
	 * @return string of 0s Xs representing the game board.
	 */
	public String addBoard(String s) {
	Board brd = getBoard();

		for(int x = 0; x < 6; x ++)
		{
			for(int y = 0; y < 6; y++)
			{
				int location = 6*x + y;
				if(brd.getSquareAt(location).isToggle())
				{
					s = s+"O";
				}
				else
				{
					s = s+"X";
				}
			}
			s = s + "\n";
		}

		s += "-\n";

		return s;
	}



	/**
	 * Method appends the shared information of the stars
	 * and gives back the correct order and format of them to put in the file.
	 * @param s the string that holds the stars.
	 * @return the string appended to the file for stars part.
	 */
	public String addStars(String s) {
		String star1 = String.valueOf(getStarAt(1));
		System.out.println(star1);

		String star2 = String.valueOf(getStarAt(2));
		String star3 = String.valueOf(getStarAt(3));

		s = s+star1+"\n"+star2+"\n"+star3+"\n-\n";
		return s;
	}
}
