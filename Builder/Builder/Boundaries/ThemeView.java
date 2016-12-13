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

/**
 * Dialog box that is opened whenever a theme is built for the 
 * Theme Level
 * @author Juan Luis Herrero Estrada
 */
public class ThemeView extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextPane words;
	private JTextPane letters;
    Model model;
    
	/**
	 * Creates the Dialog box
	 * @param m, model holding the information about the entities.
	 */
	public ThemeView(Model m) {
        this.model = m;
        initializePopup();
    }

	/**
	 * Getter method that returns the model
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Getter method that returns the order of the letters
	 * that the builder wants to set up there board with.
	 * @return the TextPane holding all of the letters.
	 */
	public JTextPane getLetters() {
		return letters;
	}

	/**
	 * Getter method to get all of the theme words for the controllers/entities to use.
	 * @return the TextPane holding the theme words.
	 */
	public JTextPane getWords() {
		return words;
	}

	/**
	 * Getter method for the name of the theme that is built for the level.
	 * @return the name of the theme.
	 */
	public String getTheName() {
		return name.getText();
	}
	
	/**
	 * Setter method that changes the textField contents for the theme name
	 * @param theme, the theme name string that we change to.
	 */
	public void setTheName(String theme){
		name.setText(theme);
	}
	
	/**
	 * Setter method that changes the textField contents for the theme words.
	 * @param themeWords, the theme words that we change to.
	 */
	public void setTheWords (String themeWords){
		words.setText(themeWords);
	}
	
	/**
	 * Setter method that changes the textField contents for the letter order of the theme created.
	 * @param themeLetters, the letters that we change to.
	 */
	public void setTheLetters(String themeLetters){
		letters.setText(themeLetters);
	}

	/**
	 * Method initializes the dialog box with all of its text fields, controllers, buttons
	 * and labels.
	 */
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
		name.setBounds(134, 26, 294, 26);
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
		words.setBounds(134, 75, 294, 149);
		contentPanel.add(words);

		letters = new JTextPane();
		letters.setBounds(134, 235, 294, 149);
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
