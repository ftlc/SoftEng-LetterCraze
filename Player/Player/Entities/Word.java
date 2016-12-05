package Player.Entities;
import java.util.ArrayList;
import java.util.HashMap;

import Player.Entities.Tile;

public class Word{
	HashMap<String, Integer> letterScores;
	ArrayList<Tile> tiles;
	int wordScore;
	
	public Word(ArrayList<Tile> t){
		this.tiles = t;
		this.letterScores = new HashMap<String, Integer>();
		
		initScores();
		this.wordScore = calculateWordScore();
	}
	
	private void initScores(){
		// 1 Point //
		letterScores.put("e",1);
		letterScores.put("t",1);
		
		// 2 Points //
		letterScores.put("a",2);
		letterScores.put("o",2);
		letterScores.put("i",2);
		letterScores.put("n",2);
		letterScores.put("s",2);
		letterScores.put("h",2);
		letterScores.put("r",2);
		
		// 3 Points //
		letterScores.put("l",3);
		letterScores.put("d",3);
		letterScores.put("c",3);
		letterScores.put("u",3);
		letterScores.put("m",3);
		letterScores.put("w",3);
		
		// 4 Points //
		letterScores.put("f",4);
		letterScores.put("g",4);
		letterScores.put("y",4);
		letterScores.put("p",4);
		letterScores.put("b",4);
		
		// 5 Points //
		letterScores.put("v",5);
		letterScores.put("k",5);
		
		// 7 Points //
		letterScores.put("j",7);
		letterScores.put("x",4);
		
		// 8 Points //
		letterScores.put("z",8);
		
		// 11 Points //
		letterScores.put("qu",11);
	}
	
	private int calculateWordScore(){
		int total = 0;
		for(Tile t: tiles){
			total += letterScores.get(t.getLetter());
		}
		
		return total;
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
