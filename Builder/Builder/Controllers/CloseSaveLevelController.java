package Builder.Controllers;

import Builder.Boundaries.SaveLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller disposes the SaveLevel Dialog Box when closed.
 */
public class CloseSaveLevelController implements ActionListener {

    SaveLevelView sv;

    /**
     * Constructor of the controller object.
     * @param sv the saveLevelView that is disposed.
     */
    public CloseSaveLevelController(SaveLevelView sv) {
        this.sv = sv;
    }
    
    /**
     * Action method that does the disposing.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        sv.dispose();
    }
}
