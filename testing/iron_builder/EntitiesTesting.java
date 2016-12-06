package iron_builder;
import java.util.ArrayList;

import Player.Main;
import Player.Entities.Board;
import Player.Entities.Dictionary;
import Player.Entities.Level;
import Player.Entities.Model;
import Player.Entities.Position;
import Player.Entities.Star;
import Player.Entities.Tile;
import junit.framework.TestCase;



public class EntitiesTesting extends TestCase{
	
	Model model;
	
	
	protected void setUp() {
		Model model = new Model();
	
	}
	

	public void testLevel(){
		Level one = new Level("P", 2);
		assertTrue(one.readLevel("P"));
	//	assertTrue(one.puzzleInit("P"));
	//	assertTrue(one.saveHighScore(7));
	//	assertFalse(one.saveHighScore(5));
		
		// Create Tiles //
		ArrayList<Tile> tilesToTest = new ArrayList<Tile>();
		tilesToTest.add(new Tile(0,0,"C")); // x,y,Letter
		tilesToTest.add(new Tile(0,0,"A"));
		tilesToTest.add(new Tile(0,0,"T"));
		
		one.setCurrSelectedWord(tilesToTest);
		assertEquals(tilesToTest, one.getCurrSelectedWord());
		one.setLastSelectedWord(tilesToTest);
		assertEquals(tilesToTest, one.getLastSelectedWord());
		
		
		
		Level two = new Level("L", 2);
		assertTrue(one.readLevel("L"));
	//	assertTrue(one.lightningInit("L"));
		two.setSelectingWord(true);
		assertTrue(two.getSelectingWord());
		
		
		Level three = new Level("T", 2);
		assertTrue(one.readLevel("T"));
	//	assertTrue(one.themeInit("T"));
	
		
		
	}
	public void testPosition(){
		Position p =  new Position(1,2);
		assertEquals(p.getX() , 1);
		assertEquals(p.getY() , 2);
		
	}

	public void testStar(){
		Star s = new Star(1,2,3);
	
		//assertEquals(s.calculateStars(), 6);
	}
	public void testDictionary(){


		Dictionary d = new Dictionary(false);
		assertTrue(d.hasWord("tile"));

		Dictionary c = new Dictionary(true);
	//	ArrayList<String> words = new ArrayList<String>();
		c.addWord("cat");
		assertTrue(c.hasWord("cat"));
		assertFalse(c.hasWord("dog"));
	

		ArrayList<Tile> tiles = new ArrayList<Tile>();
		//Tile c = new Tile(1,1,"c");
		Tile a = new Tile(1,1,"a");
		Tile t = new Tile(1,1,"t");
		//tiles.add(c);
	//	Dictionary d = new Dictionary();

		//assertFalse(d.hasWord(tiles));

	//	assertFalse(d.hasWord(tiles));

		tiles.add(a);
		tiles.add(t);

		//d.addWord("cat");

		//assertTrue(d.hasWord(tiles));

	//	assertTrue(d.hasWord(tiles));


	}
	public void testBoard(){
		
		char [][] tiles = new char[6][6];
		
		Board b  = new Board(tiles);
		//assertEquals(b.getTiles(), null);
		
		//assertEquals(24,b.getLayout());
	}
}