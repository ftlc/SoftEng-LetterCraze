package Builder.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;

/**
 * Controller that allows the user that when they click on EXIT
 * it makes the program shutdown.
 * @author JuanLuis
 */
public class ExitBuilderController implements ActionListener{
	LevelView levelLeft;


	/**
	 * Constructor of the controller object.
	 * @param levelLeft the level from which when clicking on EXIT is left.
	 */
	public ExitBuilderController(LevelView levelLeft)
	{
		this.levelLeft = levelLeft;
	}

	/**
	 * Performs the action of leaving/shutting down the program.
	 */
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}

}