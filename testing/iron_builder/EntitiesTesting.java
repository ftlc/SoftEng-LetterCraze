package iron_builder;
import Player.Main;
import Player.Boundaries.SplashScreenView;
import Player.Entities.Level;
import Player.Entities.Model;
import Player.Entities.Position;
import junit.framework.TestCase;



public class EntitiesTesting extends TestCase{
	
	Model model;
	
	
	protected void setUp() {
		Model model = new Model();
	
	}
	

	public void testLevel(){
		Level one = new Level("P", 2);
		assertTrue(one.readLevel("P"));
		assertTrue(one.puzzleInit("P"));
		assertTrue(one.saveHighScore(7));
		assertFalse(one.saveHighScore(5));
		one.setCurrSelectedWord("cat");
		assertEquals("cat", one.getCurrSelectedWord());
		one.setLastSelectedWord("dog");
		assertEquals("dog", one.getLastSelectedWord());
		
		
		
		Level two = new Level("L", 2);
		assertTrue(one.readLevel("L"));
		assertTrue(one.lightningInit("L"));
		two.setSelectingWord(true);
		assertTrue(two.getSelectingWord());
		
		
		Level three = new Level("T", 2);
		assertTrue(one.readLevel("T"));
		assertTrue(one.themeInit("T"));
	
		
		
	}
	public void testPosition(){
		Position p =  new Position(1,2);
		assertEquals(p.getX() , 1);
		assertEquals(p.getY() , 2);
		
	}


}