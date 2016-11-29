package src.iron;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SplashScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameBuilder = new JLabel("Game Builder");
		lblGameBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameBuilder.setFont(new Font("Lucida Grande", Font.PLAIN, 46));
		lblGameBuilder.setBounds(6, 6, 697, 76);
		contentPane.add(lblGameBuilder);
		
		JLabel lblTeamIron = new JLabel("Team: Iron");
		lblTeamIron.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTeamIron.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamIron.setBounds(6, 141, 697, 25);
		contentPane.add(lblTeamIron);
		
		JTextArea txtrJuanLuis = new JTextArea();
		txtrJuanLuis.setBackground(SystemColor.window);
		txtrJuanLuis.setForeground(Color.BLACK);
		txtrJuanLuis.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtrJuanLuis.setEditable(false);
		txtrJuanLuis.setText("ø Juan Luis Herrero Estrada\n\nø Harutyun Sadoyan\n\nø Christian Scillitoe\n\nø Bradford Bonanno\n\nø Nicolette Vere");
		txtrJuanLuis.setBounds(6, 178, 697, 239);
		contentPane.add(txtrJuanLuis);
		
		JButton btnNewButton = new JButton("Create New Level");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(6, 429, 697, 110);
		contentPane.add(btnNewButton);
	}
}
