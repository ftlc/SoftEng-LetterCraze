package Player.Entities;

import java.util.ArrayList;

import Player.Controllers.TileController;

public class Logic {

	Level level;
	String thirdBox;

	public Logic(Level l) {
		this.level = l;
		this.thirdBox = "Not Initializd";
	}

	public boolean playWord() {

		ArrayList<Tile> lastSelectedWord = level.getLastSelectedWord();
	
		if (lastSelectedWord != null) {
			
			if(lastSelectedWord.size() < 3){
				return false;
			}

			String w = "";
			for (Tile t : lastSelectedWord) {
				w += t.getLetter();
			}

			if (level.hasWord(w)) {
				Word theWord = new Word(lastSelectedWord);
				level.addScore(scoreToAdd(theWord));
				level.addWord(theWord);

				return true;
			}
		}
		return false;
	}
	
	public String getThirdBox(){
		return thirdBox;
	}
	
	public boolean readFile(String path){
		return false;
	}
	
	protected int scoreToAdd(Word theWord){
		return 1;
	}

	public boolean undoMove() {
		return false;
	}
}
