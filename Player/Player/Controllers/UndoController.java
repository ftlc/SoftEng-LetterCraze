package Player.Controllers;

import Player.Entities.*;
import Player.Boundaries.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UndoController implements ActionListener{
	LevelView levelView;
	Level level;
	
	public UndoController(LevelView lv, Level l){
		this.levelView = lv;
		this.level = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		boolean completed = undoMove();
		
		if(completed == true){
			levelView.refresh();
		}
	}
	
	public boolean undoMove(){
		boolean completed = false;
		completed = level.undoRecentMove();
		
		return completed;
	}

}
