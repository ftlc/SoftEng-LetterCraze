package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

public class EditLevelController implements ActionListener{

	LevelView lv;
	String buffer;

	public EditLevelController(LevelView lv){
		this.lv = lv;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(lv.getFileFinder().showOpenDialog(null) == lv.getFileFinder().APPROVE_OPTION){
			java.io.File levelFile = lv.getFileFinder().getSelectedFile();
			try {
				Scanner input = new Scanner(levelFile);
				buffer = input.nextLine();

				if (buffer.equals("P")){
					lv.setPuzzleFields();
					lv.setPuzzleComboBox();
				}

				if (buffer.equals("L")){
					lv.setLightningFields();
					lv.setLightningComboBox();
				}

				if (buffer.equals("T")){
					lv.setThemeFields();
					lv.setThemeComboBox();
				}
				
				buffer = input.nextLine(); // skip character "-"
				
				buffer = input.nextLine();
				lv.setStarValue1(buffer);
				buffer = input.nextLine();
				lv.setStarValue2(buffer);
				buffer = input.nextLine();
				lv.setStarValue3(buffer);
				
				System.out.print(buffer);




			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}

}
