package Builder.Controllers;

import Builder.Boundaries.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Opens the themeView when clicking the right button for making theme levels.
 * @author JuanLuis.
 */
public class ThemePopUpController implements ActionListener{


		LevelView from;
		ThemeView to;
		/**
		 * Constructor of the controller object.
		 * @param from levelView from which we transition.
		 * @param to the ThemeView that is opened.
		 */
		public ThemePopUpController(LevelView from, ThemeView to)
		{
			this.from = from;
			this.to = to;
		}

		/**
		 * Opens the themeView.
		 */
		public void actionPerformed(ActionEvent actionEvent) {
			to.setVisible(true);
		}
	}


