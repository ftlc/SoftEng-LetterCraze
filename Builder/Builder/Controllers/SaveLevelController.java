package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveLevelController implements ActionListener{
	//private static final String FILENAME = "./Levels/Theme1.txt";
	String FILENAME;
	LevelView lv;
	Model model;
	SaveLevelView sv;
	//Constructor
	public SaveLevelController (LevelView lv, Model m, SaveLevelView sv){
		this.lv = lv;
		this.model = m;
		this.sv = sv;
	}

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

	public String addStars(String s) {
		String star1 = lv.getStarText(1).getText();
		String star2 = lv.getStarText(2).getText();
		String star3 = lv.getStarText(3).getText();

		s = s+star1+"\n"+star2+"\n"+star3+"\n-\n";
		return s;
	}

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

		System.out.println(content);
		return content;
	}




}

