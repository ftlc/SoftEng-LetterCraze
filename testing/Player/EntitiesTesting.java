package Player;

import java.util.ArrayList;

import Player.Entities.*;
import junit.framework.TestCase;

/**
 * Entities Test Cases
 * @author bwbonanno
 *
 */

public class EntitiesTesting extends TestCase {
	
	/**
	 * Test Level Default Constructor for Preview Level
	 */	
	public void testLevelDefaultConstructor(){
		Level level = new Level();
		assertEquals(null, level.getDictionary());
		assertEquals(0, level.getScore());
		assertFalse(level.getSelectingWord());
	}
	/**
	 * Test Puzzle Level's Select Word Logic
	 */
	public void testPuzzleSelectWord(){
		Level level = new Level("Levels/Puzzle-Test.txt", 0);
		Logic logic = level.getLogic();
		
		assertFalse(logic.playWord());
		
		ArrayList<Tile> word = new ArrayList<Tile>();
		
		word.add(new Tile(0,0,"c"));
		word.add(new Tile(0,1,"a"));
		word.add(new Tile(0,2,"t"));
		
		level.setLastSelectedWord(word);
		
		assertTrue(level.playWord());
		logic.regenLetters();
		
	}
	/**
	 * Test Lightning Level's Select Word Logic
	 */
	public void testLightningSelectWord(){
		Level level = new Level("Levels/Lightning-Test.txt", 0);
		Logic logic = level.getLogic();
		
		assertFalse(logic.playWord());
		
		ArrayList<Tile> word = new ArrayList<Tile>();
		
		word.add(new Tile(0,0,"c"));
		word.add(new Tile(0,1,"a"));
		word.add(new Tile(0,2,"t"));
		
		level.setLastSelectedWord(word);
		
		assertTrue(level.playWord());
		logic.regenLetters();
	}

}
