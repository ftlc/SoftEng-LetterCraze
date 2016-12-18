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


			model.getLevel().writeLevel(FILENAME);


			// no need to close it.
			//bw.close();
			sv.setVisible(false);



	}


}

