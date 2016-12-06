package Builder.Controllers;


import Builder.Boundaries.*;
//import Builder.Entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeGameTypeController implements ActionListener{

	LevelView lv;
	String currentSelection;
	
	
	 public ChangeGameTypeController(LevelView lv, String currentSelection) {
	        this.lv = lv;
	        this.currentSelection = currentSelection;
	 }

	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		if (currentSelection.toString().equals("Puzzle")){
			lv.setPuzzleFields();
		}
		
		if (currentSelection.toString().equals("Lightning")){
			lv.setLightningFields();
		}
		
		if (currentSelection.toString().equals("Theme")){
			lv.setThemeFields();
		}
		
		
	}

	
	
}
