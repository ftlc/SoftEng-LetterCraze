package Player.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Player.Boundaries.LevelView;
import Player.Entities.Level;

public class ResetBoardController implements ActionListener{
	
	Level level;
	LevelView levelView;
	
	public ResetBoardController(Level l, LevelView lv){
		this.level = l;
		this.levelView = lv;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		level.getLogic().resetBoard();
		levelView.refresh();
	}

}
