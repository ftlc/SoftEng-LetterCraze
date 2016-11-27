package iron;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(5, 493, 142, 33);
		btnSaveLevel.setAlignmentY(0.975f);
		btnSaveLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnSaveLevel);
		
		JButton btnNewButton = new JButton("Edit Level");
		btnNewButton.setBounds(147, 493, 136, 33);
		btnNewButton.setAlignmentY(0.975f);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Preview Level");
		btnNewButton_1.setBounds(283, 493, 171, 33);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.setAlignmentY(0.975f);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Level");
		btnNewButton_2.setBounds(454, 493, 160, 33);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_2.setAlignmentY(0.975f);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 480, 480);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 80, 80, 80, 80, 80, 0};
		gbl_panel.rowHeights = new int[]{80, 80, 80, 80, 80, 80, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JToggleButton toggleButton = new JToggleButton("");
		toggleButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton = new GridBagConstraints();
		gbc_toggleButton.fill = GridBagConstraints.BOTH;
		gbc_toggleButton.gridx = 0;
		gbc_toggleButton.gridy = 0;
		panel.add(toggleButton, gbc_toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("");
		GridBagConstraints gbc_toggleButton_1 = new GridBagConstraints();
		gbc_toggleButton_1.fill = GridBagConstraints.BOTH;
		gbc_toggleButton_1.gridx = 1;
		gbc_toggleButton_1.gridy = 0;
		panel.add(toggleButton_1, gbc_toggleButton_1);
		
		JToggleButton toggleButton_2 = new JToggleButton("");
		GridBagConstraints gbc_toggleButton_2 = new GridBagConstraints();
		gbc_toggleButton_2.gridx = 2;
		gbc_toggleButton_2.gridy = 0;
		panel.add(toggleButton_2, gbc_toggleButton_2);
		
		JToggleButton toggleButton_3 = new JToggleButton("4");
		GridBagConstraints gbc_toggleButton_3 = new GridBagConstraints();
		gbc_toggleButton_3.gridx = 3;
		gbc_toggleButton_3.gridy = 0;
		panel.add(toggleButton_3, gbc_toggleButton_3);
		
		JToggleButton toggleButton_4 = new JToggleButton("5");
		GridBagConstraints gbc_toggleButton_4 = new GridBagConstraints();
		gbc_toggleButton_4.gridx = 4;
		gbc_toggleButton_4.gridy = 0;
		panel.add(toggleButton_4, gbc_toggleButton_4);
		
		JToggleButton toggleButton_5 = new JToggleButton("6");
		GridBagConstraints gbc_toggleButton_5 = new GridBagConstraints();
		gbc_toggleButton_5.gridx = 5;
		gbc_toggleButton_5.gridy = 0;
		panel.add(toggleButton_5, gbc_toggleButton_5);
		
		JToggleButton toggleButton_6 = new JToggleButton("");
		toggleButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton_6 = new GridBagConstraints();
		gbc_toggleButton_6.fill = GridBagConstraints.BOTH;
		gbc_toggleButton_6.gridx = 0;
		gbc_toggleButton_6.gridy = 1;
		panel.add(toggleButton_6, gbc_toggleButton_6);
		
		JToggleButton toggleButton_7 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_7 = new GridBagConstraints();
		gbc_toggleButton_7.gridx = 1;
		gbc_toggleButton_7.gridy = 1;
		panel.add(toggleButton_7, gbc_toggleButton_7);
		
		JToggleButton toggleButton_8 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_8 = new GridBagConstraints();
		gbc_toggleButton_8.gridx = 2;
		gbc_toggleButton_8.gridy = 1;
		panel.add(toggleButton_8, gbc_toggleButton_8);
		
		JToggleButton toggleButton_9 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_9 = new GridBagConstraints();
		gbc_toggleButton_9.gridx = 3;
		gbc_toggleButton_9.gridy = 1;
		panel.add(toggleButton_9, gbc_toggleButton_9);
		
		JToggleButton toggleButton_10 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_10 = new GridBagConstraints();
		gbc_toggleButton_10.gridx = 4;
		gbc_toggleButton_10.gridy = 1;
		panel.add(toggleButton_10, gbc_toggleButton_10);
		
		JToggleButton toggleButton_11 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_11 = new GridBagConstraints();
		gbc_toggleButton_11.gridx = 5;
		gbc_toggleButton_11.gridy = 1;
		panel.add(toggleButton_11, gbc_toggleButton_11);
		
		JToggleButton toggleButton_12 = new JToggleButton("7");
		toggleButton_12.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton_12 = new GridBagConstraints();
		gbc_toggleButton_12.gridx = 0;
		gbc_toggleButton_12.gridy = 2;
		panel.add(toggleButton_12, gbc_toggleButton_12);
		
		JToggleButton toggleButton_13 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_13 = new GridBagConstraints();
		gbc_toggleButton_13.gridx = 1;
		gbc_toggleButton_13.gridy = 2;
		panel.add(toggleButton_13, gbc_toggleButton_13);
		
		JToggleButton toggleButton_14 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_14 = new GridBagConstraints();
		gbc_toggleButton_14.gridx = 2;
		gbc_toggleButton_14.gridy = 2;
		panel.add(toggleButton_14, gbc_toggleButton_14);
		
		JToggleButton toggleButton_15 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_15 = new GridBagConstraints();
		gbc_toggleButton_15.gridx = 3;
		gbc_toggleButton_15.gridy = 2;
		panel.add(toggleButton_15, gbc_toggleButton_15);
		
		JToggleButton toggleButton_16 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_16 = new GridBagConstraints();
		gbc_toggleButton_16.gridx = 4;
		gbc_toggleButton_16.gridy = 2;
		panel.add(toggleButton_16, gbc_toggleButton_16);
		
		JToggleButton toggleButton_17 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_17 = new GridBagConstraints();
		gbc_toggleButton_17.gridx = 5;
		gbc_toggleButton_17.gridy = 2;
		panel.add(toggleButton_17, gbc_toggleButton_17);
		
		JToggleButton toggleButton_18 = new JToggleButton("7");
		toggleButton_18.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton_18 = new GridBagConstraints();
		gbc_toggleButton_18.gridx = 0;
		gbc_toggleButton_18.gridy = 3;
		panel.add(toggleButton_18, gbc_toggleButton_18);
		
		JToggleButton toggleButton_19 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_19 = new GridBagConstraints();
		gbc_toggleButton_19.gridx = 1;
		gbc_toggleButton_19.gridy = 3;
		panel.add(toggleButton_19, gbc_toggleButton_19);
		
		JToggleButton toggleButton_20 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_20 = new GridBagConstraints();
		gbc_toggleButton_20.gridx = 2;
		gbc_toggleButton_20.gridy = 3;
		panel.add(toggleButton_20, gbc_toggleButton_20);
		
		JToggleButton toggleButton_21 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_21 = new GridBagConstraints();
		gbc_toggleButton_21.gridx = 3;
		gbc_toggleButton_21.gridy = 3;
		panel.add(toggleButton_21, gbc_toggleButton_21);
		
		JToggleButton toggleButton_22 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_22 = new GridBagConstraints();
		gbc_toggleButton_22.gridx = 4;
		gbc_toggleButton_22.gridy = 3;
		panel.add(toggleButton_22, gbc_toggleButton_22);
		
		JToggleButton toggleButton_23 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_23 = new GridBagConstraints();
		gbc_toggleButton_23.gridx = 5;
		gbc_toggleButton_23.gridy = 3;
		panel.add(toggleButton_23, gbc_toggleButton_23);
		
		JToggleButton toggleButton_24 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_24 = new GridBagConstraints();
		gbc_toggleButton_24.gridx = 0;
		gbc_toggleButton_24.gridy = 4;
		panel.add(toggleButton_24, gbc_toggleButton_24);
		
		JToggleButton toggleButton_25 = new JToggleButton("\n");
		GridBagConstraints gbc_toggleButton_25 = new GridBagConstraints();
		gbc_toggleButton_25.gridx = 1;
		gbc_toggleButton_25.gridy = 4;
		panel.add(toggleButton_25, gbc_toggleButton_25);
		
		JToggleButton toggleButton_28 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_28 = new GridBagConstraints();
		gbc_toggleButton_28.gridx = 2;
		gbc_toggleButton_28.gridy = 4;
		panel.add(toggleButton_28, gbc_toggleButton_28);
		
		JToggleButton toggleButton_30 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_30 = new GridBagConstraints();
		gbc_toggleButton_30.gridx = 3;
		gbc_toggleButton_30.gridy = 4;
		panel.add(toggleButton_30, gbc_toggleButton_30);
		
		JToggleButton toggleButton_32 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_32 = new GridBagConstraints();
		gbc_toggleButton_32.gridx = 4;
		gbc_toggleButton_32.gridy = 4;
		panel.add(toggleButton_32, gbc_toggleButton_32);
		
		JToggleButton toggleButton_34 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_34 = new GridBagConstraints();
		gbc_toggleButton_34.gridx = 5;
		gbc_toggleButton_34.gridy = 4;
		panel.add(toggleButton_34, gbc_toggleButton_34);
		
		JToggleButton toggleButton_26 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_26 = new GridBagConstraints();
		gbc_toggleButton_26.gridx = 0;
		gbc_toggleButton_26.gridy = 5;
		panel.add(toggleButton_26, gbc_toggleButton_26);
		
		JToggleButton toggleButton_27 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_27 = new GridBagConstraints();
		gbc_toggleButton_27.gridx = 1;
		gbc_toggleButton_27.gridy = 5;
		panel.add(toggleButton_27, gbc_toggleButton_27);
		
		JToggleButton toggleButton_29 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_29 = new GridBagConstraints();
		gbc_toggleButton_29.gridx = 2;
		gbc_toggleButton_29.gridy = 5;
		panel.add(toggleButton_29, gbc_toggleButton_29);
		
		JToggleButton toggleButton_31 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_31 = new GridBagConstraints();
		gbc_toggleButton_31.gridx = 3;
		gbc_toggleButton_31.gridy = 5;
		panel.add(toggleButton_31, gbc_toggleButton_31);
		
		JToggleButton toggleButton_33 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_33 = new GridBagConstraints();
		gbc_toggleButton_33.gridx = 4;
		gbc_toggleButton_33.gridy = 5;
		panel.add(toggleButton_33, gbc_toggleButton_33);
		
		JToggleButton toggleButton_35 = new JToggleButton("7");
		GridBagConstraints gbc_toggleButton_35 = new GridBagConstraints();
		gbc_toggleButton_35.gridx = 5;
		gbc_toggleButton_35.gridy = 5;
		panel.add(toggleButton_35, gbc_toggleButton_35);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
		comboBox.setBounds(499, 27, 206, 27);
		contentPane.add(comboBox);
		
		JLabel lblStar = new JLabel("1 Star:");
		lblStar.setBounds(499, 168, 61, 16);
		contentPane.add(lblStar);
		
		JLabel lblStar_1 = new JLabel("2 Star:");
		lblStar_1.setBounds(499, 196, 61, 16);
		contentPane.add(lblStar_1);
		
		JLabel lblStar_2 = new JLabel("3 Star:");
		lblStar_2.setBounds(499, 224, 61, 16);
		contentPane.add(lblStar_2);
		
		textField = new JTextField();
		textField.setBounds(561, 163, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(561, 191, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(561, 219, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(499, 289, 61, 16);
		contentPane.add(lblTime);
		
		JLabel lblMaxWords = new JLabel("Max Words:");
		lblMaxWords.setBounds(499, 330, 73, 16);
		contentPane.add(lblMaxWords);
		
		textField_3 = new JTextField();
		textField_3.setBounds(561, 284, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(584, 325, 107, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Theme");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(499, 382, 187, 33);
		contentPane.add(btnNewButton_3);
	}
}
