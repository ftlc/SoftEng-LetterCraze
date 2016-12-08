package iron_builder;
import java.util.ArrayList;

import javax.swing.JLabel;

import Player.Main;
import Player.Boundaries.GameView;
import Player.Boundaries.LevelView;
import Player.Boundaries.MainMenuView;
import Player.Boundaries.SplashScreenView;
import Player.Boundaries.windowCode;
import Player.Controllers.LevelToMainMenuController;
import Player.Controllers.TileController;
import Player.Entities.Board;
import Player.Entities.Dictionary;
import Player.Entities.Level;
import Player.Entities.LightningLogic;
import Player.Entities.Logic;
import Player.Entities.Model;
import Player.Entities.Position;
import Player.Entities.PuzzleLogic;
import Player.Entities.Star;
import Player.Entities.ThemeLogic;
import Player.Entities.Tile;
import Player.Entities.Word;
import junit.framework.TestCase;



public class EntitiesTesting extends TestCase{
	
	Model model;
	
	

	

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
		
		
	
		three.setScore(1);
		//three.setHighScore(2);
		Logic l3 = new Logic(three);
		Star s =  new Star(1,2,3);
		three.setStar(s);
		
		//logic.writeHighScore(numStars, path); is not working
		//assertTrue(three.saveHighScore());
		
		three.setScore(4);

		Star s1 =  new Star(6,7,8);
		three.setStar(s1);
		assertFalse(three.saveHighScore());
	}
	public void testPosition(){
		Position p =  new Position(1,2);
		assertEquals(p.getX() , 1);
		assertEquals(p.getY() , 2);
		
	}

	public void testStar(){
		Star s = new Star(1,2,3);
		assertEquals(s.calculateStars(6),3);
		assertEquals(s.calculateStars(2),2);
		assertEquals(s.calculateStars(1),1);
		assertEquals(s.calculateStars(0),0);
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
		Position pos1 = new Position(1,1);

		//assertEquals(b.canMoveUp(1, 1) , pos);
		assertFalse(b.isValid(1, 1));
		b.canMoveUp(1, 1);
		
		//assertEquals(b.getTiles(), null);
		
		//assertEquals(24,b.getLayout());
	}
	public void testLogic(){
		Level four = new Level("P", 4);
		
		ArrayList<Tile> tilesToTest = new ArrayList<Tile>();
		tilesToTest.add(new Tile(0,0,"c")); // x,y,Letter
		tilesToTest.add(new Tile(0,0,"a"));
		//tilesToTest.add(new Tile(0,0,"T"));
	
		four.setLastSelectedWord(tilesToTest);
		
		//ArrayList<Tile> lastSelectedWord = four.getLastSelectedWord();
		Logic l = new Logic(four);
		assertFalse(l.playWord());
		Dictionary d = new Dictionary(true);
		
		ArrayList<Tile> tile = new ArrayList<Tile>();
		tile.add(new Tile(1,1,"c")); // x,y,Letter
		tile.add(new Tile(2,1,"a"));
		tile.add(new Tile(3,1,"t"));
		Word word = new Word(tile);
		d.addWord("cat");
		d.hasWord("cat");
		
		four.addWord(word);
		four.setDictionary(d);
		assertTrue(four.hasWord("cat"));
		four.setLastSelectedWord(tile);
		assertTrue(l.playWord());
		
		
		Level level1 = new Level("P", 5);
		Logic l1 = new Logic(level1);
		char [][] tiles = new char[6][6];
		
		Board b  = new Board(tiles);
		
		ArrayList<Tile> tile2 = new ArrayList<Tile>();
		Tile tile4 = new Tile(1,1,"");
		tile2.add(tile4);
	
		level1.setBoard(b);
		b.initializeTiles();
		level1.addCurrTile(tile4);
		// x,y,Letter
		assertTrue(tile4.getLetter().isEmpty());
		assertFalse(tile4.equals(null));
		assertTrue(l1.regenLetters());
		//assertTrue(tile4.getLetter() != "");
		assertTrue(l1.resetBoard());
		assertTrue(l1.writeHighScore(5, "P"));
		
	}
	
	public void testWord(){
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile(1,1,"c")); // x,y,Letter
		tiles.add(new Tile(1,2,"a"));
		tiles.add(new Tile(1,3,"t"));
		Word w = new Word(tiles);
		
		assertEquals(w.getWordScore(), 6);
		
		ArrayList<Tile> tiles1 = new ArrayList<Tile>();
		tiles1.add(new Tile(1,0,"c")); // x,y,Letter
		tiles1.add(new Tile(2,0,"a")); 
		tiles1.add(new Tile(3,0,"t")); 
		Word w1 = new Word(tiles1);
		String t = w1.toString();
		//assertEquals(t,"cat");
			}
	
	public void testLightningLogic(){
		
		Level light = new Level("L", 2);
		LightningLogic l = new LightningLogic(light);
		Model m1 = new Model();
		SplashScreenView v = new SplashScreenView(m1);
		MainMenuView m = new MainMenuView(m1);
		m1.initializeLevels();
		light.reconstruct();
		assertFalse(light.equals(null));
		assertFalse(m.equals(null));
		assertFalse(m1.equals(null));
	
		//assertTrue(l.stopTimer());
		assertFalse(l.playWord());
	}
	public void testPuzzleLogic(){
		Level light = new Level("P", 2);
		PuzzleLogic p  =  new PuzzleLogic(light);
		
		assertFalse(p.playWord());
		//assertFalse(p.resetBoard());
		
		//assertTrue(p.playWord());
	}
	public void testThemeLogic(){
		Level two = new Level("T",3);
		ThemeLogic t = new ThemeLogic(two);
		assertTrue(t.resetBoard());
	}
	public void testLevelToMainMenu(){
		Model model1 = new Model();
		Level one = new Level("P",1);
		MainMenuView m =new MainMenuView(model1);
		m.unlockLevel(1);
		m.reinitLevel(1);
		windowCode w = new windowCode();
		m.updateHighScore(1);
		//fix this later
		//LevelView l = new LevelView(one, m, model1);
	
		//LevelToMainMenuController c = new LevelToMainMenuController( l, m);
		
		}
	public void testTileController(){
		JLabel tileView = new JLabel();
		Tile tile = new Tile(1,1,"a");
		Level l = new Level("P",2);
		Model model1 = new Model();
		MainMenuView mainMenu = new MainMenuView(model1);
		MouseClicked mouse = new MouseClicked();
		LevelView lv = new LevelView(l, mainMenu, model1);
		GameView g = new GameView(lv, l);
		Position p = new Position(1,2);
		
		TileController t = new TileController(tileView , tile, l , g ,p);
	}
}