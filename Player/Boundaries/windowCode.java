package Boundaries;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class windowCode {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowCode window = new windowCode();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public windowCode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 400, 400);
		frame.getContentPane().add(panel);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(470, 647, 298, 77);
		frame.getContentPane().add(btnExit);
		
		JButton btnResetBoard = new JButton("Reset Board");
		btnResetBoard.setBounds(470, 359, 298, 77);
		frame.getContentPane().add(btnResetBoard);
		
		JTextArea txtrSelectedWords = new JTextArea();
		txtrSelectedWords.setText("Selected Words\n");
		txtrSelectedWords.setEditable(false);
		txtrSelectedWords.setLineWrap(true);
		txtrSelectedWords.setVisible(true);
		
		JScrollPane scroll = new JScrollPane(txtrSelectedWords);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(12, 464, 407, 263);
		scroll.setVisible(true);
		
		frame.getContentPane().add(scroll);
		
		JTextArea scoreArea = new JTextArea();
		scoreArea.setText("Score: \n\n 0");
		scoreArea.setEditable(false);
		scoreArea.setBounds(470, 37, 298, 70);
		frame.getContentPane().add(scoreArea);
		
		JTextArea starArea = new JTextArea();
		starArea.setText("Stars: \n\n 0");
		starArea.setEditable(false);
		starArea.setBounds(470, 149, 298, 70);
		frame.getContentPane().add(starArea);
		
		JTextArea timerArea = new JTextArea();
		timerArea.setText("(TIMER)");
		timerArea.setEditable(false);
		timerArea.setBounds(470, 257, 298, 70);
		
		frame.getContentPane().add(timerArea);
		frame.setVisible(true);
	}
}
