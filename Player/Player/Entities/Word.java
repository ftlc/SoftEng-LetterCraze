package Player.Entities;
import java.util.ArrayList;

import Player.Entities.Tile;

public class Word{
	ArrayList<Tile> tiles;
	int wordScore;
	
	public Word(ArrayList<Tile> t, int wordscore){
		this.wordScore = wordscore;
		this.tiles = t;
	}
	public int calculateWordScore(){
		return wordScore;
	}
	
	public String toString(){
		String word = "";
		for(Tile t: tiles){
			word += t.getLetter();
		}
		return word;
	}
	
	// Getters //
	public ArrayList getWordTiles() { return tiles; }
	public int getWordScore() { return wordScore; }
}
