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
 * Test Theme Logic
 * @author bwbonanno
 *
 */

public class PuzzleTesting extends TestCase {
	
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
	Tile[][] tiles;
	
	/**
	 * Test Launch Puzzle Level
	 */
	public void testLightningLevel(){
		m = new Model();
		menu = new MainMenuView(m);
		assertTrue((menu != null));
		JPanel levelButton = menu.getLevelButton(0);
		JButton button = (JButton)levelButton.getComponent(0);
		button.doClick();		
		
		LevelView level1 = menu.getLevelView(0);
		assertTrue(level1.isVisible());
		assertFalse(menu.isVisible());
		this.levelView = level1;
		this.level = level1.getLevel();
		
		tiles = level.getBoard().getTiles();
		gameView = levelView.getGameView();
		tileViews = gameView.getTileViews();
		tileControllers = gameView.getTileControllers();
	    
	    this.undobutton = levelView.getBtnUndo();	
		this.resetbutton = levelView.getBtnResetBoard();
		this.exitbutton = levelView.getBtnExit();
	}

}