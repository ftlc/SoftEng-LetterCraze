package Builder.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;

public class ExitBuilderController implements ActionListener{
	LevelView levelLeft;


	public ExitBuilderController(LevelView levelLeft)
	{
		this.levelLeft = levelLeft;
	}


	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}

}