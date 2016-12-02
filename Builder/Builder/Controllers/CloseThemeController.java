package Builder.Controllers;

import Builder.Boundaries.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 11/30/16.
 */
public class CloseThemeController implements ActionListener {

    ThemeView tv;
    public CloseThemeController(ThemeView tv) {
        this.tv = tv;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        tv.dispose();
    }
}
