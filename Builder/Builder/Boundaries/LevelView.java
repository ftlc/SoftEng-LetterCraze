package Builder.Boundaries;

import Builder.Controllers.ExitBuilderController;
import Builder.Controllers.SplashScreenToLevelController;
import Builder.Controllers.ThemePopUpController;
import Builder.Entities.Model;

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
import java.awt.GridLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * Created by ftlc on 11/29/16.
 */
public class LevelView extends JFrame{

    Model model;


    private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ThemeView themeCreationDialog;

    public LevelView(Model m) //, ThemeView themeCreationDialog)
    {


        this.model = m;
        this.themeCreationDialog = new ThemeView(m);
        

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

		BoardView panel = new BoardView();
		panel.setBackground(Color.BLACK);
		panel.setBounds(6, 6, 480, 480);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 80, 80, 80, 80, 80, 0};
		gbl_panel.rowHeights = new int[]{80, 80, 80, 80, 80, 80, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel.initialiseSquares();




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

		btnNewButton_3.setBounds(499, 382, 187, 33);
		contentPane.add(btnNewButton_3);
		
		// This allows the user to click on the theme button leading you to the 
		// JDialog to make your theme
		btnNewButton_3.addActionListener(new ThemePopUpController(this, this.themeCreationDialog));

		JButton btnNewButton_4 = new JButton("EXIT");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(498, 427, 193, 40);
		contentPane.add(btnNewButton_4);
		
		// controller used to exit the program when clicked on the exit button
		btnNewButton_4.addActionListener(new ExitBuilderController(this));

    }


}
