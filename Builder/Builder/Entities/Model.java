package Builder.Entities;

/**
 * Model class holds and initializes the different types of levels.
 * @author JuanLuis.
 */
public class Model {

	Level level;
	private String lvltype;



	/**
	 * Additional constructor that begins with the default puzzle type.
	 */
	public Model() {
		level = new Level();
		setLevelType("Puzzle");


	}



	/**
	 * Getter method for the level attribute in the model.
	 * @return the level inside the model.
	 */
	public Level getLevel() {
		return level;
	}


	/**
	 * Setter method that assigns the type of level based on input.
	 * @param type of level that is being created and assigned to the model.
	 */
	public void setLevelType(String type) {
		Board brd = this.level.getBoard();
		if(type.equals("Puzzle")) {
			this.level = new PuzzleLevel(brd);
			lvltype = "Puzzle";
		}

		if(type.equals("Theme")) {
			lvltype = "Theme";
			this.level = new ThemeLevel(brd);
		}
		if(type.equals("Lightning")) {
			lvltype = "Lightning";
			this.level = new LightningLevel(brd);
		}
	}

	/**
	 * Getter method for the type of level attribute.
	 * @return the type of level String.
	 */
	public String getLvltype() {
		return lvltype;
	}
}
