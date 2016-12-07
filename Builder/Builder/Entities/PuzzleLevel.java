package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class PuzzleLevel extends Level{
    int maxWords;

    public PuzzleLevel(int maxWords){
        super();
        this.maxWords = maxWords;
    }

    public PuzzleLevel() {
        super();
        this.maxWords = -1;
    }

    @Override
    public String getLevelType() {
        return "Puzzle";
    }

    public int getMaxWords() {
        return maxWords;
    }

    public boolean assignMaxWords(int maxWords) {
        this.maxWords = maxWords;
        return true;
    }


}
