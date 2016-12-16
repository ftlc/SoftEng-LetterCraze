package Player.Entities;

import java.util.ArrayList;

public class Model {
	
	// Top Level Model For LetterCraze //
	
	
	final int TOTAL_NUM_LEVELS = 15; // 15 Levels in Final Build //
	Level levels[]; // Level Data //
	ArrayList<String> paths;
	
	/**
	 * Constructor for new model - initialize all paths and levels
	 */
	public Model(){
		levels = new Level[TOTAL_NUM_LEVELS];
		this.paths = new ArrayList<String>();
		paths.add("./Levels/Level1.txt");
		paths.add("./Levels/Level2.txt");
		paths.add("./Levels/Level3.txt");
		paths.add("./Levels/Level4.txt");
		paths.add("./Levels/Level5.txt");
		paths.add("./Levels/Level6.txt");
		paths.add("./Levels/Level7.txt");
		paths.add("./Levels/Level8.txt");
		paths.add("./Levels/Level9.txt");
		paths.add("./Levels/Level10.txt");
		paths.add("./Levels/Level11.txt");
		paths.add("./Levels/Level12.txt");
		paths.add("./Levels/Level13.txt");
		paths.add("./Levels/Level14.txt");
		paths.add("./Levels/Level15.txt");	
		
		initializeLevels();
	}
	
	/**
	 * Read in all levels from config files
	 */
	public void initializeLevels(){
		for(int i = 0; i < TOTAL_NUM_LEVELS; i++){
			levels[i] = new Level(paths.get(i), i);
		}
	}

	/**
	 * Get All Levels
	 * @return Array of Levels
	 */
	public Level[] getLevels(){ return levels; }
	
	

}
