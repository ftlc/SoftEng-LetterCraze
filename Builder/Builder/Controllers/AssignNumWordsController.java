package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;
import Builder.Entities.PuzzleLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller that saves the number of max words for the Puzzle level.
 */
public class AssignNumWordsController implements ActionListener{

    Level tempLevel;
    PuzzleLevel lvl;
    LevelView lvlView;

    /**
     * Constructor of the controller.
     * @param lvl, the entity object holding that information.
     * @param lvlView, the boundary object that captures that info from the user.
     */
    public AssignNumWordsController(Level lvl, LevelView lvlView) {
        this.tempLevel = lvl;
        this.lvlView = lvlView;
    }
    
    /**
     * The action performed on the GUI object when controller is called
     * save String value and place in the lvl entity object.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        lvl = (PuzzleLevel) tempLevel;
        String txt = lvlView.getMaxWordstxt().getText();
        try {
            int contents = Integer.parseInt(txt);
            lvl.assignMaxWords(contents);
        }
        catch (Exception e){
            lvlView.getMaxWordstxt().setText(txt);
        }

    }
}
