package Builder.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;

public class ExitBuilderController implements ActionListener{
	    SplashScreenView from;
	    LevelView to;
	    
	    public ExitBuilderController(SplashScreenView from, LevelView to)
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