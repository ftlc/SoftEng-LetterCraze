package Player.Controllers;

import Player.Entities.*;
import Player.Boundaries.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UndoController implements ActionListener{
	ArrayList<Move> moves;
	LevelView levelView;
	
	public UndoController(LevelView lv){
		this.moves = new ArrayList<Move>();
		this.levelView = lv;
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
		int size = moves.size();
		
		if(size > 0){
			size--;
			Move move = moves.get(size);
			moves.remove(move);
			
			completed = move.undo();
		}
		
		return completed;
	}

}
