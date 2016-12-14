package Player.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Player.Boundaries.LevelView;
import Player.Boundaries.MainMenuView;
import Player.Entities.Level;

public class MainMenuToLevelController implements ActionListener {

	MainMenuView from;
	LevelView to;
	Level level;
	
	/**
	 * Constructor for the MainMenuToLevelController
	 * @param from Parent MainMenuView
	 * @param to LevelView to display on button press
	 * @param l Level to display on button press
	 */
	public MainMenuToLevelController(MainMenuView from , LevelView to, Level l) {
		this.from = from;
		this.to = to;
		this.level = l;
	}

	/**
	 * This function is called when the button is pressed,
	 * it invokes the 'swapViews()' function.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		swapViews();
	}
	
	/**
	 * Swaps the view from the current MainMenuView to
	 * a new LevelView with given Level data.
	 */
	private void swapViews() {
		from.setVisible(false);
		level.getLogic().startTimer(to);
		to.setVisible(true);
		to.refresh();
	}
}	
