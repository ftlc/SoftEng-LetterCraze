package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemePopUpController implements ActionListener{


		SplashScreenView from;
		LevelView to;
		public ThemePopUpController(SplashScreenView from, LevelView to)
		{
			this.from = from;
			this.to = to;
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			from.setVisible(false);
			to.setVisible(true);
		}
	}


