package Builder.Entities;

public class Level {

	int stars[];
	Board board;

	public Level() {
		initValues();
	}
	void initValues() {
		this.stars = new int[3];
		this.board = new Board();
	}

	public String getLevelType() {
		return "";
	}

	boolean assignStarValues(int star1, int star2, int star3)
	{

		stars[1] = star1;
		stars[2] = star2;
		stars[3] = star3;

		return true;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int[] getStars() {
		return stars;
	}

	public void setStarAt(int s, int i) {
		stars[i-1] = s;
	}

	public int getStarAt(int i) {
		return stars[i-1];
	}
	public void setStars(int[] stars) {
		this.stars = stars;
	}


}
