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

		if(lv.getFileFinder().showOpenDialog(null) == lv.getFileFinder().APPROVE_OPTION){

			java.io.File levelFile = lv.getFileFinder().getSelectedFile();
			Path path = Paths.get(levelFile.getAbsolutePath());
			
			try {
				Files.delete(path);
			} catch (NoSuchFileException x) {
				System.err.format("%s: no such" + " file or directory%n", path);
			} catch (DirectoryNotEmptyException x) {
				System.err.format("%s not empty%n", path);
			} catch (IOException x) {
				// File permission problems are caught here.
				System.err.println(x);
			}

		}

	}

}
