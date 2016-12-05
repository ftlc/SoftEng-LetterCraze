package Builder.Controllers;


import Builder.Boundaries.*;
//import Builder.Entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeGameTypeController implements ActionListener{

	LevelView lv;
	JComboBox comboBox;
	
	
	 public ChangeGameTypeController(LevelView lv, JComboBox comboBox) {
	        this.lv = lv;
	        this.comboBox = comboBox;
	    }

	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		
	}

	
	
}
