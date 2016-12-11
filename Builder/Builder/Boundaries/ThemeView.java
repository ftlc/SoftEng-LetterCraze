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

import Builder.Controllers.AcceptThemeController;
import Builder.Controllers.CloseThemeController;
import Builder.Entities.Model;

public class ThemeView extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextPane words;
	private JTextPane letters;
    Model model;
	/**
	 * Create the dialog box
	 */
	public ThemeView(Model m) {
        this.model = m;

        initializePopup();
    }

	public Model getModel() {
		return model;
	}

	public JTextPane getLetters() {
		return letters;
	}

	public JTextPane getWords() {
		return words;
	}

	public String getTheName() {
		return name.getText();
	}
	
	public void setTheName(String theme){
		name.setText(theme);
	}
	
	public void setTheWords (String themeWords){
		words.setText(themeWords);
	}

	void initializePopup() {


		
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

		name = new JTextField();
		name.setBounds(138, 26, 294, 26);
		contentPanel.add(name);
		name.setColumns(10);

		JLabel lblNewLabel = new JLabel("Words");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 76, 87, 16);
		contentPanel.add(lblNewLabel);

		JLabel lblLetterOrder = new JLabel("Letter Order");
		lblLetterOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterOrder.setBounds(6, 235, 87, 16);
		contentPanel.add(lblLetterOrder);

		words = new JTextPane();
		words.setBounds(138, 75, 294, 149);
		contentPanel.add(words);

		letters = new JTextPane();
		letters.setBounds(134, 235, 298, 173);
		contentPanel.add(letters);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new AcceptThemeController(this));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new CloseThemeController(this, model));
				buttonPane.add(cancelButton);
			}
		}
	}
}
