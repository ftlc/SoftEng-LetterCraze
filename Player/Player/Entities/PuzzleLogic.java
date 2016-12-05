package Player.Entities;

public class PuzzleLogic extends Logic {
	
	public PuzzleLogic(Level l) {
		super(l);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected int scoreToAdd(Word theWord){
		return theWord.getWordScore();
	}

}
