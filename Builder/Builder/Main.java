package Builder;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
		Level lvl = new Level();
        Model model = new Model(lvl);
        ThemeView themeView = new ThemeView(model);
        
		LevelView lview = new LevelView(model, themeView);
		

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreenView frame = new SplashScreenView(model, lview);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
