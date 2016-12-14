package Builder.Controllers;

import Builder.Boundaries.ThemeView;
import Builder.Entities.Dictionary;
import Builder.Entities.Model;
import Builder.Entities.ThemeLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller that disposes the ThemeView/Dictionary dialog box.
 */
public class CloseThemeController implements ActionListener {

    ThemeView tv;
    Model model;
    
    /**
     * Constructor of the controller object.
     * @param tv The themeView that is being disposed when requested.
     * @param m the model that saves the information from the fields.
     */
    public CloseThemeController(ThemeView tv, Model m) {
        this.tv = tv;
        this.model = m;
    }

    /**
     * Method that does the action of disposing.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        tv.dispose();
    }
}
