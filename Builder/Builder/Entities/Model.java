package Builder.Entities;

public class Model {

	Level level;
	private String lvltype;

	public Model(Level level)
	{
		this.level = level;
	}

	public Model() {
		setLevelType("Puzzle");
	}

	public void initLevel(Level lvl) {
		this.level = lvl;
	}

	public Level getLevel() {
		return level;
	}


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

	public String getLvltype() {
		return lvltype;
	}
}
