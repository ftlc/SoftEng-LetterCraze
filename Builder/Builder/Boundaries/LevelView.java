package Builder.Boundaries;

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


    public LevelView(Model m)
    {
        this.model = m;

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
		panel.setBackground(Color.BLACK);
		panel.setBounds(6, 6, 480, 480);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 80, 80, 80, 80, 80, 0};
		gbl_panel.rowHeights = new int[]{80, 80, 80, 80, 80, 80, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		SquareView toggleButton1 = new SquareView("");
		toggleButton1.setForeground(UIManager.getColor("Button.background"));
		toggleButton1.setBackground(UIManager.getColor("Button.background"));
		toggleButton1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton1 = new GridBagConstraints();
		gbc_toggleButton1.fill = GridBagConstraints.BOTH;
		gbc_toggleButton1.gridx = 0;
		gbc_toggleButton1.gridy = 0;
		panel.add(toggleButton1, gbc_toggleButton1);

		SquareView toggleButton2 = new SquareView("");
		GridBagConstraints gbc_toggleButton2 = new GridBagConstraints();
		gbc_toggleButton2.fill = GridBagConstraints.BOTH;
		gbc_toggleButton2.gridx = 1;
		gbc_toggleButton2.gridy = 0;
		panel.add(toggleButton2, gbc_toggleButton2);

		SquareView toggleButton3 = new SquareView("");
		GridBagConstraints gbc_toggleButton3 = new GridBagConstraints();
		gbc_toggleButton3.fill = GridBagConstraints.BOTH;
		gbc_toggleButton3.gridx = 2;
		gbc_toggleButton3.gridy = 0;
		panel.add(toggleButton3, gbc_toggleButton3);

		SquareView toggleButton4 = new SquareView("");
		GridBagConstraints gbc_toggleButton4 = new GridBagConstraints();
		gbc_toggleButton4.fill = GridBagConstraints.BOTH;
		gbc_toggleButton4.gridx = 3;
		gbc_toggleButton4.gridy = 0;
		panel.add(toggleButton4, gbc_toggleButton4);

		SquareView toggleButton5 = new SquareView("");
		GridBagConstraints gbc_toggleButton5 = new GridBagConstraints();
		gbc_toggleButton5.fill = GridBagConstraints.BOTH;
		gbc_toggleButton5.gridx = 4;
		gbc_toggleButton5.gridy = 0;
		panel.add(toggleButton5, gbc_toggleButton5);

		SquareView toggleButton6 = new SquareView("");
		GridBagConstraints gbc_toggleButton6 = new GridBagConstraints();
		gbc_toggleButton6.fill = GridBagConstraints.BOTH;
		gbc_toggleButton6.gridx = 5;
		gbc_toggleButton6.gridy = 0;
		panel.add(toggleButton6, gbc_toggleButton6);

		SquareView toggleButton7 = new SquareView("");
		toggleButton7.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton7 = new GridBagConstraints();
		gbc_toggleButton7.fill = GridBagConstraints.BOTH;
		gbc_toggleButton7.gridx = 0;
		gbc_toggleButton7.gridy = 1;
		panel.add(toggleButton7, gbc_toggleButton7);

		SquareView toggleButton8 = new SquareView("");
		GridBagConstraints gbc_toggleButton8 = new GridBagConstraints();
		gbc_toggleButton8.fill = GridBagConstraints.BOTH;
		gbc_toggleButton8.gridx = 1;
		gbc_toggleButton8.gridy = 1;
		panel.add(toggleButton8, gbc_toggleButton8);

		SquareView toggleButton9 = new SquareView("");
		GridBagConstraints gbc_toggleButton9 = new GridBagConstraints();
		gbc_toggleButton9.fill = GridBagConstraints.BOTH;
		gbc_toggleButton9.gridx = 2;
		gbc_toggleButton9.gridy = 1;
		panel.add(toggleButton9, gbc_toggleButton9);

		SquareView toggleButton10 = new SquareView("");
		GridBagConstraints gbc_toggleButton10 = new GridBagConstraints();
		gbc_toggleButton10.fill = GridBagConstraints.BOTH;
		gbc_toggleButton10.gridx = 3;
		gbc_toggleButton10.gridy = 1;
		panel.add(toggleButton10, gbc_toggleButton10);

		SquareView toggleButton11 = new SquareView("");
		GridBagConstraints gbc_toggleButton11 = new GridBagConstraints();
		gbc_toggleButton11.fill = GridBagConstraints.BOTH;
		gbc_toggleButton11.gridx = 4;
		gbc_toggleButton11.gridy = 1;
		panel.add(toggleButton11, gbc_toggleButton11);

		SquareView toggleButton12 = new SquareView("");
		GridBagConstraints gbc_toggleButton12 = new GridBagConstraints();
		gbc_toggleButton12.fill = GridBagConstraints.BOTH;
		gbc_toggleButton12.gridx = 5;
		gbc_toggleButton12.gridy = 1;
		panel.add(toggleButton12, gbc_toggleButton12);

		SquareView toggleButton13 = new SquareView("");
		toggleButton13.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton13 = new GridBagConstraints();
		gbc_toggleButton13.fill = GridBagConstraints.BOTH;
		gbc_toggleButton13.gridx = 0;
		gbc_toggleButton13.gridy = 2;
		panel.add(toggleButton13, gbc_toggleButton13);

		SquareView toggleButton14 = new SquareView("");
		GridBagConstraints gbc_toggleButton14 = new GridBagConstraints();
		gbc_toggleButton14.fill = GridBagConstraints.BOTH;
		gbc_toggleButton14.gridx = 1;
		gbc_toggleButton14.gridy = 2;
		panel.add(toggleButton14, gbc_toggleButton14);

		SquareView toggleButton15 = new SquareView("");
		GridBagConstraints gbc_toggleButton15 = new GridBagConstraints();
		gbc_toggleButton15.fill = GridBagConstraints.BOTH;
		gbc_toggleButton15.gridx = 2;
		gbc_toggleButton15.gridy = 2;
		panel.add(toggleButton15, gbc_toggleButton15);

		SquareView toggleButton16 = new SquareView("");
		GridBagConstraints gbc_toggleButton16 = new GridBagConstraints();
		gbc_toggleButton16.fill = GridBagConstraints.BOTH;
		gbc_toggleButton16.gridx = 3;
		gbc_toggleButton16.gridy = 2;
		panel.add(toggleButton16, gbc_toggleButton16);

		SquareView toggleButton17 = new SquareView("");
		GridBagConstraints gbc_toggleButton17 = new GridBagConstraints();
		gbc_toggleButton17.fill = GridBagConstraints.BOTH;
		gbc_toggleButton17.gridx = 4;
		gbc_toggleButton17.gridy = 2;
		panel.add(toggleButton17, gbc_toggleButton17);

		SquareView toggleButton18 = new SquareView("");
		GridBagConstraints gbc_toggleButton18 = new GridBagConstraints();
		gbc_toggleButton18.fill = GridBagConstraints.BOTH;
		gbc_toggleButton18.gridx = 5;
		gbc_toggleButton18.gridy = 2;
		panel.add(toggleButton18, gbc_toggleButton18);

		SquareView toggleButton19 = new SquareView("");
		toggleButton19.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_toggleButton19 = new GridBagConstraints();
		gbc_toggleButton19.fill = GridBagConstraints.BOTH;
		gbc_toggleButton19.gridx = 0;
		gbc_toggleButton19.gridy = 3;
		panel.add(toggleButton19, gbc_toggleButton19);

		SquareView toggleButton20 = new SquareView("");
		GridBagConstraints gbc_toggleButton20 = new GridBagConstraints();
		gbc_toggleButton20.fill = GridBagConstraints.BOTH;
		gbc_toggleButton20.gridx = 1;
		gbc_toggleButton20.gridy = 3;
		panel.add(toggleButton20, gbc_toggleButton20);

		SquareView toggleButton21 = new SquareView("");
		GridBagConstraints gbc_toggleButton21 = new GridBagConstraints();
		gbc_toggleButton21.fill = GridBagConstraints.BOTH;
		gbc_toggleButton21.gridx = 2;
		gbc_toggleButton21.gridy = 3;
		panel.add(toggleButton21, gbc_toggleButton21);

		SquareView toggleButton22 = new SquareView("");
		GridBagConstraints gbc_toggleButton22 = new GridBagConstraints();
		gbc_toggleButton22.fill = GridBagConstraints.BOTH;
		gbc_toggleButton22.gridx = 3;
		gbc_toggleButton22.gridy = 3;
		panel.add(toggleButton22, gbc_toggleButton22);

		SquareView toggleButton23 = new SquareView("");
		GridBagConstraints gbc_toggleButton23 = new GridBagConstraints();
		gbc_toggleButton23.fill = GridBagConstraints.BOTH;
		gbc_toggleButton23.gridx = 4;
		gbc_toggleButton23.gridy = 3;
		panel.add(toggleButton23, gbc_toggleButton23);

		SquareView toggleButton24 = new SquareView("");
		GridBagConstraints gbc_toggleButton24 = new GridBagConstraints();
		gbc_toggleButton24.fill = GridBagConstraints.BOTH;
		gbc_toggleButton24.gridx = 5;
		gbc_toggleButton24.gridy = 3;
		panel.add(toggleButton24, gbc_toggleButton24);

		SquareView toggleButton25 = new SquareView("");
		GridBagConstraints gbc_toggleButton25 = new GridBagConstraints();
		gbc_toggleButton25.fill = GridBagConstraints.BOTH;
		gbc_toggleButton25.gridx = 0;
		gbc_toggleButton25.gridy = 4;
		panel.add(toggleButton25, gbc_toggleButton25);

		SquareView toggleButton26 = new SquareView("\n");
		GridBagConstraints gbc_toggleButton26 = new GridBagConstraints();
		gbc_toggleButton26.fill = GridBagConstraints.BOTH;
		gbc_toggleButton26.gridx = 1;
		gbc_toggleButton26.gridy = 4;
		panel.add(toggleButton26, gbc_toggleButton26);

		SquareView toggleButton27 = new SquareView("");
		GridBagConstraints gbc_toggleButton27 = new GridBagConstraints();
		gbc_toggleButton27.fill = GridBagConstraints.BOTH;
		gbc_toggleButton27.gridx = 2;
		gbc_toggleButton27.gridy = 4;
		panel.add(toggleButton27, gbc_toggleButton27);

		SquareView toggleButton28 = new SquareView("");
		GridBagConstraints gbc_toggleButton28 = new GridBagConstraints();
		gbc_toggleButton28.fill = GridBagConstraints.BOTH;
		gbc_toggleButton28.gridx = 3;
		gbc_toggleButton28.gridy = 4;
		panel.add(toggleButton28, gbc_toggleButton28);

		SquareView toggleButton29 = new SquareView("");
		GridBagConstraints gbc_toggleButton29 = new GridBagConstraints();
		gbc_toggleButton29.fill = GridBagConstraints.BOTH;
		gbc_toggleButton29.gridx = 4;
		gbc_toggleButton29.gridy = 4;
		panel.add(toggleButton29, gbc_toggleButton29);

		SquareView toggleButton30 = new SquareView("");
		GridBagConstraints gbc_toggleButton30 = new GridBagConstraints();
		gbc_toggleButton30.fill = GridBagConstraints.BOTH;
		gbc_toggleButton30.gridx = 5;
		gbc_toggleButton30.gridy = 4;
		panel.add(toggleButton30, gbc_toggleButton30);

		SquareView toggleButton31 = new SquareView("");
		GridBagConstraints gbc_toggleButton31 = new GridBagConstraints();
		gbc_toggleButton31.fill = GridBagConstraints.BOTH;
		gbc_toggleButton31.gridx = 0;
		gbc_toggleButton31.gridy = 5;
		panel.add(toggleButton31, gbc_toggleButton31);

		SquareView toggleButton32 = new SquareView("");
		GridBagConstraints gbc_toggleButton32 = new GridBagConstraints();
		gbc_toggleButton32.fill = GridBagConstraints.BOTH;
		gbc_toggleButton32.gridx = 1;
		gbc_toggleButton32.gridy = 5;
		panel.add(toggleButton32, gbc_toggleButton32);

		SquareView toggleButton33 = new SquareView("");
		GridBagConstraints gbc_toggleButton33 = new GridBagConstraints();
		gbc_toggleButton33.fill = GridBagConstraints.BOTH;
		gbc_toggleButton33.gridx = 2;
		gbc_toggleButton33.gridy = 5;
		panel.add(toggleButton33, gbc_toggleButton33);

		SquareView toggleButton34 = new SquareView("");
		GridBagConstraints gbc_toggleButton34 = new GridBagConstraints();
		gbc_toggleButton34.fill = GridBagConstraints.BOTH;
		gbc_toggleButton34.gridx = 3;
		gbc_toggleButton34.gridy = 5;
		panel.add(toggleButton34, gbc_toggleButton34);

		SquareView toggleButton35 = new SquareView("");
		GridBagConstraints gbc_toggleButton35 = new GridBagConstraints();
		gbc_toggleButton35.fill = GridBagConstraints.BOTH;
		gbc_toggleButton35.gridx = 4;
		gbc_toggleButton35.gridy = 5;
		panel.add(toggleButton35, gbc_toggleButton35);

		SquareView toggleButton36 = new SquareView("");
		GridBagConstraints gbc_toggleButton36 = new GridBagConstraints();
		gbc_toggleButton36.fill = GridBagConstraints.BOTH;
		gbc_toggleButton36.gridx = 5;
		gbc_toggleButton36.gridy = 5;
		panel.add(toggleButton36, gbc_toggleButton36);

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
