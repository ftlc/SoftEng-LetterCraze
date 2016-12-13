package Builder;


import Builder.Boundaries.SplashScreenView;
import Builder.Entities.Level;
import Builder.Entities.Model;

/**
 * @author Juan Luis Herrero Estrada
 * Main Method that runs the program.
 */
public class Main {
	public static void main(String[] args) {
		Model model = new Model();


		SplashScreenView s = new SplashScreenView(model);
	}
}
