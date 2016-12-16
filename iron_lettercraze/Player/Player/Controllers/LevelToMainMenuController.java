package Player.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Player.Boundaries.LevelView;
import Player.Boundaries.MainMenuView;
import Player.Entities.Level;

/**
 * LevelToMainMenuController handles the transition required when a level is exited.
 * @author bwbonanno
 *
 */

public class LevelToMainMenuController implements ActionListener{
	
	LevelView from;
	MainMenuView to;
	
	/**
	 * Constructor for the LevelToMainMenuController class
	 * @param f The Current LevelView
	 * @param t The Parent MainMenuView
	 */
	public LevelToMainMenuController(LevelView f, MainMenuView t){
		from = f;
		to = t;
	}

	
	/**
	 * Default method called whenever the button is pressed,
	 * invokes the 'swapViews()' function.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		swapViews();
	}
	
	/**
	 * Makes the current LevelView with Level data invisible,
	 * and displays the parent MainMenuView.
	 */
	private void swapViews() {
		from.setVisible(false);
		
		Level theLevel = from.getLevel();
		int levelNum = theLevel.getLevelNum();
		boolean returnVal = theLevel.saveHighScore();
		if (returnVal == true) {
			to.updateHighScore(levelNum);
			to.unlockLevel(levelNum+1);
		}
		theLevel.setScore(0);
		
		
		theLevel.getLogic().stopTimer();
		
		to.setVisible(true);
		theLevel.reconstruct();
		
		to.reinitLevel(levelNum);
		from.clearLevel();
	}

}
