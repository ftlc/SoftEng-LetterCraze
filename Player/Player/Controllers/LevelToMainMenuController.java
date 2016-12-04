package Player.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Player.Boundaries.LevelView;
import Player.Boundaries.MainMenuView;
import Player.Entities.Level;

public class LevelToMainMenuController implements ActionListener{
	
	LevelView from;
	MainMenuView to;
	
	public LevelToMainMenuController(LevelView f, MainMenuView t){
		from = f;
		to = t;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		from.setVisible(false);
		to.setVisible(true);
		Level theLevel = from.getLevel();
		theLevel.reconstruct();
		
		to.reinitLevel(theLevel.getLevelNum());
		from.clearLevel();
		
	}

}
