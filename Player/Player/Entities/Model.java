package Player.Entities;

import java.util.ArrayList;

public class Model {
	
	// Top Level Model For LetterCraze //
	
	
	final int TOTAL_NUM_LEVELS = 15; // 15 Levels in Final Build //
	Level levels[]; // Level Data //
	ArrayList<String> paths;
	
	
	public Model(){
		levels = new Level[TOTAL_NUM_LEVELS];
		this.paths = new ArrayList<String>();
		paths.add("./Levels/Puzzle-Test.txt");
		paths.add("./Levels/Lightning-Test.txt");
		paths.add("./Levels/Theme-Test.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Lightning-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");
		paths.add("./Levels/Puzzle-Test-Uninitialized.txt");	
		
		
		initializeLevels();
	}
	
	/* Read in all levels from disk (eventually) */
	/* Exception (?) for missing level */
	public void initializeLevels(){
		for(int i = 0; i < TOTAL_NUM_LEVELS; i++){
			levels[i] = new Level(paths.get(i), i);
		}
	}

	// Getters and Setters //
	public Level[] getLevels(){ return levels; }
	
	

}
