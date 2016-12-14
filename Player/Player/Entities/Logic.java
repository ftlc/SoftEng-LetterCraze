package Player.Entities;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import Player.Boundaries.LevelView;
import Player.Controllers.TileController;

public class Logic {

	Level level;
	String thirdBox;

	public Logic(Level l) {
		this.level = l;
		this.thirdBox = "Not Initializd";
	}

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
	
	public boolean startTimer(LevelView levelView){
		return false;
	}
	public boolean stopTimer(){
		return false;
	}
	
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

	public String getThirdBox() {
		return thirdBox;
	}

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
		}

		return true;
	}

	public boolean readFile(String path) {
		return false;
	}

	public int scoreToAdd(Word theWord) {
		return 1;
	}

	public boolean undoMove() {
		return false;
	}
}
