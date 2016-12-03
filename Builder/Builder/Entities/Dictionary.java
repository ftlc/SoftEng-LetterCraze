package Builder.Entities;

import java.util.ArrayList;

/**
 * Created by ftlc on 12/2/16.
 */
public class Dictionary {
    String name;

    ArrayList<String> words;
    String[][] letters;

    public Dictionary(String name, ArrayList<String> words)
    {
        this.name = name;
        this.words = words;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getName() {
        return name;
    }

    public String[][] getLetters() {
        return letters;
    }

    boolean addWord(String word) {
        words.add(word);
        return true;
    }

    boolean removeWord(String word) {
        words.remove(word);
        return true;
    }


    boolean placeLetters(String[][] letters)
    {
        this.letters = letters;
        return true;
    }

}
