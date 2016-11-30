package Builder.Boundaries;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Builder.Entities.Model;

public class ThemeView extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;


	/**
	 * Create the dialog box
	 */
	public ThemeView(Model m) {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblThemeName = new JLabel("Theme Name");
		lblThemeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemeName.setBounds(6, 31, 87, 16);
		contentPanel.add(lblThemeName);

		textField = new JTextField();
		textField.setBounds(138, 26, 294, 26);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Words");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 76, 87, 16);
		contentPanel.add(lblNewLabel);

		JLabel lblLetterOrder = new JLabel("Letter Order");
		lblLetterOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterOrder.setBounds(6, 235, 87, 16);
		contentPanel.add(lblLetterOrder);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(138, 75, 294, 149);
		contentPanel.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(134, 235, 298, 173);
		contentPanel.add(textPane_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
