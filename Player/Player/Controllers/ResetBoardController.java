package Player.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Player.Boundaries.LevelView;
import Player.Entities.Level;
import Player.Entities.Word;

public class ResetBoardController implements ActionListener{
	
	Level level;
	LevelView levelView;
	
	/**
	 * Constructor for the ResetBoardController class
	 * @param l Level that will be reset
	 * @param lv LevelView that will be reset
	 */
	public ResetBoardController(Level l, LevelView lv){
		this.level = l;
		this.levelView = lv;
	}
	
	/**
	 * Called when the button is clicked.
	 * Calls the 'refresh()' method.
	 */
	@Override
	public void actionPerformed(ActionEvent ae){
		reset();
	}

	/**
	 * Code to reset the level utilizing functions in the level.
	 */
	private void reset() {
		level.getLogic().resetBoard();
		levelView.refresh();
		levelView.clearSelectedWords();
	}
}
