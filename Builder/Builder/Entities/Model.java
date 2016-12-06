package Builder.Entities;

public class Model {

	Level level;

	public Model(Level level)
	{
		this.level = level;
	}

	public Model() {
		this.level = new Level();
	}

	public void initLevel(Level lvl) {
		this.level = lvl;
	}

	public Level getLevel() {
		return level;
	}
}
