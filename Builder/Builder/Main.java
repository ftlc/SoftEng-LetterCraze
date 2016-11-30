package Builder;

import Builder.Boundaries.LevelView;
import Builder.Boundaries.SplashScreenView;
import Builder.Entities.Level;
import Builder.Entities.Model;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
		Level lvl = new Level();
        Model model = new Model(lvl);
		LevelView lview = new LevelView(model);

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
