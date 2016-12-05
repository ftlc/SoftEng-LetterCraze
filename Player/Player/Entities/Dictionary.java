package Player.Entities;

import java.io.IOException;
import java.util.ArrayList;

import Player.WordTable;

public class Dictionary {
	
	ArrayList<String> words;
	boolean theme;
	WordTable dict;
	
	public Dictionary() {
		this.theme = false;
		dict = new WordTable();
		try {
			dict.loadWordTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dictionary(boolean theme) {
		this.theme = theme;
		if(!theme) {
			dict = new WordTable();
			try {
				dict.loadWordTable();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			words = new ArrayList<String>();
		}
	}
	
	public boolean addWord(String word){
		return words.add(word);
	}	
	
	
	
	public boolean hasWord(String s){
		if(!theme) {
			return dict.isWord(s);
		} else {
			String word = s;
			
			for(String w: words){
				if(w.equals(word))
					return true;		
			}
			return false;
		}
	}

}
