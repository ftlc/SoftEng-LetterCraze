package Entities;
import Entities.Tile;

public class Word{
	Tile tiles[] = new tiles[*];
	int wordscore;
	
	public Word(Tile t, int wordscore){
		this.wordscore = wordscore;
		this.tiles = t;
	}
	public int calculateWordScore(){
		return wordscore;
	}
}
