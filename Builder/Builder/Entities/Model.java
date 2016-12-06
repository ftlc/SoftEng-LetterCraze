package Builder.Entities;

public class Model {

	Level level;

	public Model(Level level)
	{
		this.level = level;
	}

	public Model() {
		this.level = new PuzzleLevel();
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
		}

		if(type.equals("Theme")) {
			this.level = new ThemeLevel();
		}
		if(type.equals("Lightning")) {
			this.level = new LightningLevel();
		}
	}

}
