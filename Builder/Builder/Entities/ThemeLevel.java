package Builder.Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The subclass ThemeLevel of the super class Level.
 * Created by ftlc on 12/2/16.
 */
public class ThemeLevel extends Level{
    String name;
    Dictionary dictionary;
    /**
     * Constructor of the theme level object.
     * @param brd the board that belongs to this level.
     */
    public ThemeLevel(Board brd) {
        super(brd);
        this.name = "";
       this.dictionary = new Dictionary();

     }

     /**
      * for this subclass of level always returns theme.
      */
     public String getLevelType() {
        return "Theme";
     }


    /**
     * Getter method for the name of the theme.
     * @return the name of theme.
     */
    public String getThemeName() {
        return name;
    }

    /**
     * Setter method for the name of theme.
     * @param themeName the name wished to be changed to.
     */
    public void setThemeName(String themeName) {
        this.name = themeName;
    }

    /**
     * getter method for the dictionary attribute of the theme level.
     * @return the dictionary of the theme level.
     */
    public Dictionary getDictionary() {
        return dictionary;
    }


    /**
     * Setter method for the dictionary of theme.
     * @param dictionary The Dictionary we're assigning to this theme.
     */
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    @Override
    public void writeLevel(String FileName) {
        System.out.println("ThemeLevel");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {

            String content = "T\n-\n";
            content = addStars(content);
            String name = this.getThemeName();
            content += name + "\n-\n";
            Dictionary dictionary = this.getDictionary();
            ArrayList<String> words = dictionary.getWords();

            for (String w : words) {
                content += w + "\n";
            }
            content += "-\n";

            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    content += dictionary.getLetterAt(x, y);
                }
                content += "\n";
            }

            content += "-\n0";

            System.out.println(content);
            bw.write(content);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
