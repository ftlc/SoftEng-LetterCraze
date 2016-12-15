package Player.Entities;

import java.io.IOException;
import java.util.ArrayList;

import Player.WordTable;

/**
 * Dictionary holds the relevant dictionary for each level (theme-specific for theme levels, default otherwise).
 * @author bwbonanno
 *
 */

public class Dictionary {
	
	ArrayList<String> words;
	boolean theme;
	WordTable dict;
	
	/**
	 * Default constructor for the Dictionary class.
	 * assumes that theme is false and loads the default word table.
	 */
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
	
	/**
	 * Special constructor for Dictionary to allow the user to specify
	 * if the Dictionary is a theme dictionary.
	 * @param theme Boolean representing whether or not this is a theme level
	 */
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
	
	/**
	 * Adds a given word to the dictionary
	 * @param word Word to be added
	 * @return true on success
	 * @return false on failure
	 */
	public boolean addWord(String word){
		return words.add(word);
	}	
	
	
	/**
	 * Determines if the given string is a valid word in the dictionary
	 * @param s String to be checked 
	 * @return true if s is in the dictionary
	 * @return false if s is not in the dictionary
	 */
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
