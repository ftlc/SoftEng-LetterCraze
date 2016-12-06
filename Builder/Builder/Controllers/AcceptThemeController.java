package Builder.Controllers;

import Builder.Boundaries.ThemeView;
import Builder.Entities.Model;
import Builder.Entities.ThemeLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/6/16.
 */
public class AcceptThemeController implements ActionListener {

    ThemeView tv;
    public AcceptThemeController (ThemeView tv) {
        this.tv = tv;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
