package Builder.Controllers;

import Player.Boundaries.LevelView;
import Player.Entities.*;
import Builder.Entities.PuzzleLevel;
import Builder.Entities.LightningLevel;
import Builder.Entities.ThemeLevel;
import Builder.Entities.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class allows the user that when they build a level
 * they can preview it before saving and shipping it.
 */
public class PreviewLevelController implements ActionListener {

    Builder.Boundaries.LevelView lv;
    Builder.Entities.Level level;
    /**
     * Constructor of the controller object.
     * @param lv The levelView that is going to be previewed.
     */
    public PreviewLevelController(Builder.Boundaries.LevelView lv) {
        this.lv = lv;
        this.level = lv.getLvl();
    }


    @Override
	/**
	 * Method that launches a playable level preview.
	 */
    public void actionPerformed(ActionEvent actionEvent) {
    	Level theLevel = new Level();
    	
    	int starOne = Integer.parseInt(lv.getStarText(1).getText());
    	int starTwo = Integer.parseInt(lv.getStarText(2).getText());
    	int starThree = Integer.parseInt(lv.getStarText(3).getText());
    	
    	Star star = new Star(starOne, starTwo, starThree);
    	theLevel.setStar(star);
<<<<<<< HEAD
    	
    	String levelType = level.getLevelType();
    			
    	switch(levelType){
    	case "Puzzle":
    		PuzzleLevel pLevel = (PuzzleLevel)level;
    		PuzzleLogic pLogic = new PuzzleLogic(theLevel);
    		int maxWords = Integer.parseInt(lv.getMaxWordstxt().getText());
    		theLevel.setDictionary(new Dictionary());
    		
    		pLogic.setMaxMoves(maxWords);
    		pLogic.setMovesRemaining(maxWords);
    		
    		char[][] pLayout = getCharLayout(pLevel.getBoard());
    		Player.Entities.Board pb = new Player.Entities.Board(pLayout);
    		theLevel.setBoard(pb);
    		
    		
    		theLevel.setLogic(pLogic);
    		Player.Boundaries.LevelView plv = new Player.Boundaries.LevelView(theLevel);
    		
        	plv.setVisible(true);
    		break;
    	case "Lightning":
    		LightningLevel lLevel = (LightningLevel)level;
    		LightningLogic lLogic = new LightningLogic(theLevel);
    		int timer = Integer.parseInt(lv.getTimeTxt().getText());
    		theLevel.setDictionary(new Dictionary());
    		lLogic.setTimer(timer);
    		
    		char[][] lLayout = getCharLayout(lLevel.getBoard());
    		Player.Entities.Board lb = new Player.Entities.Board(lLayout);
    		theLevel.setBoard(lb);
    		
    		theLevel.setLogic(lLogic);
    		Player.Boundaries.LevelView llv = new Player.Boundaries.LevelView(theLevel);
    		lLogic.startTimer(llv);
        	llv.setVisible(true);
    		break;
    	case "Theme":
    		ThemeLevel tLevel = (ThemeLevel)level;
    		ThemeLogic tLogic = new ThemeLogic(theLevel);
    		
    		ArrayList<String> dict = tLevel.getDictionary().getWords();
    		theLevel.setDictionary(new Player.Entities.Dictionary(true));
    		for(String s: dict)
    			theLevel.getDictionary().addWord(s);
    		
    		tLogic.setThemeName(lv.getTheme().getTheName());
    		
    		
    		char[][] tLayout = tLevel.getDictionary().getLettersChar();
    		Player.Entities.Board tb = new Player.Entities.Board(tLayout, true);
    		theLevel.setBoard(tb);
    		
    		theLevel.setLogic(tLogic);
    		Player.Boundaries.LevelView tlv = new Player.Boundaries.LevelView(theLevel);
        	tlv.setVisible(true);
    		break;
    	}
=======
>>>>>>> 50d0ae7f77421634e7dca49e1c6ae4d85b2d9d58

		String levelType = level.getLevelType();

		switch(levelType){
			case "Puzzle":
				PuzzleLevel pLevel = (PuzzleLevel)level;
				PuzzleLogic pLogic = new PuzzleLogic(theLevel);
				int maxWords = Integer.parseInt(lv.getMaxWordstxt().getText());
				theLevel.setDictionary(new Dictionary());

				pLogic.setMaxMoves(maxWords);
				pLogic.setMovesRemaining(maxWords);

				char[][] pLayout = getCharLayout(pLevel.getBoard());
				Player.Entities.Board pb = new Player.Entities.Board(pLayout);
				theLevel.setBoard(pb);


				theLevel.setLogic(pLogic);
				Player.Boundaries.LevelView plv = new Player.Boundaries.LevelView(theLevel);

				plv.setVisible(true);
				break;
			case "Lightning":
				LightningLevel lLevel = (LightningLevel)level;
				LightningLogic lLogic = new LightningLogic(theLevel);
				int timer = Integer.parseInt(lv.getTimeTxt().getText());
				theLevel.setDictionary(new Dictionary());
				lLogic.setTimer(timer);

				char[][] lLayout = getCharLayout(lLevel.getBoard());
				Player.Entities.Board lb = new Player.Entities.Board(lLayout);
				theLevel.setBoard(lb);

				theLevel.setLogic(lLogic);
				Player.Boundaries.LevelView llv = new Player.Boundaries.LevelView(theLevel);
				lLogic.startTimer(llv);
				llv.setVisible(true);
				break;
			case "Theme":
				ThemeLevel tLevel = (ThemeLevel)level;
				ThemeLogic tLogic = new ThemeLogic(theLevel);

				ArrayList<String> dict = tLevel.getDictionary().getWords();
				theLevel.setDictionary(new Player.Entities.Dictionary(true));
				for(String s: dict)
					theLevel.getDictionary().addWord(s);

				tLogic.setThemeName(lv.getTheme().getName());


				char[][] tLayout = tLevel.getDictionary().getLettersChar();
				Player.Entities.Board tb = new Player.Entities.Board(tLayout, true);
				theLevel.setBoard(tb);

				theLevel.setLogic(tLogic);
				Player.Boundaries.LevelView tlv = new Player.Boundaries.LevelView(theLevel);
				tlv.setVisible(true);
				break;
		}

	}

    /**
     * Get's a 2d array char layout from the board
     * @param board builder board
     * @return char[][] layout
     */
	public char[][] getCharLayout(Builder.Entities.Board board){
		char[][] layout = new char[6][6];
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if(board.getToggleAt(x, y) == true)
					layout[x][y] = 'O';
				else
					layout[x][y] = 'X';
			}
		}
		return layout;
	}
}
