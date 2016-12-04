package Player.Controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

import Player.Boundaries.GameView;
import Player.Entities.Level;

public class TileController implements MouseListener , MouseMotionListener {

	JLabel tileView;
	Level level;
	boolean visited;
	GameView gameView;
	
	
	public TileController(JLabel tileView , Level l , GameView g) {
		this.tileView = tileView;
		tileView.setOpaque(true);
		level = l;
		this.gameView = g;
		this.visited = false;
		resetState();
	}
	
	private String getValueHeld() {
		return tileView.getText();
	}
	
	public void resetState() {
		tileView.setBackground(Color.white);
		this.visited = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		entered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		pressed();
	}

	private void pressed() {
		System.out.println("Pressed");
		if(!level.getSelectingWord() && !visited) {
			//If we are not currently selecting a word
			tileView.setBackground(Color.green);
			level.setCurrSelectedWord(level.getCurrSelectedWord() + getValueHeld());
			level.setSelectingWord(true);
			visited = true;
		}
	}
	
	private void released() {
		if(level.getSelectingWord()) {
			//Set the last selected word as the word and clear the current word.
			level.setLastSelectedWord(level.getCurrSelectedWord());
			level.setCurrSelectedWord("");
			level.setSelectingWord(false);
			for(int x = 0 ; x < 6 ; x++) {
				for(int y = 0 ; y < 6 ; y++) {
					if(gameView.getTileControllers()[x][y] != null) {
						gameView.getTileControllers()[x][y].resetState();
					}
				}
			}
			System.out.println("Word Selected : " + level.getLastSelectedWord());
		
		}
	}
	
	private void entered(MouseEvent me) {
		if(level.getSelectingWord() && me.getModifiers() == MouseEvent.BUTTON1_MASK && !visited) {
			//If the mouse enters this tile and is pressed
			visited = true;
			tileView.setBackground(Color.green);
			level.setCurrSelectedWord(level.getCurrSelectedWord() + getValueHeld());
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		released();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
