package Builder.Entities;

import java.util.ArrayList;

/**
 * Created by ftlc on 12/2/16.
 */
public class Dictionary {
    String name;

    ArrayList<String> words;
    Character[][] letters;

    public Dictionary(String name, ArrayList<String> words)
    {
        this.name = name;
        this.words = words;
    }
    public Dictionary()
    {
        this.name = "";
        this.words = new ArrayList<String>();

    }
    public ArrayList<String> getWords() {
        return words;
    }

    public String getName() {
        return name;
    }

    public Character[][] getLetters() {
        return letters;
    }

    public boolean addWord(String word) {
        words.add(word);
        return true;
    }

    public boolean removeWord(String word) {
        words.remove(word);
        return true;
    }


    public boolean placeLetters(Character[][] letters)
    {
        this.letters = letters;
        return true;
    }

    public boolean placeLetters(String let)
    {

        return true;
    }

}
