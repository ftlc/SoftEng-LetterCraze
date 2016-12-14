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
		lv.setThemeComboBox();
		lv.setThemeFields();
		ThemeLevel tl = new ThemeLevel();
		lv.setLvl(tl);
		ThemeView tv = lv.getTheme();
		tv.setName("Animals");
		String themeWords = "Dog\nCat\nMonkey\nDonkey\nGiraffe";
		tv.setTheWords(themeWords);
		String themeLetters = "HUEJFK\nDQEHW\"\nWDW\"FJ\nEIFI\"F\nE\"RJEK\nVNFMEJ";
		tv.setTheLetters(themeLetters);
		tv.okButton.getActionListeners()[0].actionPerformed(null);
		
		assertEquals("Theme", lv.getLvl().getLevelType());
		//assertEquals("Animals", lv.getLvl().getThemeName());
	}
	
	public void test
	
}
