package Builder.Controllers;


import Builder.Boundaries.*;
//import Builder.Entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeGameTypeController implements ActionListener{

	LevelView lv;
	
	
	 public ChangeGameTypeController(LevelView lv) {
	        this.lv = lv;
	 }

	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		String selectedItem = String.valueOf(lv.getComboBox().getSelectedItem());
		
		if (selectedItem.toString().equals("Puzzle")){
			lv.setPuzzleFields();
		}
		
		if (selectedItem.toString().equals("Lightning")){
			lv.setLightningFields();
		}
		
		if (selectedItem.toString().equals("Theme")){
			lv.setThemeFields();
		}
		
		
	}

	
	
}
