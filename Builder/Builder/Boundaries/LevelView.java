package Builder.Boundaries;

import Builder.Controllers.*;
import Builder.Entities.Level;
import Builder.Entities.Model;
import java.io.File;

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
import javax.swing.JFileChooser;
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
 * Main GUI frame in which the majority of the elements
 * such as buttons and fields are placed like save and delete level.
 */
public class LevelView extends JFrame{

	Model model;
	Level lvl;

	private JPanel contentPane;
	private JTextField Star1Text;
	private JTextField Star2Text;
	private JTextField Star3Text;
	private JTextField TimeTxt;
	private JTextField MaxWordstxt;
	private ThemeView themeCreationDialog;
	private SaveLevelView sv;
	private JComboBox comboBox;
	private JButton btnTheme;
	private JButton btnSaveLevel;
	private JFileChooser fileFinder;
	private BoardView panel;
	private JButton btnExit;
	private JButton btnEditLevel;
	private JButton btnPreviewLevel;

	/**
	 * Constructor that initializes the level with all of its buttons and fields.
	 * @param m, passes in the entity object.
	 */
	public LevelView(Model m) //, ThemeView themeCreationDialog)
	{
		this.model = m;
		this.themeCreationDialog = new ThemeView(m);
		this.sv = new SaveLevelView(model, this);

		initializeLevel();

		//Set the level and corresponding controllers
		setLvl(m.getLevel());
	}

	/**
	 * Getter method for the model of the level view.
	 * @return the model
	 */
	public Model getModel(){
		return this.model;
	}
	
	/**
	 * Getter method for the save level view.
	 * @return the save level view.
	 */
	public SaveLevelView getSLView(){
		return sv;
	}
	
	/**
	 * Getter method for the exit button.
	 * @return the exit button.
	 */
	public JButton getExitButton(){
		return btnExit;
	}

	/**
	 * Getter method to obtain the boardView.
	 * @return the boardView in the current level.
	 */
	public BoardView getBoardView(){
		return panel;
	}

	/**
	 * Getter method for the theme button.
	 * @return the theme button of the levelView.
	 */
	public JButton getThemeButton(){
		return btnTheme;
	}
	
	/**
	 * Getter method for the current level, whether is puzzle, lightning, or theme.
	 * @return the current level being built.
	 */
	public Level getLvl() {
		return lvl;
	}

	/**
	 * Getter method for the edit level button.
	 * @return the edit level button.
	 */
	public JButton getEditButton(){
		return btnEditLevel;
	}

	/**
	 * getter method to get the dialog box with its contents when building a theme level.
	 * @return the current dialog box with contents for the theme.
	 */
	public ThemeView getTheme(){
		return themeCreationDialog;
	}

	/**
	 * setter method that deals with saving values (Lightning - time, MaxWords - Puzzle) in the entities .
	 * @param lvl, the current type of level: lightning, theme, puzzle.
	 */
	public void setLvl(Level lvl) {
		this.lvl = lvl;



		btnPreviewLevel.addActionListener(new PreviewLevelController(this));

        Star1Text.addActionListener(new StarValueController(lvl, this, 1));

        Star2Text.addActionListener(new StarValueController(lvl, this, 2));

        Star3Text.addActionListener(new StarValueController(lvl, this, 3));
		// Set the corresponding controllers (Only if correct level type)
		if(lvl.getLevelType().equals("Lightning")) {
			TimeTxt.addActionListener(new AssignTimeController(lvl, this));
		}

		if(lvl.getLevelType().equals("Puzzle")) {
			MaxWordstxt.addActionListener(new AssignNumWordsController(lvl, this));
		}
	}

	public void disposeLvl() {
        btnPreviewLevel.removeActionListener(btnPreviewLevel.getActionListeners()[0]);

	}


	// ----------------------------------------
	/**
	 * Setter method that changes the text of the MaxWords field when needed.
	 * @param input, the number of MaxWords to which we want to change.
	 */
	public void setMaxWords(String input){
		MaxWordstxt.setText(input);
	}
	/**
	 * Setter method that changes the text of the setTime field when needed.
	 * @param input, the total desired for the lightning level.
	 */
	// setter for the time field
	public void setTime(String input){
		TimeTxt.setText(input);
	}

	// -----------------------------------------

	/**
	 * Setter method for the value needed to get one star on the level.
	 * @param input, value for the first star.
	 */
	public void setStarValue1(String input){
		Star1Text.setText(input);
	}

