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
	
	public MainMenuToLevelController(MainMenuView from , LevelView to, Level l) {
		this.from = from;
		this.to = to;
		this.level = l;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		from.setVisible(false);
		level.getLogic().startTimer(to);
		to.setVisible(true);
		to.refresh();
	}	
}
