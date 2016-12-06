package Player.Entities;

import java.io.IOException;
import java.io.RandomAccessFile;
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

			if (lastSelectedWord.size() < 3) {
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

	protected int scoreToAdd(Word theWord) {
		return 1;
	}

	public boolean undoMove() {
		return false;
	}
}
