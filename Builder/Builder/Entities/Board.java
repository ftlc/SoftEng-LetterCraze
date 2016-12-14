package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 * Board class holds an array of Squares and gets initialized with all of them as false.
 */
public class Board {
	Square[] squares;

	/**
	 * Constructor that builds the board with all 36 squares.
	 */
	public Board()
	{
		this.squares = new Square[36];
		initializeSquares();
	}

	/**
	 * Method that initializes and saves the squares with the value of false,
	 * they have not been pressed yet.
	 */
	void initializeSquares()
	{
		for(int i = 0; i < 36; i++)
		{
			squares[i] = new Square(false);
		}
	}

	/**
	 * Getter method that returns the array of squares so that other classes
	 * in other packages can manipulate it.
	 * @return the array of squares.
	 */
	public Square[] getSquares() {
		return squares;
	}
	
	/**
	 * Finds and returns a specific square at certain location.
	 * @param i the location of the desired square.
	 * @return the desired square from the array.
	 */
	public Square getSquareAt(int i)
	{
		return squares[i];
	}
}
