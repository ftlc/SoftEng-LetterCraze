package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class Board {
    Square[] squares;

    public Board(Square[] squares) {
        this.squares = squares;
    }
    public Board()
    {
        this.squares = new Square[36];
    }
}
