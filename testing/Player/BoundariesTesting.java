package Player;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Player.Main;
import Player.Boundaries.*;
import Player.Controllers.*;
import Player.Entities.*;
import junit.framework.TestCase;

/**
 * Boundaries and Controllers Test Cases
 * @author bwbonanno
 *
 */

public class BoundariesTesting extends TestCase {
	Model m;
	MainMenuView menu;
	LevelView levelView;
	Level level;
	GameView gameView;
	JLabel[][] tileViews;
	TileController[][] tileControllers;
	UndoController undo;
	LevelView levelViews;
	MainMenuView mainView;
	JButton undobutton;
	JButton resetbutton;
	JButton exitbutton;
	JButton button;
	Tile[][] tiles;
	
	/**
	 * Open Theme Level 1 for Testing
	 */
	
	public void setUp(){
		m = new Model();
		menu = new MainMenuView(m);
		assertTrue((menu != null));
		JPanel levelButton = menu.getLevelButton(2);
		button = (JButton)levelButton.getComponent(0);
		button.doClick();		
		
		LevelView level3 = menu.getLevelView(2);
		assertTrue(level3.isVisible());
		assertFalse(menu.isVisible());
		this.levelView = level3;
		this.level = level3.getLevel();
		
		tiles = level.getBoard().getTiles();
		gameView = levelView.getGameView();
		tileViews = gameView.getTileViews();
		tileControllers = gameView.getTileControllers();
	    
	    this.undobutton = levelView.getBtnUndo();	
		this.resetbutton = levelView.getBtnResetBoard();
		this.exitbutton = levelView.getBtnExit();
	  
	}
	
	/**
	 * Dispose of window
	 */
	public void tearDown(){
		
		exitbutton.doClick();
		assertFalse(levelView.isVisible());
		assertTrue(menu.isVisible());
		
		m = null;
		menu.dispose();
	}
	
	/**
	 * Verify Selecting Tile behavior
	 */
	public void testClickLevel(){
		
		MouseEvent me = createMouseEvent(MouseEvent.MOUSE_PRESSED, tileViews[0][0]);
		tileControllers[0][0].mousePressed(me);
		
		assertTrue(level.getSelectingWord());
		assertEquals(level.getCurrSelectedWord().size(), 1);
		
		me = createMouseEvent(MouseEvent.MOUSE_RELEASED, tileViews[0][0]);
		tileControllers[0][0].mouseReleased(me);
		
		assertFalse(level.getSelectingWord());
		assertEquals(level.getCurrSelectedWord().size(), 0);
		
		return;
	}
	
	/**
	 * Verify Word Selection Behavior on Theme Level
	 */
	public void testWordSelection(){
		MouseEvent me = createMouseEvent(MouseEvent.MOUSE_PRESSED, tileViews[3][0]);
		tileControllers[3][0].mousePressed(me);
		
		assertTrue(level.getSelectingWord());
		
		me = createMouseEvent(MouseEvent.MOUSE_ENTERED, tileViews[4][0]);
		tileControllers[4][0].mouseEntered(me);
		
		assertEquals(2, level.getCurrSelectedWord().size());
		
		me = createMouseEvent(MouseEvent.MOUSE_ENTERED, tileViews[5][0]);
		tileControllers[5][0].mouseEntered(me);
		
		assertEquals(3, level.getCurrSelectedWord().size());
		
		me = createMouseEvent(MouseEvent.MOUSE_RELEASED, tileViews[5][0]);
		tileControllers[5][0].mouseReleased(me);
		
		assertFalse(level.getSelectingWord());
		assertEquals(0, level.getCurrSelectedWord().size());
		
		assertEquals(1, level.getScore());
		assertEquals(1, level.getMoves().size());
		assertTrue(tileViews[3][5].getText().isEmpty());
		assertTrue(tileViews[4][5].getText().isEmpty());
		assertTrue(tileViews[5][5].getText().isEmpty());
	}
	
	/**
	 * Verify Undo 
	 */
	public void testUndoClicked(){		
		selectCat();
		
		undobutton.doClick();
		assertEquals(0, level.getScore());
		assertEquals(0, level.getMoves().size());
		assertFalse(tileViews[3][5].getText().isEmpty());
		assertFalse(tileViews[4][5].getText().isEmpty());
		assertFalse(tileViews[5][5].getText().isEmpty());
		
		assertEquals("c", tileViews[3][0].getText());
		assertEquals("a", tileViews[4][0].getText());
		assertEquals("t", tileViews[5][0].getText());
		
		assertEquals("c", tiles[3][0].getLetter());
		assertEquals("a", tiles[4][0].getLetter());
		assertEquals("t", tiles[5][0].getLetter());
		
	}
	
	/**
	 * Verify Reset Board behavior
	 */
	public void testResetBoard(){
		selectCat();
		
		resetbutton.doClick();
		
		assertEquals(0, level.getScore());
		assertEquals(0, level.getMoves().size());
		assertFalse(tileViews[3][5].getText().isEmpty());
		assertFalse(tileViews[4][5].getText().isEmpty());
		assertFalse(tileViews[5][5].getText().isEmpty());
		
		assertEquals("c", tileViews[3][0].getText());
		assertEquals("a", tileViews[4][0].getText());
		assertEquals("t", tileViews[5][0].getText());
		
		Tile[][] temp_tiles = level.getBoard().getTiles();
		assertEquals("c", temp_tiles[3][0].getLetter());
		assertEquals("a", temp_tiles[4][0].getLetter());
		assertEquals("t", temp_tiles[5][0].getLetter());
	}
	
	/**
	 * Ensure you can re enter level
	 */
	public void testExitLevel(){
		exitbutton.doClick();
		button.doClick();
		
		assertFalse(menu.isVisible());
	}	
	
	/**
	 * Generate Left Click MouseEvent Helper Function
	 * @param eventType Type of Event to be Generated
	 * @param c Component to be clicked
	 * @return me MouseEvent
	 */
	public MouseEvent createMouseEvent(int eventType, JComponent c){
		MouseEvent me = new MouseEvent(c, eventType, System.currentTimeMillis(), MouseEvent.BUTTON1_MASK, 0, 0, 0, false, MouseEvent.BUTTON1);
		return me;
	}
	
	/**
	 * Select Word "Cat" in Level Helper Function
	 */
	public void selectCat(){
		MouseEvent me = createMouseEvent(MouseEvent.MOUSE_PRESSED, tileViews[3][0]);
		tileControllers[3][0].mousePressed(me);
		
		me = createMouseEvent(MouseEvent.MOUSE_ENTERED, tileViews[4][0]);
		tileControllers[4][0].mouseEntered(me);
		
		me = createMouseEvent(MouseEvent.MOUSE_ENTERED, tileViews[5][0]);
		tileControllers[5][0].mouseEntered(me);
		
		me = createMouseEvent(MouseEvent.MOUSE_RELEASED, tileViews[5][0]);
		tileControllers[5][0].mouseReleased(me);
	}

}
