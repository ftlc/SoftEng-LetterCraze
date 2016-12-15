package Player.Controllers;

import Player.Boundaries.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/15/16.
 */
public class ExitPreviewController implements ActionListener {


    LevelView lv;
    public ExitPreviewController(LevelView lv) {
        this.lv = lv;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        lv.dispose();
    }
}
