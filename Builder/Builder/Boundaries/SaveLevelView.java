package Builder.Boundaries;

import Builder.Controllers.AcceptThemeController;
import Builder.Controllers.CloseSaveLevelController;
import Builder.Controllers.SaveLevelController;
import Builder.Entities.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Dialog Box that is opened whenever we click on the save button for a level.
 */
public class SaveLevelView extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private Model model;
	private LevelView lv;
	private JButton okButton;
	
	/**
	 * Creates the dialog box object.
	 */
	public SaveLevelView(Model m, LevelView lv) {
		this.model = m;
		this.lv = lv;
		initializePopup();
	}
	
	/**
	 * Getter method of the okButton of the SaveLevelView.
	 * @return the OKButton.
	 */
	public JButton getOKButton(){
		return okButton;
	}

	/**
	 * Getter method for the model so that the values can be saved to a txt.
	 * @return the model.
	 */
	public Model getModel() {
		return model;
	}

	public String getTheName() {
		return name.getText();
	}

	public void setTheName(String theme){
		name.setText(theme);
	}


	/**
	 * This method intializes the saveLevel Dialog box with its size, position
	 * and text field that reads in the name of the file we want to save.
	 */
	void initializePopup() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblThemeName = new JLabel("Level Name");
		lblThemeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemeName.setBounds(6, 31, 87, 16);
		contentPanel.add(lblThemeName);

		name = new JTextField();
		name.setBounds(134, 26, 294, 26);
		contentPanel.add(name);
		name.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new SaveLevelController(lv, model, this));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new CloseSaveLevelController(this));
				buttonPane.add(cancelButton);
			}
		}
	}
}
