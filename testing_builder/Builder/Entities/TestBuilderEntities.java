package Builder.Entities;

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

	/**
	 * Test the methods in the square entity class.
	 */
	public void testSquare(){
		Square s = new Square(false);
		s.toggleSquare();
		assertTrue(s.isToggle());
		s.setToggle(false);
		assertFalse(s.isToggle());

	}

	/**
	 * Test the shared methods in the level superclass.
	 */
	public void testLevelShared() {
		Level lvl = new Level();
		assertEquals("", lvl.getLevelType());
		Board brd = new Board();
		lvl.setBoard(brd);
		assertEquals(brd, lvl.getBoard());

		int[] stars = new int[3];
		stars[0] = 0;
		stars[1] = 1;
		stars[2] = 2;

		lvl.setStars(stars);
		assertEquals(stars, lvl.getStars());

		lvl.setStarAt(5, 1);
		assertEquals(5, lvl.getStarAt(1));

	}


	/**
	 * Test the PuzzleLevel subclass.
	 */
	public void testPuzzleLevel() {
		Board brd = new Board();
		PuzzleLevel lvl = new PuzzleLevel(brd);

		assertEquals("Puzzle", lvl.getLevelType());

		lvl.assignMaxWords(42);
		assertEquals(42, lvl.getMaxWords());
	}


	/**
	 * Test the LightningLevel subclass.
	 */
	public void testLightningLevel() {
		Board brd = new Board();
		LightningLevel lvl = new LightningLevel(brd);

		assertEquals("Lightning", lvl.getLevelType());

		lvl.assignTime(42);
		assertEquals(42, lvl.getTime());
	}



	/**
	 * Test the ThemeLevel subclass.
	 */
	public void testThemeLevel() {
		Board brd = new Board();
		ThemeLevel lvl = new ThemeLevel(brd);

		assertEquals("Theme", lvl.getLevelType());


		String name = "BestTheme";
		lvl.setThemeName(name);


		assertEquals(name, lvl.getThemeName());



		Dictionary dictionary = new Dictionary();
		lvl.setDictionary(dictionary);
		assertEquals(dictionary, lvl.getDictionary());


	}
}
