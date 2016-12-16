package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SaveLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller that opens the Dialog Box for saving the level.
 */
public class SaveLevelPopupController implements ActionListener{
    LevelView from;
    SaveLevelView to;

    /**
     * Constructor for the Controller Object.
     * @param from the levelView being saved.
     * @param to the SaveLevelView being opened to save the level.
     */
    public SaveLevelPopupController(LevelView from, SaveLevelView to)
    {
        this.from = from;
        this.to = to;
    }


    /**
     * When save level button clicked opens the dialog box.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        to.setVisible(true);
    }
}
