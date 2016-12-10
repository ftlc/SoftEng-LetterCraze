package Builder.Controllers;

import Builder.Boundaries.*;
import Builder.Entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DeleteLevelController implements ActionListener{

	LevelView lv;
	public DeleteLevelController(LevelView lv){
		this.lv = lv;
	}

	@Override
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
