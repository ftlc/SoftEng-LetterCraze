package Builder.Controllers;

import Player.Boundaries.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/10/16.
 */
public class PreviewLevelController implements ActionListener {

    Builder.Boundaries.LevelView lv;

    public PreviewLevelController(Builder.Boundaries.LevelView lv) {
        this.lv = lv;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        //Player.Boundaries.LevelView playerLv = new Player.Boundaries.LevelView();

    }
}
