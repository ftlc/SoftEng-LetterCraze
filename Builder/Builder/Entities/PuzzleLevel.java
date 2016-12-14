package Builder.Entities;

/**
 * The subclass puzzle level of the super class level.
 * Created by ftlc on 12/2/16.
 */
public class PuzzleLevel extends Level{
    int maxWords;

    /**
     * Constructor of the puzzle level class.
     */
    public PuzzleLevel(){
        super();
        this.maxWords = -1;
    }

    /**
     * constructor of the puzzle level.
     */
    public PuzzleLevel(Board brd) {
        super(brd);
        this.maxWords = -1;
    }

    /**
     * getter method for the level type.
     * returns puzzle always.
     */
    public String getLevelType() {
        return "Puzzle";
    }

    /**
     * Getter method for the max words attribute.
     * @return value of max words.
     */
    public int getMaxWords() {
        return maxWords;
    }

    /**
     * setter method for the attribute of max words.
     * @param maxWords the value wished to be assigned.
     * @return true if the value was assigned.
     */
    public boolean assignMaxWords(int maxWords) {
        this.maxWords = maxWords;
        return true;
    }


}
