package Builder.Controllers;

import Builder.Boundaries.ThemeView;
import Builder.Entities.Dictionary;
import Builder.Entities.Model;
import Builder.Entities.ThemeLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/6/16.
 * Controller for the OK button, to pass and save the theme created for the level.
 */
public class AcceptThemeController implements ActionListener {

    ThemeView tv;
    public AcceptThemeController (ThemeView tv) {
        this.tv = tv;
    }

    /**
     * When the OK button is pressed the theme name, the theme words, and theme letters
     * are all saved to the entity classes.
     */
    public void actionPerformed(ActionEvent actionEvent) {

        ThemeLevel lvl = (ThemeLevel)tv.getModel().getLevel();
        Dictionary dictionary = lvl.getDictionary(); 
        lvl.setThemeName(tv.getTheName()); //save the theme name.
        
        String words = tv.getWords().getText();
        String letters = tv.getLetters().getText();
        
        // for-loop that saves the words to the dictionary entity class.
        for (String line : words.split("\\n"))
        {
            if(line.length() > 0) {
                dictionary.addWord(line);
            }
        }

        int j = 0;
        Character[][] let = new Character[6][6];
        // for loop that saves 6 lines of 6 characters each in a 2D array
        for(String line: letters.split("\\n"))
        {
            for(int i = 0; i<line.length(); i++) {
                let[j][i] = line.charAt(i);
            }
            j++;
        }
        
        dictionary.placeLetters(let); // saves the letters to dictionary entity class.
        tv.dispose();

    }
}
