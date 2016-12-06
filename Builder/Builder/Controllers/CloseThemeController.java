package Builder.Controllers;

import Builder.Boundaries.ThemeView;
import Builder.Entities.Dictionary;
import Builder.Entities.Model;
import Builder.Entities.ThemeLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 11/30/16.
 */
public class CloseThemeController implements ActionListener {

    ThemeView tv;
    Model model;
    public CloseThemeController(ThemeView tv, Model m) {
        this.tv = tv;
        this.model = m;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        tv.dispose();
    }
}
