package Builder.Controllers;

import Builder.Boundaries.SquareView;
import Builder.Boundaries.ThemeView;
import Builder.Entities.Dictionary;
import Builder.Entities.Model;
import Builder.Entities.Square;
import Builder.Entities.ThemeLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the OK button, to pass and save the theme created for the level.
 */
public class AcceptThemeController implements ActionListener {

    ThemeView tv;
    
    /**
     * Constructor that builds the controller Object.
     * @param tv, the ThemeView or dialog box that uses this controller.
     */
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


        dictionary.clearDictionary();
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
            if(line.length() == 6) {


                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    let[j][i] = currentChar;
                    SquareView current = tv.getLevelView().getBoardView().getSquareViewAt(j, i);
                    if(currentChar == '\"')
                    {
                        current.setSelected(false);
                    }
                    else {
                        current.setSelected(true);
                        if(currentChar != '%') {
                            current.setLetter(currentChar);
                        }
                    }

                }
                j++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Number Of Letters Entered");
                return;
            }
        }
        
        dictionary.placeLetters(let); // saves the letters to dictionary entity class.
        tv.dispose();

    }
}
