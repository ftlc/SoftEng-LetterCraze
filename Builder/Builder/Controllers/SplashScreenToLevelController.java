package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 11/29/16.
 */
public class SplashScreenToLevelController implements ActionListener{
    SplashScreenView from;
    LevelView to;
    public SplashScreenToLevelController(SplashScreenView from, LevelView to)
    {
        this.from = from;
        this.to = to;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        from.setVisible(false);
        to.setVisible(true);
    }
}
