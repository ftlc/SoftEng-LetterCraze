package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller performs the transition from the splash screen to the main screen.
 */
public class SplashScreenToLevelController implements ActionListener{
    SplashScreenView from;
    LevelView to;
    
    /**
     * Constructor of the controller object.
     * @param from The source or splash screen from which its transitioning.
     * @param to the levelView that is opened from the splash screen.
     */
    public SplashScreenToLevelController(SplashScreenView from, LevelView to)
    {
        this.from = from;
        this.to = to;
    }

    /**
     * disposes the splash screen and opens the level builder.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        from.setVisible(false);
        to.setVisible(true);
    }
}
