package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Controller opens a search box to find and delete the desired file.
 * @author JuanLuis.
 */
public class DeleteLevelController implements ActionListener{

	LevelView lv;
	/**
	 * Constructor of the controller object.
	 * @param lv the levelView from which the FileFinder is from. 
	 */
	public DeleteLevelController(LevelView lv){
		this.lv = lv;
	}

	/**
	 * When Delete Level button clicked, opens the file finder
	 * and deletes file at that path.
	 */
	public void actionPerformed(ActionEvent actionEvent) {

		// opens file finder
		if(lv.getFileFinder().showOpenDialog(null) == lv.getFileFinder().APPROVE_OPTION){

			// gets absolute string path of the file in question
			java.io.File levelFile = lv.getFileFinder().getSelectedFile();
			
			// gets path from string.
			Path path = Paths.get(levelFile.getAbsolutePath());
			
			// try-catch statement: Checks if have permissions, directory not empty, and file exists
			try {
				Files.delete(path);
			} catch (NoSuchFileException e) {
				System.out.println("no such file");
			} catch (DirectoryNotEmptyException e) {
				System.out.println("directory not empty");
			} catch (IOException e) {
				// File permissions
				System.out.println("don't have permissions");
			}

		}

	}

}
