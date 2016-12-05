package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/5/16.
 */
public class AssignNumWordsController implements ActionListener{

    Level lvl;
    LevelView lvlView;


    public AssignNumWordsController(Level lvl, LevelView lvlView) {
        this.lvl = lvl;
        this.lvlView = lvlView;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String txt = lvlView.getMaxWordstxt().getText();
        System.out.println(txt);
        try {
            int contents = Integer.parseInt(txt);
            lvl.setMaxWords(contents);
        }
        catch (Exception e){
            lvlView.getMaxWordstxt().setText("0");
        }

    }
}
