package Player.Entities;

import java.util.ArrayList;

import Player.Controllers.TileController;

public class Logic {

	Level level;

	public Logic(Level l) {
		this.level = l;
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
	protected int scoreToAdd(Word theWord){
		return 1;
	}

	public boolean undoMove() {
		return false;
	}
}
