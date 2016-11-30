package Builder.Controllers;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;
import Builder.Boundaries.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemePopUpController implements ActionListener{


		SplashScreenView from;
		ThemeView to;
		public ThemePopUpController(SplashScreenView from, ThemeView to)
		{
			this.from = from;
			this.to = to;
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			to.setVisible(true);
		}
	}