	/**
	 * Setter method for the value needed to get two stars on the level.
	 * @param input, value for the second star.
	 */
	public void setStarValue2(String input){
		Star2Text.setText(input);
	}

	/**
	 * Setter method for the value needed to get three stars on the level.
	 * @param input, value for the third star.
	 */
	public void setStarValue3(String input){
		Star3Text.setText(input);
	}
	// ----------------------------------

	/**
	 * Setter method for the comboBox to which level we are building: PUZZLE.
	 */
	public void setPuzzleComboBox(){
		comboBox.setSelectedItem("Puzzle");
	}

	/**
	 * Setter method for the comboBox to which level we are building: LIGHTNING.
	 */
	public void setLightningComboBox(){
		comboBox.setSelectedItem("Lightning");
	}

	/**
	 * Setter method for the comboBox to which level we are building: THEME.
	 */
	public void setThemeComboBox(){
		comboBox.setSelectedItem("Theme");
	}
	// ---------------------------------
	/**
	 *  getter for the Time text field of lightning level.
	 * @return the current textField holding the value of the total time for level.
	 */
	public JTextField getTimeTxt() {
		return TimeTxt;
	}

	/**
	 * This is a setter for a few fields for when the PUZZLE mode is selected from the comboBox.
	 */
	public void setPuzzleFields(){
		TimeTxt.setEditable(false);
		TimeTxt.setText("");
		MaxWordstxt.setEditable(true);
		btnTheme.setEnabled(false);
	}

	/** 
	 * This is a setter for a few fields for when the LIGHTNING mode is selected from the comboBox.
	 */
	public void setLightningFields(){
		TimeTxt.setEditable(true);
		MaxWordstxt.setEditable(false);
		MaxWordstxt.setText("");
		btnTheme.setEnabled(false);
	}

	/** 
	 * This is a setter for a few fields for when the PUZZLE mode is selected from the comboBox.
	 */
	public void setThemeFields(){
		TimeTxt.setEditable(false);
		TimeTxt.setText("");
		MaxWordstxt.setEditable(false);
		MaxWordstxt.setText("");
		btnTheme.setEnabled(true);
	}

	/**
	 * Getter method for the file finder used for the edit level or delete level.
	 * @return the JFileFinder used to find the desired files.
	 */
	public JFileChooser getFileFinder(){
		return fileFinder;
	}

	/**
	 * Getter method for the textField holding the MaxWords number for Puzzle level.
	 * @return the TextField holding the info pertaining to the MaxWords.
	 */
	public JTextField getMaxWordstxt() {
		return MaxWordstxt;
	}

	/**
	 * Getter method for the JComboBox which allows to change between game types.
	 * @return the JComboBox[Puzzle, Lightning, Theme].
	 */
	public JComboBox getComboBox(){
		return comboBox;
	}

	/**
	 * Getter method for the fields that holds the values for the star fields.
	 * @param num, which star? 1, 2, or 3.
	 * @return the textField holding that star value.
	 */
	public JTextField getStarText(int num) {
		switch (num) {
		case 1:
			return Star1Text;

		case 2:
			return Star2Text;

		case 3:
			return Star3Text;

		}
		return null;
	}

	/**
	 * Getter Method to get the saveLevelButton from the levelView.
	 * @return SaveLevelButton.
	 */
	public JButton getSaveButton(){
		return btnSaveLevel;
	}

	/**
	 * Setter Method to change the file chooser.
	 * @param fileFinder the new JFileChooser to set to.
	 */
	public void setFileFinder(JFileChooser fileFinder) {
		this.fileFinder = fileFinder;
	}

	/**
	 * initializes the levelView with all buttons, labels, fields, comboBoxes, etc
	 * and widgets.
	 */
	void initializeLevel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initializeButtons();
		initializeComboBox();
		initializeTextFields();
		panel = new BoardView(model);
		contentPane.add(panel);

