package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/5/16.
 */
public class StarValueController implements ActionListener {

    Level lvl;
    LevelView lvlView;
    int starnum;

    //Constructor
    public StarValueController(Level lvl, LevelView lvlView, int starnum) {
        this.lvl = lvl;
        this.lvlView = lvlView;
        this.starnum = starnum;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String txt = lvlView.getStarText(starnum).getText();
        System.out.println(txt);
        try {
            int contents = Integer.parseInt(txt);
            lvl.setStarAt(contents, starnum);
        }
        catch (Exception e){
            lvlView.getStarText(starnum).setText("0");
        }


    }
}
