package Boundaries;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JPanel {
	
	final int MAX_NUM_TILES = 6;
	JLabel tileViews[][];

	public GameView() {
		//Will have to pass GameView some data so it knows what to draw.
		tileViews = new JLabel[MAX_NUM_TILES][MAX_NUM_TILES];
		
		initTiles();
	}
	
	public void initTiles(){
		for(int x = 0; x < 6; x++){
			int tileX = (x * getWidth())/6;
			for(int y = 0; y < 6; y++){
				int tileY = (y * getHeight())/6;
				
				JLabel tile = new JLabel();
				tile.setText("A");
				tile.setBounds(tileX,tileY,50,50);
				tileViews[x][y] = tile;
				
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
				
				g.drawLine(0, yPos, getWidth(), yPos);
				g.drawLine(xPos, 0, xPos, getHeight());
			}
		}
		
		
	}
	
}
