package Builder.Controllers;

import Builder.Boundaries.SaveLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/13/16.
 */
public class CloseSaveLevelController implements ActionListener {

    SaveLevelView sv;

    public CloseSaveLevelController(SaveLevelView sv) {
        this.sv = sv;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        sv.dispose();
    }
}
