package Player.Entities;

import java.util.ArrayList;

public class Dictionary {
	
	ArrayList<String> words;
	
	public Dictionary(){
		this.words = new ArrayList<String>();
	}
	
	public boolean addWord(String word){
		return words.add(word);
	}	
	
	public boolean hasWord(ArrayList<Tile> tiles){
		String word = "";
		for(Tile t: tiles){
			word += t.getLetter();
		}
		
		for(String w: words){
			if(w.equals(word))
				return true;		
		}
		return false;
	}

}
