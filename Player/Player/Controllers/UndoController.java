package Player.Controllers;

import Player.Entities.*;
import Player.Boundaries.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UndoController implements ActionListener{
	LevelView levelView;
	Level level;
	
	
	/**
	 * constructor for the undo controller
	 * @param lv previous LevelView to restore on press
	 * @param l previous Level to restore on press (deep copy)
	 */
	public UndoController(LevelView lv, Level l){
		this.levelView = lv;
		this.level = l;
	}
	
	/**
	 * This function is called whenever the undo button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent ae){
		boolean completed = undoMove();
		
		if(completed == true){
			levelView.removeLastSelectedWord();
			levelView.refresh();
		}
	}
	
	/**
	 * undoes the most recent move.
	 * @return true if move is undone
	 * @return false if move is not undone
	 */
	public boolean undoMove(){
		boolean completed = false;
		
		if(level.getLogic().canUndo() == false)
			return false;
		
		completed = level.undoRecentMove();
		
		return completed;
	}

}
