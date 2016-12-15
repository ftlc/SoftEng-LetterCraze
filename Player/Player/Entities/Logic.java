package Player.Entities;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import Player.Boundaries.LevelView;
import Player.Controllers.TileController;

public class Logic {

	Level level;
	String thirdBox;

	/** 
	 * Constructor for a general logic class - tracks level and what to store in third box of LevelView
	 * @param l Level that this logic class corresponds to (for data manipulation purposes)
	 */
	public Logic(Level l) {
		this.level = l;
		this.thirdBox = "Not Initializd";
	}

	/**
	 * Regenerate letters for empty tiles after word selection
	 * @return boolean representing success
	 */
	public boolean regenLetters(){
		Tile[][] tiles = level.getBoard().getTiles();
		Tile theTile = null;
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				theTile = tiles[x][y];
				if(theTile != null && theTile.getLetter().isEmpty()){
					theTile.setLetter(theTile.generateLetter());
				}
			}
		}
		return true;
	}
	
	/** 
	 * Determine whether or not level can undo
	 * @return True for all level types other than lightning
	 */
	public boolean canUndo(){
		return true;
	}
	
	/**
	 * Generate new letters for all tiles on board
	 * @return boolean representing success
	 */
	public boolean resetBoard(){
		level.setSelectedWords(new ArrayList<Word>());
		level.setScore(0);
		
		Tile[][] tiles = level.getBoard().getTiles();
		Tile theTile = null;
		for (int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				theTile = tiles[x][y];
				if(theTile !=null){
					theTile.setLetter(theTile.generateLetter());
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Start Timer (not used for levels other than lightning level)
	 * @param levelView LevelView Corresponding to level 
	 * @return boolean representing whether timer was started
	 */
	public boolean startTimer(LevelView levelView){
		return false;
	}
	/**
	 * Stop Timer (not used for levels other than lightning level)
	 * @return boolean representing whether timer was stopped
	 */
	public boolean stopTimer(){
		return false;
	}
	
	/**
	 * Default version of play word - checks if selected tiles are valid and adjusts score accordingly if applicable
	 * @return boolean representing whether or not word was valid to play
	 */
	public boolean playWord() {

		ArrayList<Tile> lastSelectedWord = level.getLastSelectedWord();

		if (lastSelectedWord != null) {

			if (lastSelectedWord.size() < 3) {
				return false;
			}

			String w = "";
			for (Tile t : lastSelectedWord) {
				w += t.getLetter();
			}

			if (level.hasWord(w)) {
				Word theWord = new Word(lastSelectedWord);
				int scoreToAdd = scoreToAdd(theWord);
				level.addScore(scoreToAdd);
				level.addWord(theWord);	
				
				return true;
			}
		}
		return false;
	}

	/** 
	 * Get String to be placed inside Third Box of level view
	 * @return String of text for Third Box
	 */
	public String getThirdBox() {
		return thirdBox;
	}

	/**
	 * Writes High Score to file 
	 * @param num Number to be written
	 * @param path Path to file to overwrite
	 * @return boolean representing success
	 */
	public boolean writeHighScore(int num, String path) {
		try {
			RandomAccessFile f = new RandomAccessFile(path, "rw");

			long length = f.length() - 1;
			f.seek(length);
			while (f.readByte() != 10){
				length -= 1;
				f.seek(length);
			}
			f.writeBytes(String.valueOf(num));
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Initialize Entities corresponding to File (no default implementation)
	 * @param path Path to config file
	 * @return boolean representing success
	 */
	public boolean readFile(String path) {
		return false;
	}

	/**
	 * Score to be added every time a move is made (1 for all levels other than puzzle)
	 * @param theWord Word that has been played (for use in puzzle calculations)
	 * @return Integer representing score to be added
	 */
	public int scoreToAdd(Word theWord) {
		return 1;
	}

	/**
	 * Can move be undone?
	 * @return boolean representing whether or not moves can be undone in this level
	 */
	public boolean undoMove() {
		return false;
	}
}
