package Boundaries;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameView extends JPanel {

	public void GameView() {
		//Will have to pass GameView some data so it knows what to draw.
	}
	
	public void refresh() {
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		
		//Draw a 6x6 grid.
		for(int x = 1 ; x <= 6 ; x++) {
			for(int y = 1 ; y <= 6 ; y++) {
				int yPos = (y * getHeight())/6;
				int xPos = (x * getWidth())/6;
				
				g.drawLine(0, yPos, getWidth(), yPos);
				g.drawLine(xPos, 0, xPos, getHeight());
			}
		}
		
		
	}
	
}
