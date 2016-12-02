package Builder;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
		Level lvl = new Level();
        Model model = new Model(lvl);


		SplashScreenView s = new SplashScreenView(model);
    }
}
