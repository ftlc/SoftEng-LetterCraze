package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

public class EditLevelController implements ActionListener{

	LevelView lv;
	String buffer;
	Model model;

	public EditLevelController(LevelView lv, Model model){
		this.lv = lv;
		this.model = model;
	}

	@Override
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
				}


			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
	}
	

   

	// this method captures the board
	public void getBoard(Scanner input){
		
		BoardView loadBV = lv.getBoardView();
		
		for (int i = 0; i < 36; i++){
			buffer = input.next();
			//if (buffer.equals("O")){
				loadBV.setSquareView(i);
			//}
		}
	}

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

	public void getMaxWords(Scanner input, PuzzleLevel lvl) {
		buffer = input.nextLine(); // skip character "-"
		buffer = input.nextLine(); // get the max words
		lv.setMaxWords(buffer);
		int maxWords = strToI(buffer);
		lvl.assignMaxWords(maxWords);
	}


	public void getTime(Scanner input, LightningLevel lvl) {
		buffer = input.nextLine(); // skip character "-"
		buffer = input.nextLine(); // get the time
		lv.setTime(buffer);
		int time = strToI(buffer);
		lvl.assignTime(time);
	}

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