package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;
import Builder.Entities.LightningLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/6/16.
 */
public class AssignTimeController implements ActionListener{

    Level lvltemp;
    LevelView lvlView;
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
            lvlView.getTimeTxt().setText("0");
        }
    }
}
