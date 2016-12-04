package Player.Entities;

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
			int levelType = i % 3;
			switch(levelType){
			case 0:
				levels[i] = new Level("Puzzle-Test.txt", i); 
				break;
			case 1:
				levels[i] = new Level("Lightning-Test.txt", i);
				break;
			case 2:
				levels[i] = new Level("Theme-Test.txt", i);
			}
		}
	}

	// Getters and Setters //
	public Level[] getLevels(){ return levels; }
	
	

}
