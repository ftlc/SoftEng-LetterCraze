package iron;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ThemePopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemePopUp dialog = new ThemePopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemePopUp() {
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 71, 294, 152);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLetterOrder = new JLabel("Letter Order");
		lblLetterOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterOrder.setBounds(6, 235, 87, 16);
		contentPanel.add(lblLetterOrder);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(138, 235, 294, 154);
		contentPanel.add(textArea);
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
