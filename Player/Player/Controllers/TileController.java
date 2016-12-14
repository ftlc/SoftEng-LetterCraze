package Player.Controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import Player.Boundaries.LevelView;
import Player.Boundaries.GameView;
import Player.Entities.Board;
import Player.Entities.Level;
import Player.Entities.Move;
import Player.Entities.Position;
import Player.Entities.Tile;
import Player.Entities.Word;

public class TileController implements MouseListener , MouseMotionListener {

	JLabel tileView;
	Level level;
	boolean visited;
	Tile tile;
	LevelView levelView;
	GameView gameView;
	Position position;
	
	public TileController(JLabel tileView , Tile tile, Level l , GameView g , Position p) {
		this.tileView = tileView;
		tileView.setOpaque(true);
		this.level = l;
		this.levelView = g.getLevelView();
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
		tile.resetLetter();
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
		if(!level.getSelectingWord() && !visited && !(tileView.getText().isEmpty())) {
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
	
	/**
	 * Plays word if applicable, otherwise resets state of board.
	 */
	private void playWord() {
		
		ArrayList<Tile> lastSelectedWord = level.getLastSelectedWord();
		
		if(lastSelectedWord != null) {
			if(level.playWord()) {
				ArrayList<Word> selectedWords = level.getSelectedWords();
				int index = selectedWords.size() - 1;
				Word theWord = selectedWords.get(index);
				levelView.updateSelectedWords(theWord);
				Board b = level.getBoard();
				Tile[][] t = b.getTiles();
				Move move = new Move(level, t, level.getLogic().scoreToAdd(theWord));
				level.addMove(move);
				for(Tile ti: lastSelectedWord){
					int tileX = ti.getXCoord();
					int tileY = ti.getYCoord();
					TileController tc = gameView.getTileControllers()[tileX][tileY];
					tc.clearTile();
					tc.resetState();
				}				
				
				for(int x = 0 ; x < 6 ; x++) {
					for(int y = 0 ; y < 6 ; y++) {
						if(t[x][y] != null && !t[x][y].getLetter().isEmpty()) {
							Position p = b.canMoveUp(x, y);
							if(p.getX() != x || p.getY() != y) {
								t[p.getX()][p.getY()].setLetter(t[x][y].getLetter());
								t[x][y].resetLetter();
							}
						}
					}
				}
				level.getLogic().regenLetters();
				
				gameView.getLevelView().refresh();
				return;
			}
		}
		
		for(Tile t: lastSelectedWord){
			int tileX = t.getXCoord();
			int tileY = t.getYCoord();
			gameView.getTileControllers()[tileX][tileY].resetState();
		}
		gameView.getLevelView().refresh();
		
	}
	
	private void entered(MouseEvent me) {
		if(level.getSelectingWord() && me.getModifiers() == MouseEvent.BUTTON1_MASK && !visited && isAdjacentPosition() && !(tileView.getText().isEmpty())) {
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
