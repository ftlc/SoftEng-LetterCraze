package iron;

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
		lblGameBuilder.setFont(new Font("Lucida Grande", Font.PLAIN, 37));
		lblGameBuilder.setBounds(208, 6, 286, 52);
		contentPane.add(lblGameBuilder);
		
		JLabel lblTeamIron = new JLabel("Team: Iron");
		lblTeamIron.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTeamIron.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeamIron.setBounds(6, 111, 184, 25);
		contentPane.add(lblTeamIron);
		
		JTextArea txtrJuanLuis = new JTextArea();
		txtrJuanLuis.setForeground(Color.BLACK);
		txtrJuanLuis.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrJuanLuis.setEditable(false);
		txtrJuanLuis.setText("ø Juan Luis Herrero Estrada\nø Harutyun Sadoyan\nø Christian Scillitoe\nø Bradford Bonanno\nø Nicolette Vere");
		txtrJuanLuis.setBounds(6, 161, 212, 100);
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
