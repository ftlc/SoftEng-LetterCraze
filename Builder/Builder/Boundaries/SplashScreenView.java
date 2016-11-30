package Builder.Boundaries;

import Builder.Controllers.SplashScreenToLevelController;
import Builder.Entities.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 11/29/16.
 */
public class SplashScreenView extends JFrame {

    private JPanel contentPane;
    LevelView lvl;

    public SplashScreenView (Model m, LevelView lvl) {
        this.lvl = lvl;



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
		btnNewButton.addActionListener(new SplashScreenToLevelController(this, this.lvl));

		btnNewButton.setBounds(6, 429, 697, 110);
		contentPane.add(btnNewButton);
    }


}
