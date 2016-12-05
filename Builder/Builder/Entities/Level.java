package Builder.Entities;

public class Level {

	int stars[];
	Board board;
	int maxWords;
	int time;
	String themeName;
	Dictionary dictionary;

	public Level() {
		initValues();
	}
	void initValues() {
		this.stars = new int[3];
		this.board = new Board();
		this.maxWords = -1;
		this.time = -1;
		this.themeName = "";
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

	public void setStars(int[] stars) {
		this.stars = stars;
	}


	public int getMaxWords() {
		return maxWords;
	}

	public int getTime() {
		return time;
	}

	public String getThemeName() {
		return themeName;
	}


	public void setMaxWords(int maxWords) {
		this.maxWords = maxWords;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public void setTime(int time) {
		this.time = time;
	}


}
