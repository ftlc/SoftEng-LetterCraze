package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Entities.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller handles the input from the user for the different star values.
 */
public class StarValueController implements ActionListener {

    Level lvl;
    LevelView lvlView;
    int starnum;

    /**
     * Constructor of the controller object.
     * @param lvl The level entity object in which the information is stored.
     * @param lvlView the levelView in which the user inputs the values.
     * @param starnum The number of stars input.
     */
    public StarValueController(Level lvl, LevelView lvlView, int starnum) {
        this.lvl = lvl;
        this.lvlView = lvlView;
        this.starnum = starnum;
    }


    /**
     * Takes the input from the GUI objects given by the user and saves them
     * to be later stored in a text file.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        String txt = lvlView.getStarText(starnum).getText();
        System.out.println(txt);
        try {
            int contents = Integer.parseInt(txt);
            lvl.setStarAt(contents, starnum);
        }
        catch (Exception e){
            lvlView.getStarText(starnum).setText(txt); // I changed this so it wouldn't set the value to 0 everytime you press enter.
        }


    }
}
