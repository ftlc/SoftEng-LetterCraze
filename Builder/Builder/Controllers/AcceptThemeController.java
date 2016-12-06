package Builder.Controllers;

import Builder.Boundaries.ThemeView;
import Builder.Entities.Dictionary;
import Builder.Entities.Model;
import Builder.Entities.ThemeLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/6/16.
 */
public class AcceptThemeController implements ActionListener {

    ThemeView tv;
    public AcceptThemeController (ThemeView tv) {
        this.tv = tv;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ThemeLevel lvl = (ThemeLevel)tv.getModel().getLevel();
        Dictionary dictionary = lvl.getDictionary();
        lvl.setThemeName(tv.getTheName());

        String words = tv.getWords().getText();
        String letters = tv.getLetters().getText();
        for (String line : words.split("\\n"))
        {

            if(line.length() > 0) {
                dictionary.addWord(line);
            }
        }

        int j = 0;
        Character[][] let = new Character[6][6];
        for(String line: letters.split("\\n"))
        {

            for(int i = 0; i<line.length(); i++) {
                let[j][i] = line.charAt(i);
            }
            j++;
        }





        dictionary.placeLetters(let);

        tv.dispose();

    }
}
