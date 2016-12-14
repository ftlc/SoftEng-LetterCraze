package Builder.Entities;

import java.util.ArrayList;

/**
 * This class holds the theme used for the theme level and
 * it contains the theme name, theme words, and theme letter order.
 */
public class Dictionary {
	String name;

	ArrayList<String> words;
	Character[][] letters;

	/**
	 * Constructor of the Entity Object.
	 * @param name The name of the theme ie: Animals.
	 * @param words The words that are in that theme ie: dog, cat, giraffe.
	 */
	public Dictionary(String name, ArrayList<String> words)
	{
		this.name = name;
		this.words = words;
	}
	
	/**
	 * Optional constructor for the dictionary object.
	 */
	public Dictionary()
	{
		this.name = "";
		this.words = new ArrayList<String>();

	}
	
	/**
	 * Getter method for the words in theme/dictionary.
	 * @return the words in the dictionary.
	 */
	public ArrayList<String> getWords() {
		return words;
	}

	/**
	 * Getter method for the name of the theme/dictionary.
	 * @return the name of the theme.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the arbitrarily ordered characters for theme.
	 * @return the user-ordered characters.
	 */
	public Character[][] getLetters() {
		return letters;
	}

	/**
	 * Adds a word to the theme/dictionary.
	 * @param word to be added to the dictionary.
	 * @return true if it was added, if word already exists in theme return false.
	 */
	public boolean addWord(String word) {
		if(!words.contains(word))
		{
			words.add(word);
		}
		return true;
	}

	/**
	 * Removes a word from the dictionary.
	 * @param word The word wished to be removed.
	 * @return true if the word was removed.
	 */
	public boolean removeWord(String word) {
		words.remove(word);
		return true;
	}

	/**
	 * Setter method that saves to the dictionary object the 
	 * arbitrary objects of the theme.
	 * @param letters the arbitrary letters for the theme board.
	 * @return true if the were added correctly.
	 */
	public boolean placeLetters(Character[][] letters)
	{
		this.letters = letters;
		return true;
	}

/*	public boolean placeLetters(String let)
	{
		return true;
	}
*/
	public Character getLetterAt(int x, int y)
	{
		return letters[x][y];
	}

}
