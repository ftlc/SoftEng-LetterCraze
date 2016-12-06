package Builder.Controllers;


import Builder.Boundaries.*;
import Builder.Entities.Model;
//import Builder.Entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeGameTypeController implements ActionListener{

	LevelView lv;
	Model model;
	
	
	 public ChangeGameTypeController(LevelView lv, Model m) {
	        this.lv = lv;
	        this.model = m;
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
