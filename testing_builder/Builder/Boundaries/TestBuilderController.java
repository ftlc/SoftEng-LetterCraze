package Builder.Boundaries;

import junit.framework.TestCase;
import Builder.Controllers.*;

import java.io.File;

import Builder.Boundaries.*;
import Builder.Entities.*;

import javax.swing.*;

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
	
	public void testOpenThemeController(){
		lv.setThemeComboBox();
		lv.getComboBox().getActionListeners()[0].actionPerformed(null);
		lv.getThemeButton().getActionListeners()[0].actionPerformed(null);		
		ThemeView tv = lv.getTheme();
		tv.setName("Animals");
		String themeWords = "Dog\nCat\nMonkey\nDonkey\nGiraffe";
		tv.setTheWords(themeWords);
		String themeLetters = "HUEJFK\nDQEHW\"\nWDW\"FJ\nEIFI\"F\nE\"RJEK\nVNFMEJ";
		tv.setTheLetters(themeLetters);
		tv.okButton.getActionListeners()[0].actionPerformed(null);
		assertEquals("Theme", lv.getLvl().getLevelType());
	}
	
	public void testAssignStarsController(){
		lv.setPuzzleComboBox();
		lv.getComboBox().getActionListeners()[0].actionPerformed(null);

		lv.setStarValue1("42");
		lv.setStarValue2("43");
		lv.setStarValue3("44");

		System.out.println("Star1: " + lv.getStarText(1).getText());
		lv.getStarText(1).getActionListeners()[0].actionPerformed(null);
		lv.getStarText(2).getActionListeners()[0].actionPerformed(null);
		lv.getStarText(3).getActionListeners()[0].actionPerformed(null);
		
		assertEquals(42, lv.getLvl().getStarAt(1));
		assertEquals(43, lv.getLvl().getStarAt(2));
		assertEquals(44, lv.getLvl().getStarAt(3));
		
	}
	
	public void testAssignNumWordsController(){
		lv.setPuzzleComboBox();
		lv.setPuzzleFields();
		lv.getMaxWordstxt().setText("20");
		lv.getMaxWordstxt().getActionListeners()[0].actionPerformed(null);
		assertEquals(20, ((PuzzleLevel)lv.getLvl()).getMaxWords());
	}
	
	public void testAssignTimeController(){
		lv.setLightningComboBox();
		lv.getComboBox().getActionListeners()[0].actionPerformed(null);
		lv.getTimeTxt().setText("60");
		lv.getTimeTxt().getActionListeners()[0].actionPerformed(null);
		assertEquals(60, ((LightningLevel)lv.getLvl()).getTime());
	}

	public void testEditLevelController(){

		JFileChooser f1 = lv.getFileFinder();
		f1.setSelectedFile(new File("./Levels/Puzzle-Test.txt"));
		lv.getEditButton().getActionListeners()[0].actionPerformed(null);

		// Select file Puzzle-Test.txt


		String selectedItem = String.valueOf(lv.getComboBox().getSelectedItem());

		if(selectedItem.equals("Puzzle")) {
			assertEquals("10", lv.getStarText(1).getText());
			assertEquals("20", lv.getMaxWordstxt().getText());
		}



	}
	
	public void testSaveLevelControllerPuzzle(){


		JFileChooser f1 = lv.getFileFinder();
		f1.setSelectedFile(new File("./Levels/Puzzle-Test.txt"));
		lv.getEditButton().getActionListeners()[0].actionPerformed(null);
		// Select file Puzzle-Test.txt
		
		lv.getSaveButton().getActionListeners()[0].actionPerformed(null);
		
		lv.getSLView().setTheName("Testing-File.txt");
		lv.getSLView().getOKButton().getActionListeners()[0].actionPerformed(null);
		File file = new File("./Levels/Testing-File.txt");
		assertTrue(file.exists());
	}


	public void testSaveLevelControllerLightning() {


		JFileChooser f1 = lv.getFileFinder();
		f1.setSelectedFile(new File("./Levels/Lightning-Test.txt"));
		lv.getEditButton().getActionListeners()[0].actionPerformed(null);

		lv.getSaveButton().getActionListeners()[0].actionPerformed(null);

		lv.getSLView().setTheName("Testing-File-Lightning.txt");

		lv.getSLView().getOKButton().getActionListeners()[0].actionPerformed(null);

		File file = new File("./Levels/Testing-File-Lightning.txt");
		assertTrue(file.exists());
	}





	public void testSaveLevelControllerTheme() {

		JFileChooser f1 = lv.getFileFinder();
		f1.setSelectedFile(new File("./Levels/Theme-Test.txt"));

		lv.getEditButton().getActionListeners()[0].actionPerformed(null);

		lv.getSaveButton().getActionListeners()[0].actionPerformed(null);


		lv.getSLView().setTheName("Testing-File-Theme.txt");

		lv.getSLView().getOKButton().getActionListeners()[0].actionPerformed(null);

		File file = new File("./Levels/Testing-File-Theme.txt");
		assertTrue(file.exists());
	}


}
