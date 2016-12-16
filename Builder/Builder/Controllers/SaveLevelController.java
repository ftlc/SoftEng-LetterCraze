package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller allows the user to save either a puzzle, theme, or lightning level
 * as a txt file to later be played with LetterCraze.
 * @author JuanLuis.
 */
public class SaveLevelController implements ActionListener{
	//private static final String FILENAME = "./Levels/Theme1.txt";
	String FILENAME;
	LevelView lv;
	Model model;
	SaveLevelView sv;
	/**
	 * Constructor of the controller object.
	 * @param lv The levelView from which we access the saveLevelView. 
	 * @param m The model that contains all of the info being saved to the txt file.
	 * @param sv View in which you type the name of the file being saved.
	 */
	public SaveLevelController (LevelView lv, Model m, SaveLevelView sv){
		this.lv = lv;
		this.model = m;
		this.sv = sv;
	}
 
	/**
	 * Method that opens the save level View and places the information
	 * inside the txt file.
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		FILENAME = "./Levels/";
		FILENAME += sv.getTheName();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			String content = "";
			switch (model.getLvltype()) {
			case "Puzzle":
				content = writePuzzle();
				break;
			case "Lightning":
				content = writeLightning();
				break;
			case "Theme":
				content = writeTheme();
				break;
			}

			bw.write(content);

			// no need to close it.
			//bw.close();
			sv.setVisible(false);
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method appends the shared information of the stars
	 * and gives back the correct order and format of them to put in the file.
	 * @param s the string that holds the stars.
	 * @return the string appended to the file for stars part.
	 */
	public String addStars(String s) {
		String star1 = lv.getStarText(1).getText();
		String star2 = lv.getStarText(2).getText();
		String star3 = lv.getStarText(3).getText();

		s = s+star1+"\n"+star2+"\n"+star3+"\n-\n";
		return s;
	}

	/**
	 * Method produces the 6 by 6 board of 0s and Xs indicating
	 * toggled and untoggled squares.
	 * @param s the string that holds the board values.
	 * @return string of 0s Xs representing the game board.
	 */
	public String addBoard(String s) {
		Level lvl = model.getLevel();
		Board brd = lvl.getBoard();

		for(int x = 0; x < 6; x ++)
		{
			for(int y = 0; y < 6; y++)
			{
				int location = 6*x + y;
				if(brd.getSquareAt(location).isToggle())
				{
					s = s+"O";
				}
				else
				{
					s = s+"X";
				}
			}
			s = s + "\n";
		}

		s += "-\n";

		return s;
	}

	/**
	 * Appends all the values to create a file representing
	 * a puzzle level.
	 * @return the puzzle txt in form of a string.
	 */
	public String writePuzzle() {
		String content = "P\n-\n";
		content = addStars(content);
		String maxMoves = lv.getMaxWordstxt().getText();
		content = content + maxMoves + "\n-\n";
		content = addBoard(content);
		content = content + "0";
		System.out.println(content);
		return content;
	}

	/**
	 * Appends all the values to create a file representing
	 * a lightning level.
	 * @return the lightning txt in form of a string.
	 */
	public String writeLightning() {
		String content = "L\n-\n";
		content = addStars(content);
		String time = lv.getTimeTxt().getText();
		content = content + time + "\n-\n";
		content = addBoard(content);
		content = content + "0";
		System.out.println(content);
		return content;
	}

	/**
	 * Appends all the values to create a file representing
	 * a theme level.
	 * @return the theme txt in form of a string.
	 */
	public String writeTheme(){
		String content = "T\n-\n";
		content = addStars(content);
		ThemeLevel themeLevel = (ThemeLevel)model.getLevel();
		String name = themeLevel.getThemeName();
		content+=name+"\n-\n";
		Dictionary dictionary = themeLevel.getDictionary();
		ArrayList<String> words = dictionary.getWords();
		
		for(String w: words)
		{
			content+=w+"\n";
		}
		content+="-\n";

		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 6; y++) {
				content+=dictionary.getLetterAt(x,y);
			}
			content+="\n";
		}

		content+="-\n0";

		return content;
	}

}

