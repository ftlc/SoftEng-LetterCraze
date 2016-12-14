package Builder.Entities;

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
     * @param name of the theme.
     */

    /**
     * Constructor of the object.
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
      * Setter method for the dictionary attribute of the themeLevel.
      * @param d the dictionary assigned.
      * @return true if the dictionary was assigned.
      */
    boolean MakeDictionary(Dictionary d) {
        this.dictionary = d;
        return true;
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
        this.name = name;
    }

    /**
     * getter method for the dictionary attribute of the theme level.
     * @return the dictionary of the theme level.
     */
    public Dictionary getDictionary() {
        return dictionary;
    }
}
