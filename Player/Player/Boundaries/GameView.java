package Player.Boundaries;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Player.Controllers.TileController;
import Player.Entities.Level;
import Player.Entities.Tile;

public class GameView extends JPanel {
	
	final int MAX_NUM_TILES = 6;
	JLabel tileViews[][];
	TileController tileControllers[][];
	Level level;
	JFrame parent;
	
	public GameView(JFrame parent, Level theLevel) {
		//Will have to pass GameView some data so it knows what to draw.
		tileViews = new JLabel[MAX_NUM_TILES][MAX_NUM_TILES];
		tileControllers = new TileController[MAX_NUM_TILES][MAX_NUM_TILES];
		this.level = theLevel;
		this.parent = parent;
		
		initTiles();
	}
	
	public void initTiles(){
		Color c = new Color(0,0,0,100);
		Border b = BorderFactory.createLineBorder(Color.BLACK, 1);
		// Height and Width not initialized yet //
		int h = 400;
		int w = 400;
		
		// Spawn Labels for letters //
		for(int x = 0; x < 6; x++){			
			for(int y = 0; y < 6; y++){
				// Tile X and Y 1/6 of Height Apart //
				int tileX = (x * w)/6;
				int tileY = (y * h)/6;
				tileX += 15;
				tileY += 15;
				
				// Generate Label //
				Tile[][] tiles = level.getBoard().getTiles();
				if (tiles[x][y] != null) {
					JLabel tileView = new JLabel("Null", SwingConstants.CENTER);
					tileView.setFont(new Font("TimesRoman", Font.PLAIN, 35));
					tileView.setBounds(tileX, tileY, 60, 60);
					tileView.setVisible(true);
					tileView.setBackground(c);
					tileView.setBorder(b);
					tileView.setText(tiles[x][y].getLetter());
					TileController tc = new TileController(tileView, level, this);
					tileControllers[x][y] = tc;
					parent.add(tileView);
					tileView.addMouseListener(tc);
					tileViews[x][y] = tileView;
				}
				else {
					JLabel tileView = new JLabel("Null", SwingConstants.CENTER);
					tileView.setBounds(tileX, tileY, 60, 60);
					tileView.setVisible(false);
					parent.add(tileView);
					tileViews[x][y] = tileView;
				}
				
			}
		}
	}
	
	public void refresh() {
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		
		//Draw a 6x6 grid.
		for(int x = 1 ; x <= 6 ; x++) {
			int xPos = (x * getWidth())/6;
			
			for(int y = 1 ; y <= 6 ; y++) {
				int yPos = (y * getHeight())/6;
				
				tileViews[x-1][y-1].repaint();
			}
		}
		
		
	}
	
	public void resetBoard() {
		initTiles();
	}
	
	// Getters //
	public JFrame getLevelView() { return parent; }
	public JLabel[][] getTileViews() { return tileViews;}
	public TileController[][] getTileControllers() { return tileControllers; }
	
}
