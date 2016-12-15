package Player;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Player.Main;
import Player.Boundaries.*;
import Player.Controllers.*;
import Player.Entities.*;
import junit.framework.TestCase;

/**
 * Testing for the Player Entities.
 * @author bwbonanno
 *
 */

public class EntitiesTesting extends TestCase{
	
	Model m;
	MainMenuView menu;

	LevelView levelView3;

	Level three;
	Position p;
	Dictionary d;
	Star s;
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
		this.levelView3 = level3;
		this.three = level3.getLevel();
		
		gameView = levelView3.getGameView();
		tileViews = gameView.getTileViews();
		tileControllers = gameView.getTileControllers();
		
		this.d = three.getDictionary();
		this.s = three.getStar();
		this.p = three.getLastSelectedPosition();

	}
	
	public void tearDown(){
		m = null;
		menu.dispose();

	}
	
	public void testLevel(){
		assertTrue(three != null);
		assertEquals(three.getLevelNum(), 2);
		Tile t1 = new Tile(1,0,"c");
		Tile t2 = new Tile(1,0,"a");
		Tile t3 = new Tile(1,0,"t");
		three.addCurrTile(t1);
		three.addCurrTile(t2);
		three.addCurrTile(t3);
		assertEquals(three.getCurrSelectedWord(), "cat");
		
	}
}
	