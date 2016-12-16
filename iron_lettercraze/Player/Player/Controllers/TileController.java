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
	
	/**
	 * Constructor for the TileController class
	 * @param tileView the JLabel that this tileController is in charge of
	 * @param tile the Tile that this tileController is in charge of
	 * @param l the Level that this tileController is held within
	 * @param g the gameView that this tileController is held within
	 * @param p the position in the 6x6 matrix of this specific tile
	 */
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
	
	/**
	 * Used for debugging purposes
	 * @return text held within the tileView
	 */
	private String getValueHeld() {
		return tileView.getText();
	}
	
	/**
	 * Resets the state of the tile by setting
	 * its background color to white and its 'visited'
	 * boolean to false. This means the tile can be
	 * selected again when selecting another word.
	 */
	public void resetState() {
		tileView.setBackground(Color.white);
		this.visited = false;
	}
	
	/**
	 * Clears all the data within the tile, setting
	 * its contents to ""
	 */
	public void clearTile() {
		tile.resetLetter();
	}
	
	/**
	 * Required method of mouselistener
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Required method of mouselistener
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		entered(arg0);
	}

	/**
	 * Required method of mouselistener
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Required method of mouselistener
	 * also invokes the pressed() function.
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		pressed();
	}

	/**
	 * Selects this tile as the first tile of a word,
	 * assuming that there is currently no word being selected.
	 */
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
	
	/**
	 * Determines if the current tile is adjacent to the last selected tile
	 * @return true if the current tile is adjacent (including diagonals)
	 * @return false if the current tile is not adjacent (including diagonals)
	 */
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
	
	/**
	 * Plays the selected word, assuming that there is currently a word
	 * being selected.
	 */
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
	
	/**
	 * Adds the tile to the word if the mouse is down and we are
	 * currently selecting a word.
	 * @param me mouseEvent data
	 */
	private void entered(MouseEvent me) {
		if(level.getSelectingWord() && me.getModifiers() == MouseEvent.BUTTON1_MASK && !visited && isAdjacentPosition() && !(tileView.getText().isEmpty())) {
			//If the mouse enters this tile and is pressed
			visited = true;
			level.setLastSelectedPosition(position);
			tileView.setBackground(Color.green);
			level.addCurrTile(tile);
		}
	}
	
	/**
	 * Required method of mouseListener
	 * also calls the released() function
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		released();
	}

	/**
	 * Required method of mouselistener
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	/**
	 * Required method of mouselistener
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
