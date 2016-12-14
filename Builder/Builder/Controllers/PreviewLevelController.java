package Builder.Controllers;

import Player.Boundaries.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class allows the user that when they build a level
 * they can preview it before saving and shipping it.
 */
public class PreviewLevelController implements ActionListener {

    Builder.Boundaries.LevelView lv;
    /**
     * Constructor of the controller object.
     * @param lv The levelView that is going to be previewed.
     */
    public PreviewLevelController(Builder.Boundaries.LevelView lv) {
        this.lv = lv;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        //Player.Boundaries.LevelView playerLv = new Player.Boundaries.LevelView();

    }
}
