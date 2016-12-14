package Builder.Boundaries;

import junit.framework.TestCase;
import Builder.Controllers.*;
import Builder.Boundaries.*;
import Builder.Entities.*;

public class TestBuilderController extends TestCase {
	
	LevelView lv;
	Model model;
	
	protected void setUp() {
		model = new Model();
		lv = new LevelView(model);
	}
	
	protected void tearDown(){
		lv.dispose();
	}
	
	public void testAcceptThemeController(){
		
		ThemeView tv = new ThemeView(model);
		
		tv.setName("Animals");
		String themeWords = "Dog\nCat\nMonkey\nDonkey\nGiraffe";
		tv.setTheWords(themeWords);
		String themeLetters = "HUEJFK\nDQEHW\"\nWDW\"FJ\nEIFI\"F\nE\"RJEK\nVNFMEJ";
		tv.setTheLetters(themeLetters);
		//tv.okButton.getActionListeners()[0].actionPerformed(null);
		
		
		
	}
	
	public void testExitBuilderController(){
		
	}
}
