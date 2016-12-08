package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

public class EditLevelController implements ActionListener{

	LevelView lv;

	public EditLevelController(LevelView lv){
		this.lv = lv;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(lv.getFileFinder().showOpenDialog(null) == lv.getFileFinder().APPROVE_OPTION){
			java.io.File levelFile = lv.getFileFinder().getSelectedFile();
			try {
				Scanner input = new Scanner(levelFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
