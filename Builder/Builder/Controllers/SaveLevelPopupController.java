package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SaveLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/13/16.
 */
public class SaveLevelPopupController implements ActionListener{
    LevelView from;
    SaveLevelView to;

    public SaveLevelPopupController(LevelView from, SaveLevelView to)
    {
        this.from = from;
        this.to = to;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        to.setVisible(true);
    }
}
