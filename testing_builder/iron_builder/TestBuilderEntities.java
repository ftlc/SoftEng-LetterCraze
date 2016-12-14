package iron_builder;

import Builder.Boundaries.SplashScreenView;
import Builder.Entities.Model;
import junit.framework.TestCase;

public class TestBuilderEntities extends TestCase {

	
	Model model;
	SplashScreenView s;
	
	protected void setUp() {
		model = new Model();
		s = new SplashScreenView(model);
	}
	
	protected void tearDown() {
		s.dispose();
	}
	
	
}
