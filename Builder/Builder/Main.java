package Builder;

import Builder.Boundaries.SplashScreenView;
import Builder.Entities.Level;
import Builder.Entities.Model;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Level l = new Level();


        Model model = new Model(l);


        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreenView frame = new SplashScreenView(model);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
