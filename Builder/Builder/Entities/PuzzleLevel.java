package Builder.Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The subclass puzzle level of the super class level.
 * Created by ftlc on 12/2/16.
 */
public class PuzzleLevel extends Level{
    int maxWords;



    /**
     * constructor of the puzzle level.
     * @param brd the board that belongs to this level
     */
    public PuzzleLevel(Board brd) {
        super(brd);
        this.maxWords = 0;
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

    @Override
    public void writeLevel(String FileName) {
        System.out.println("PuzzleLevel");




        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {
            String content = "P\n-\n";
            content = addStars(content);
            String maxMoves = String.valueOf(getMaxWords());
            content = content + maxMoves + "\n-\n";
            content = addBoard(content);
            content = content + "0";
            System.out.println(content);

            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
