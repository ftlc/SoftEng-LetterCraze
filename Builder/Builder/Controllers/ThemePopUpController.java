package Builder.Controllers;

import Builder.Boundaries.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemePopUpController implements ActionListener{


		LevelView from;
		ThemeView to;
		public ThemePopUpController(LevelView from, ThemeView to)
		{
			this.from = from;
			this.to = to;
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			to.setVisible(true);
		}
	}


