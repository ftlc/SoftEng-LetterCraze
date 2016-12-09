package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveLevelController implements ActionListener{
	
	LevelView lv;
	
	//Constructor
	public SaveLevelController (LevelView lv){
		this.lv = lv;
	}
	
	 public void actionPerformed(ActionEvent actionEvent) {
		 
		 // this just opens the file chooser box
		 if(lv.getFileFinder().showOpenDialog(null) == lv.getFileFinder().APPROVE_OPTION){
				java.io.File levelFile = lv.getFileFinder().getSelectedFile();
				
			}
		 	
	 }
}