		// initializing the fileFinder
		fileFinder = new JFileChooser(new File("./Levels"));

	}

	/**
	 * Initializes the comboBox with its position, size, and values ["Puzzle", "Lightning", "Theme"].
	 */
	void initializeComboBox(){
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
		comboBox.setBounds(485, 27, 206, 27);
		contentPane.add(comboBox);
		// action listener to have some buttons and fields enabled or disabled
		// when a certain game type is selected.
		comboBox.addActionListener(new ChangeGameTypeController(this, model));
	}



	/**
	 * Initializes all of the textFields with its values, positions, and controllers
	 * to perceive the data input by the user.
	 */
	void initializeTextFields()
	{
		JLabel Star1 = new JLabel("1 Star:");
		Star1.setBounds(499, 168, 61, 16);
		contentPane.add(Star1);

		JLabel Star2 = new JLabel("2 Star:");
		Star2.setBounds(499, 196, 61, 16);
		contentPane.add(Star2);

		JLabel Star3 = new JLabel("3 Star:");
		Star3.setBounds(499, 224, 61, 16);
		contentPane.add(Star3);

		Star1Text = new JTextField();
		Star1Text.setBounds(561, 163, 130, 26);
		contentPane.add(Star1Text);
		Star1Text.setColumns(10);
		Star1Text.setText("0");

		Star2Text = new JTextField();
		Star2Text.setBounds(561, 191, 130, 26);
		contentPane.add(Star2Text);
		Star2Text.setColumns(10);
		Star2Text.setText("0");

		Star3Text = new JTextField();
		Star3Text.setBounds(561, 219, 130, 26);
		contentPane.add(Star3Text);
		Star3Text.setColumns(10);

		Star3Text.setText("0");

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(499, 289, 61, 16);
		contentPane.add(lblTime);

		JLabel lblMaxWords = new JLabel("Max Words:");
		lblMaxWords.setBounds(499, 330, 73, 16);
		contentPane.add(lblMaxWords);


		// Time field and MaxWords field
		TimeTxt = new JTextField();
		TimeTxt.setBounds(561, 284, 130, 26);
		contentPane.add(TimeTxt);
		TimeTxt.setColumns(10);
		TimeTxt.setText("");
		TimeTxt.setEditable(false);

		MaxWordstxt = new JTextField();
		MaxWordstxt.setBounds(584, 325, 107, 26);
		contentPane.add(MaxWordstxt);
		MaxWordstxt.setColumns(10);
		MaxWordstxt.setText("0");
	}

	/**
	 * Initializes all the buttons with their attributes in the levelView,
	 * as well associates actionListeners and controllers with certain buttons.
	 */
	void initializeButtons()
	{
		// -----------------------------------------------------
		btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(5, 493, 142, 33);
		btnSaveLevel.setAlignmentY(0.975f);
		btnSaveLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSaveLevel.addActionListener(new SaveLevelPopupController(this, sv));
		contentPane.add(btnSaveLevel);
		// ---------- SAVE LEVEL BUTTON ------------------------

		// -----------------------------------------------------
		btnEditLevel = new JButton("Edit Level");
		btnEditLevel.setBounds(147, 493, 136, 33);
		btnEditLevel.setAlignmentY(0.975f);
		btnEditLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnEditLevel.addActionListener(new EditLevelController(this, model));
		contentPane.add(btnEditLevel);
		// ---------- EDIT LEVEL BUTTON ------------------------

		// -----------------------------------------------------
		btnPreviewLevel = new JButton("Preview Level");
		btnPreviewLevel.setBounds(283, 493, 171, 33);
		btnPreviewLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnPreviewLevel.setAlignmentY(0.975f);
		contentPane.add(btnPreviewLevel);
		// ---------- PREVIEW LEVEL BUTTON ---------------------

		// -----------------------------------------------------
		JButton btnDeleteLevel = new JButton("Delete Level");
		btnDeleteLevel.setBounds(454, 493, 160, 33);
		btnDeleteLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnDeleteLevel.setAlignmentY(0.975f);
		btnDeleteLevel.addActionListener(new DeleteLevelController(this));
		contentPane.add(btnDeleteLevel);
		// --------------- DELETE LEVEL BUTTON -----------------


		btnTheme = new JButton("Theme");
		btnTheme.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnTheme.setEnabled(false); // Initialize as disabled because first game mode is puzzle
		btnTheme.setBounds(499, 382, 187, 33);
		contentPane.add(btnTheme);

		// This allows the user to click on the theme button leading you to the
		// JDialog to make your theme
		btnTheme.addActionListener(new ThemePopUpController(this, this.themeCreationDialog));



		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnExit.setBounds(498, 427, 193, 40);
		contentPane.add(btnExit);
		// controller used to exit the program when clicked on the exit button
		btnExit.addActionListener(new ExitBuilderController(this));

	}


}
