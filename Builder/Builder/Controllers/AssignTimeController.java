package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;
import Builder.Entities.LightningLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/6/16.
 * Controller called upon the action of the time text field to save it.
 */
public class AssignTimeController implements ActionListener{

    Level lvltemp;
    LevelView lvlView;
    
    /**
     * Constructor of the controller.
     * @param lvl, the entity object holding that information.
     * @param lvlView, the boundary object that captures that info from the user.
     */
    public AssignTimeController (Level lvl, LevelView lvlView) {
        this.lvltemp = lvl;
        this.lvlView = lvlView;
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        LightningLevel lvl = (LightningLevel)lvltemp;
        String contents= lvlView.getTimeTxt().getText();
         try {
            int time = Integer.parseInt(contents);
            lvl.assignTime(time);
        }
        catch (Exception e){
            lvlView.getTimeTxt().setText(contents);
        }
    }
}
