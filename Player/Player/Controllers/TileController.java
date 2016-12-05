package Player.Controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;


import Player.Boundaries.GameView;
import Player.Entities.Level;
import Player.Entities.Position;
import Player.Entities.Tile;
import Player.Entities.Word;

public class TileController implements MouseListener , MouseMotionListener {

	JLabel tileView;
	Level level;
	boolean visited;
	Tile tile;
	GameView gameView;
	Position position;
	
	public TileController(JLabel tileView , Tile tile, Level l , GameView g , Position p) {
		this.tileView = tileView;
		tileView.setOpaque(true);
		level = l;
		this.position = p;
		this.gameView = g;
		this.tile = tile;
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
	
	public void clearTile() {
		if(this.visited) {
			tileView.setText("");
		}
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
		if(!level.getSelectingWord() && !visited) {
			//If we are not currently selecting a word
			tileView.setBackground(Color.green);
			level.addCurrTile(tile);
			level.setSelectingWord(true);
			level.setLastSelectedPosition(position);
			visited = true;
		}
	}
	
	private boolean isAdjacentPosition() {
		Position temp = level.getLastSelectedPosition();
		
		int tx = temp.getX();
		int px = position.getX();
		int ty = temp.getY();
		int py = position.getY();
		
		if((tx == px + 1 && ty == py) || (tx == px - 1 && ty == py) ||
				(tx == px && ty == py + 1) || (tx == px && ty == py - 1) ||
				(tx == px + 1 && ty == py + 1) || (tx == px + 1 && ty == py - 1) ||
				(tx == px - 1 && ty == py + 1) || (tx == px - 1 && ty == py - 1)) {
			return true;
		}
		
		return false;
	}
	
	private void released() {
		if(level.getSelectingWord()) {
			//Set the last selected word as the word and clear the current word.
			level.setLastSelectedWord(level.getCurrSelectedWord());
			level.setCurrSelectedWord(new ArrayList<Tile>());
			level.setSelectingWord(false);
			
			playWord();
		}
	}
	
	private void playWord() {
		
		ArrayList<Tile> lastSelectedWord = level.getLastSelectedWord();
		
		if(lastSelectedWord != null) {
			String w = "";
			for(Tile t : lastSelectedWord) {
				w += t.getLetter();
			}
			
			if(level.hasWord(w)) {
				Word theWord = new Word(lastSelectedWord);
				level.addScore(theWord.getWordScore());
				level.addWord(theWord);
				
				for(int x = 0 ; x < 6 ; x++) {
					for(int y = 0 ; y < 6 ; y++) {
						if(gameView.getTileControllers()[x][y] != null) {
							gameView.getTileControllers()[x][y].clearTile();
						}
					}
				}
			}
		}
		
		
		for(int x = 0 ; x < 6 ; x++) {
			for(int y = 0 ; y < 6 ; y++) {
				if(gameView.getTileControllers()[x][y] != null) {
					gameView.getTileControllers()[x][y].resetState();
				}
			}
		}
		
	}
	
	private void entered(MouseEvent me) {
		if(level.getSelectingWord() && me.getModifiers() == MouseEvent.BUTTON1_MASK && !visited && isAdjacentPosition()) {
			//If the mouse enters this tile and is pressed
			visited = true;
			level.setLastSelectedPosition(position);
			tileView.setBackground(Color.green);
			level.addCurrTile(tile);
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
