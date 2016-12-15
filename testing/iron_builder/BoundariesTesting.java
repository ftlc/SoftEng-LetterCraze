package iron_builder;

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
	Tile[][] tiles;
	public void setUp(){
		m = new Model();
		menu = new MainMenuView(m);
		this.tiles = new Tile[1][1];
		assertTrue((menu != null));
		JPanel levelButton = menu.getLevelButton(2);
		JButton button = (JButton)levelButton.getComponent(0);
		button.doClick();
		this.undobutton = (JButton)levelButton.getComponent(1);
		
		
		this.resetbutton = (JButton)levelButton.getComponent(2);
		
		
		
		
		
		
		
		LevelView level3 = menu.getLevelView(2);
		assertTrue(level3.isVisible());
		this.levelView = level3;
		this.level = level3.getLevel();
		
		gameView = levelView.getGameView();
		tileViews = gameView.getTileViews();
		tileControllers = gameView.getTileControllers();
	
		mainView = 	levelViews.getMainMenuView();
	    levelViews = gameView.getLevelView();
	  
	}
	
	public void tearDown(){
		m = null;
		menu.dispose();
	}
	
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
	public void testUndoClicked(){
		MouseEvent ma = createMouseEvent(MouseEvent.MOUSE_CLICKED, undobutton );
		level.setScore(0);
		Move m = new Move(level,tiles, 1);
		level.addMove(m);
		
		resetbutton.doClick();
		assertEquals(level.getScore(),0);
	}
	
	public MouseEvent createMouseEvent(int eventType, JComponent c){
		MouseEvent me = new MouseEvent(c, eventType, System.currentTimeMillis(), 0, 0, 0, 0, false);
		return me;
	}

}
