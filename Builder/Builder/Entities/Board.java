package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class Board {
    Square[] squares;

 /*   public Board(Square[] squares) {
        this.squares = squares;
        initializeSquares();
    } */
    public Board()
    {
        this.squares = new Square[36];
        initializeSquares();
    }

    void initializeSquares()
    {
        for(int i = 0; i < 36; i++)
        {
            squares[i] = new Square(false);
        }
    }

    public Square[] getSquares() {
        return squares;
    }
    public Square getSquareAt(int i)
    {
        return squares[i];
    }
}
