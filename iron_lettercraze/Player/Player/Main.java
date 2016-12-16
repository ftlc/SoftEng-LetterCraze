package Player;
import Player.Boundaries.SplashScreenView;
import Player.Entities.Model;


public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		SplashScreenView s = new SplashScreenView(model);
	}
}
