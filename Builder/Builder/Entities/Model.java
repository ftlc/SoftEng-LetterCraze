package Builder.Entities;

/**
 * Model class holds and initializes the different types of levels.
 * @author JuanLuis.
 */
public class Model {

	Level level;
	private String lvltype;

	/**
	 * Constructor of the Model object.
	 * @param level the type of level being created.
	 */
	public Model(Level level)
	{
		this.level = level;
	}

	/**
	 * Additional constructor that begins with the default puzzle type.
	 */
	public Model() {
		setLevelType("Puzzle");
	}

	/** 
	 * Setter method for the level attribute of the model.
	 * @param lvl the level to wished set.
	 */
	public void initLevel(Level lvl) {
		this.level = lvl;
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
		if(type.equals("Puzzle")) {
			this.level = new PuzzleLevel();
			lvltype = "Puzzle";
		}

		if(type.equals("Theme")) {
			lvltype = "Theme";
			this.level = new ThemeLevel();
		}
		if(type.equals("Lightning")) {
			lvltype = "Lightning";
			this.level = new LightningLevel();
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
