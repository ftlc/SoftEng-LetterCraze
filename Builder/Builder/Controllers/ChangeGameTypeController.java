package Builder.Controllers;


import Builder.Boundaries.*;
import Builder.Entities.Board;
import Builder.Entities.Level;
import Builder.Entities.Model;
//import Builder.Entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller used to enable and disable certain GUI objects when the level type
 * is changed.
 * @author JuanLuis.
 */
public class ChangeGameTypeController implements ActionListener{

	LevelView lv;
	Model model;
	Level templvl;

	/**
	 * Constructor that builds the controller object.
	 * @param lv the levelView that changes due to the change in level type.
	 * @param m the model that captures the changes for later.
	 */
	public ChangeGameTypeController(LevelView lv, Model m) {
		this.lv = lv;
		this.model = m;
	}


	/**
	 * Action performed when the comboBox value is changed to either puzzle,
	 * lightning, or theme.
	 */
	public void actionPerformed(ActionEvent actionEvent) {

		String selectedItem = String.valueOf(lv.getComboBox().getSelectedItem());

		if (selectedItem.toString().equals("Puzzle")){
			lv.setPuzzleFields();
			getSharedState(model.getLevel());
			model.setLevelType("Puzzle");
			setSharedState(model.getLevel());
		}

		if (selectedItem.toString().equals("Lightning")){
			lv.setLightningFields();
			getSharedState(model.getLevel());
			model.setLevelType("Lightning");
			setSharedState(model.getLevel());
		}

		if (selectedItem.toString().equals("Theme")){
			lv.setThemeFields();
			getSharedState(model.getLevel());
			model.setLevelType("Theme");
			setSharedState(model.getLevel());
		}


		System.out.println(model.getLvltype());
		System.out.println(model.getLevel().getStarAt(1));
	}


	/**
	 * Method that saves the shared state: the star values and the board into a
	 * temporary level variable.
	 * @param lvl the level from the which the information is collected.
	 */
	void getSharedState(Level lvl) {
		templvl = new Level();

		for(int i = 1; i<=3; i++) {
			templvl.setStarAt(lvl.getStarAt(i), i);
		}

		templvl.setBoard(lvl.getBoard());
	}

	/**
	 * Sets the shared state to the new level type.
	 * @param lvl, the previous level type holding the shared state.
	 */
	void setSharedState(Level lvl) {
		//Set the stars
		for(int i = 1; i<=3; i++) {
			lvl.setStarAt(templvl.getStarAt(i), i);
		}

		//Set the board
		lvl.setBoard(templvl.getBoard());
		//Update the level in levelView
		lv.disposeLvl();
		lv.setLvl(lvl);
	}

}
