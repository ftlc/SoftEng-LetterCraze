package Builder.Boundaries;


import Builder.Entities.*;
import Builder.Boundaries.*;
import Builder.Controllers.*;
import junit.framework.TestCase;

public class TestBuilderBoundary extends TestCase {

	Model model;
	SplashScreenView s;
	
	protected void setUp() {
		model = new Model();
		s = new SplashScreenView(model);
	}
	
	protected void tearDown() {
		s.dispose();
	}
	
	public void testBoardView(){
		
	}
	
}
