package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundaries.LevelView;
import Boundaries.MainMenuView;

public class MainMenuToLevelController implements ActionListener {

	MainMenuView from;
	LevelView to;
	
	public MainMenuToLevelController(MainMenuView from , LevelView to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		from.setVisible(false);
		to.setVisible(true);
		to.refresh();
	}	
}
