package Entities;

public class Model {
	
	// Top Level Model For LetterCraze //
	
	
	final int TOTAL_NUM_LEVELS = 15; // 15 Levels in Final Build //
	Level levels[]; // Level Data //
	
	public Model(){
		levels = new Level[TOTAL_NUM_LEVELS];
		
		initializeLevels();
	}
	
	/* Read in all levels from disk (eventually) */
	/* Exception (?) for missing level */
	public void initializeLevels(){
		for(int i = 0; i < TOTAL_NUM_LEVELS; i++){
			levels[i] = new Level("null"); // Will become level specific //
		}
	}

	// Getters and Setters //
	public Level[] getLevels(){ return levels; }
	
	

}
