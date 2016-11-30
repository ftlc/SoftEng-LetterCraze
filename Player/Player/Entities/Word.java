package Player.Entities;
import Player.Entities.Tile;

public class Word{
	Tile tiles[];
	int wordScore;
	
	public Word(Tile[] t, int wordscore){
		this.wordScore = wordscore;
		this.tiles = t;
	}
	public int calculateWordScore(){
		return wordScore;
	}
	
	// Getters //
	public Tile[] getWordTiles() { return tiles; }
	public int getWordScore() { return wordScore; }
}
