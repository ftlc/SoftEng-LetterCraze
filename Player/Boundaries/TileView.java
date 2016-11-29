package Boundaries;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TileView extends JPanel {
	
	JLabel letter;
	
	public TileView(String l, int x, int y){
		super(new BorderLayout());
		
		// Create Label //
		letter = new JLabel();
		letter.setHorizontalAlignment(SwingConstants.CENTER);
		letter.setText(l);
		letter.setLabelFor(this);
		
		// Add Label //
		this.add(letter, BorderLayout.CENTER);
		
		// Set Coordinates //
		this.setBounds(x, y, 50, 50);
				
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		letter.paint(g);
	}
	
	public void refresh(){
		repaint();
	}

}
