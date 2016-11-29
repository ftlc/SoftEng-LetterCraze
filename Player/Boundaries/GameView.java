package Boundaries;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class GameView extends JPanel {
	
	final int MAX_NUM_TILES = 6;
	JLabel tileViews[][];
	JFrame parent;

	public GameView(JFrame parent) {
		//Will have to pass GameView some data so it knows what to draw.
		tileViews = new JLabel[MAX_NUM_TILES][MAX_NUM_TILES];
		
		Border b = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(b);
		
		this.setLayout(null);
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
				JLabel tile = new JLabel("Null", SwingConstants.CENTER);
				String letter = generateLetter(); // Generates Random Letter //
				tile.setText(letter);
				tile.setBounds(tileX,tileY,60,60);
				tile.setVisible(true);
				tile.setBackground(c);
				tile.setBorder(b);
				parent.add(tile);
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
	// Generate Random Letters //
	public String generateLetter(){
		String returnStr = "0";
		Random random = new Random();
		int num = random.nextInt(26) + 65;
		if(num == 81)
			returnStr = "Qu";
		else
			returnStr = Character.toString((char)num);
		return returnStr;
	}
	
}
