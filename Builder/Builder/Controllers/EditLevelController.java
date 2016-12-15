package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;
import Builder.Entities.Dictionary;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Loads a level using the file finder and places the values of that level
 * in their respective GUI fields.
 * @author JuanLuis.
 */
public class EditLevelController implements ActionListener{

	LevelView lv;
	String buffer;
	Model model;

	/**
	 * Constructor of the controller object.
	 * @param lv the levelView from which the FileFinder is opened.
	 * @param model The model in which the edited information stored to.
	 */
	public EditLevelController(LevelView lv, Model model){
		this.lv = lv;
		this.model = model;
	}

	/**
	 * Method loads the file, through the file finder and loads the stars, time, maxWords,
	 * board, theme name, theme words, and theme letters to their respective fields.
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if(lv.getFileFinder().showOpenDialog(null) == lv.getFileFinder().APPROVE_OPTION){
			java.io.File levelFile = lv.getFileFinder().getSelectedFile();
			try {
				Scanner input = new Scanner(levelFile);
				buffer = input.nextLine();

				if (buffer.equals("P")){
					model.setLevelType("Puzzle");
					PuzzleLevel pl = (PuzzleLevel)model.getLevel();
					lv.setPuzzleFields();
					lv.setPuzzleComboBox();
					getStars(input, pl);
					// --------------------------------------------
					getMaxWords(input, pl);
					// --------------------------------------------
					buffer = input.nextLine(); // skip character "-"
					getBoard(input);
				}

				if (buffer.equals("L")){
					model.setLevelType("Lightning");
					LightningLevel ll = (LightningLevel)model.getLevel();
					lv.setLightningFields();
					lv.setLightningComboBox();
					getStars(input, ll);
					// --------------------------------------------
					getTime(input, ll);
					// --------------------------------------------
					buffer = input.nextLine(); // skip character "-"
					getBoard(input);
				}

				if (buffer.equals("T")){
					model.setLevelType("Theme");
					ThemeLevel tl = (ThemeLevel)model.getLevel();
					lv.setThemeFields();
					lv.setThemeComboBox();
					getStars(input, tl);
					buffer = input.nextLine(); // skip character "-" 
					// ---------------------------------------
					// Now the Theme
					buffer = input.nextLine();
					lv.getTheme().setTheName(buffer);
					tl.setThemeName(buffer);
					buffer = input.nextLine(); // skip character "-"
					// ----------------------------------------
					// Now the words
					getAndSetWords(input);
					// ----------------------------------------
					// Finally the board and letter order.
					themeBoard(input);
				}


			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
	}

	/** this method reads from file and sets the board in boardview 
	 * and the letter order in the ThemeView.
	 * @param input the scanner used to read the input file.
	 */
	public void themeBoard(Scanner input){

		Character[][] letters = new Character[6][6];
		String stringTemp = "";
		char temp;
		BoardView loadBV = lv.getBoardView();
		for (int i = 0; i < 36; i++){

			if (i % 6 == 0){
				int row = i/6;
				buffer = input.nextLine();
				for(int j = 0; j<6; j++)
				{
					letters[row][j] = buffer.charAt(j);
				}

				stringTemp = stringTemp + buffer + "\n";
				lv.getTheme().setTheLetters(stringTemp);

			}

			temp = buffer.charAt(i%6);
			if (temp != '\"'){
				loadBV.setSquareView(i);
			}
		}
		ThemeLevel tl = (ThemeLevel)lv.getModel().getLevel();
		Dictionary d = tl.getDictionary();
		d.placeLetters(letters);

	}

	/** This method retrieves the words from file
	 *  and puts them in the themeView.
	 * @param input the scanner used to read the input file.
	 */
	public void getAndSetWords(Scanner input){

		ThemeLevel tl = (ThemeLevel)lv.getModel().getLevel();
		String temp = "";
		buffer = input.nextLine();
		while(!buffer.contains("-")){

			temp = temp + buffer + "\n";
			Dictionary d = tl.getDictionary();
			d.addWord(buffer);

			buffer = input.nextLine();
		}
		lv.getTheme().setTheWords(temp);
	}

	/**
	 * This method captures the board for the lightning and theme levels.
	 * @param input the scanner used to read the input file.
	 */
	public void getBoard(Scanner input){
		char temp;
		BoardView loadBV = lv.getBoardView();
		Board testONLY = loadBV.getBoard();

		Board brd = model.getLevel().getBoard();

		for (int i = 0; i < 36; i++){

			if (i % 6 == 0){
				buffer = input.nextLine();
			}

			temp = buffer.charAt(i%6);

			Square tmpSquare = brd.getSquareAt(i);
			if (temp == 'O'){
				loadBV.setSquareView(i);
				tmpSquare.setToggle(true);
			}
			else
			{
				tmpSquare.setToggle(false);
			}
		}
	}

	/**
	 * method reads 3 numbers in three different lines capturing
	 * the values needed for 1 star, 2 stars, and 3 stars.
	 * @param input the scanner used to read the input file.
	 * @param lvl entity class to which the values are saved.
	 */
	public void getStars(Scanner input, Level lvl){
		buffer = input.nextLine(); // skip character "-"
		buffer = input.nextLine();
		lv.setStarValue1(buffer);
		int star1 = strToI(buffer);
		lvl.setStarAt(star1, 1);

		buffer = input.nextLine();
		lv.setStarValue2(buffer);
		int star2 = strToI(buffer);
		lvl.setStarAt(star2, 2);

		buffer = input.nextLine();
		lv.setStarValue3(buffer);
		int star3 = strToI(buffer);
		lvl.setStarAt(star3, 3);
	}

	/**
	 * Method reads from file for the puzzle level the number of max words
	 * and sets that field in the GUI.
	 * @param input the scanner used to read the input file.
	 * @param lvl the entity class to which the value is saved.
	 */
	public void getMaxWords(Scanner input, PuzzleLevel lvl) {
		buffer = input.nextLine(); // skip character "-"
		buffer = input.nextLine(); // get the max words
		lv.setMaxWords(buffer);
		int maxWords = strToI(buffer);
		lvl.assignMaxWords(maxWords);
	}


	/**
	 * Methods from file for the lightning level the total countdown time
	 * and sets it to that field in the GUI.
	 * @param input the scanner used to read the input file.
	 * @param lvl the entity class to which the value is saved.
	 */
	public void getTime(Scanner input, LightningLevel lvl) {
		buffer = input.nextLine(); // skip character "-"
		buffer = input.nextLine(); // get the time
		lv.setTime(buffer);
		int time = strToI(buffer);
		lvl.assignTime(time);
	}

	/**
	 * helper method that converts string values to
	 * their numeric equivalents.
	 * @param str the string that we want to convert to int.
	 * @return the result int obtained from the input string.
	 */
	public int strToI(String str) {
		try {
			int contents = Integer.parseInt(str);
			return contents;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}


}
