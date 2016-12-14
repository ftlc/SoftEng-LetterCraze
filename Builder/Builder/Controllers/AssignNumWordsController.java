package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;
import Builder.Entities.PuzzleLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/5/16.
 */
public class AssignNumWordsController implements ActionListener{

    Level tempLevel;
    PuzzleLevel lvl;
    LevelView lvlView;


    public AssignNumWordsController(Level lvl, LevelView lvlView) {
        this.tempLevel = lvl;
        this.lvlView = lvlView;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        lvl = (PuzzleLevel) tempLevel;
        String txt = lvlView.getMaxWordstxt().getText();
        System.out.println(txt);
        try {
            int contents = Integer.parseInt(txt);
            lvl.assignMaxWords(contents);
        }
        catch (Exception e){
            lvlView.getMaxWordstxt().setText(txt);
        }

    }
}
