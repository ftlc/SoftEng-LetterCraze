package Builder;

import Builder.Boundaries.SplashScreenView;
import Builder.Entities.Level;
import Builder.Entities.Model;

public class Main {
    public static void main(String[] args) {
        Level l = new Level();


        Model model = new Model(l);
        SplashScreenView s = new SplashScreenView(model);
    }
}
