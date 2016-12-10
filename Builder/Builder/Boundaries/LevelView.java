package Builder.Boundaries;

import Builder.Controllers.*;
import Builder.Entities.Level;
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
 * Created by ftlc on 11/29/16.
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
	private JComboBox comboBox;
	private JButton btnTheme;
	private JButton btnSaveLevel;
	private JFileChooser fileFinder;
	private BoardView panel;

	public LevelView(Model m) //, ThemeView themeCreationDialog)
	{
		this.model = m;
		this.themeCreationDialog = new ThemeView(m);

		initializeLevel();

        //Set the level and corresponding controllers
		setLvl(m.getLevel());
	}
	
	public BoardView getBoardView(){
		return panel;
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;

		// Set the corresponding controllers (Only if correct level type)
        if(lvl.getLevelType().equals("Lightning")) {
            TimeTxt.addActionListener(new AssignTimeController(lvl, this));
        }

        if(lvl.getLevelType().equals("Puzzle")) {
            MaxWordstxt.addActionListener(new AssignNumWordsController(lvl, this));
        }
    }
	
	// ----------------------------------------
	// setter for the max words field
	public void setMaxWords(String input){
		MaxWordstxt.setText(input);
	}
	// setter for the time field
	public void setTime(String input){
		TimeTxt.setText(input);
	}
	// -----------------------------------------
	
	// Setters: When Selecting a level to edit
	// Set this fields to the loaded file text.
	public void setStarValue1(String input){
		Star1Text.setText(input);
	}
	public void setStarValue2(String input){
		Star2Text.setText(input);
	}
	public void setStarValue3(String input){
		Star3Text.setText(input);
	}
	// ----------------------------------
	
	// Setters: Change the value of the comboBox 
	public void setPuzzleComboBox(){
		comboBox.setSelectedItem("Puzzle");
	}
	
	public void setLightningComboBox(){
		comboBox.setSelectedItem("Lightning");
	}
	
	public void setThemeComboBox(){
		comboBox.setSelectedItem("Theme");
	}
	// ----------------------------------

    // This is a setter for a few fields for when the PUZZLE mode is selected
    public void setPuzzleFields(){
        TimeTxt.setEditable(false);
        TimeTxt.setText("");
        MaxWordstxt.setEditable(true);
        btnTheme.setEnabled(false);
    }

    // getter for the Time text field
    public JTextField getTimeTxt() {
        return TimeTxt;
    }

    // This is a setter for a few fields for when the LIGHTNING mode is selected
    public void setLightningFields(){
        TimeTxt.setEditable(true);
        MaxWordstxt.setEditable(false);
        MaxWordstxt.setText("");
        btnTheme.setEnabled(false);
    }

    public void setThemeFields(){
        TimeTxt.setEditable(false);
        TimeTxt.setText("");
        MaxWordstxt.setEditable(false);
        MaxWordstxt.setText("");
        btnTheme.setEnabled(true);
    }

    public JFileChooser getFileFinder(){
        return fileFinder;
    }

    public JTextField getMaxWordstxt() {
        return MaxWordstxt;
    }

    public JComboBox getComboBox(){
        return comboBox;
    }

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




    public JButton getSaveButton(){
        return btnSaveLevel;
    }

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
        fileFinder = new JFileChooser();

    }

    void initializeComboBox(){
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
        comboBox.setBounds(485, 27, 206, 27);
        contentPane.add(comboBox);
        // action listener to have some buttons and fields enabled or disabled
        // when a certain game type is selected.
        comboBox.addActionListener(new ChangeGameTypeController(this, model));
    }

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
        Star1Text.addActionListener(new StarValueController(lvl, this, 1));

        Star2Text = new JTextField();
        Star2Text.setBounds(561, 191, 130, 26);
        contentPane.add(Star2Text);
        Star2Text.setColumns(10);
        Star2Text.addActionListener(new StarValueController(lvl, this, 2));

        Star3Text = new JTextField();
        Star3Text.setBounds(561, 219, 130, 26);
        contentPane.add(Star3Text);
        Star3Text.setColumns(10);
        Star3Text.addActionListener(new StarValueController(lvl, this, 3));

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
        TimeTxt.setEditable(false);

        MaxWordstxt = new JTextField();
        MaxWordstxt.setBounds(584, 325, 107, 26);
        contentPane.add(MaxWordstxt);
        MaxWordstxt.setColumns(10);
    }

    void initializeButtons()
    {
        // -----------------------------------------------------
        btnSaveLevel = new JButton("Save Level");
        btnSaveLevel.setBounds(5, 493, 142, 33);
        btnSaveLevel.setAlignmentY(0.975f);
        btnSaveLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnSaveLevel.addActionListener(new SaveLevelController(this, model));
        contentPane.add(btnSaveLevel);
        // ---------- SAVE LEVEL BUTTON ------------------------

        // -----------------------------------------------------
        JButton btnEditLevel= new JButton("Edit Level");
        btnEditLevel.setBounds(147, 493, 136, 33);
        btnEditLevel.setAlignmentY(0.975f);
        btnEditLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnEditLevel.addActionListener(new EditLevelController(this, model));
        contentPane.add(btnEditLevel);
        // ---------- EDIT LEVEL BUTTON ------------------------

        // -----------------------------------------------------
        JButton btnPreviewLevel = new JButton("Preview Level");
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



        JButton btnExit = new JButton("EXIT");
        btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnExit.setBounds(498, 427, 193, 40);
        contentPane.add(btnExit);
        // controller used to exit the program when clicked on the exit button
        btnExit.addActionListener(new ExitBuilderController(this));

    }


}
