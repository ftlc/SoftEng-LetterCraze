package Player.Controllers;

import Player.Boundaries.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller that exits the preview level.
 */
public class ExitPreviewController implements ActionListener {


    LevelView lv;
    public ExitPreviewController(LevelView lv) {
        this.lv = lv;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        lv.dispose();
        lv.getLevel().getLogic().stopTimer();
    }
}
