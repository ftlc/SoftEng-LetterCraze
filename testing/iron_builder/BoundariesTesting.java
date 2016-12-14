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
	
	public void setUp(){
		m = new Model();
		menu = new MainMenuView(m);
		
		assertTrue((menu != null));
		JPanel levelButton = menu.getLevelButton(2);
		JButton button = (JButton)levelButton.getComponent(0);
		button.doClick();
		
		LevelView level3 = menu.getLevelView(2);
		assertTrue(level3.isVisible());
		this.levelView = level3;
		this.level = level3.getLevel();
		
		gameView = levelView.getGameView();
		tileViews = gameView.getTileViews();
		tileControllers = gameView.getTileControllers();
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
	
	public MouseEvent createMouseEvent(int eventType, JComponent c){
		MouseEvent me = new MouseEvent(c, eventType, System.currentTimeMillis(), 0, 0, 0, 0, false);
		return me;
	}

}