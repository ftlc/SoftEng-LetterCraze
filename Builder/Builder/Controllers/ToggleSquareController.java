package Builder.Controllers;

import Builder.Boundaries.SquareView;
import Builder.Entities.Model;
import Builder.Entities.Square;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller manages the change of state between selected and deselected
 * for the squares in the board.
 */
public class ToggleSquareController implements ActionListener{
    Square square;
    SquareView squareView;
    Model model;

    /**
     * Constructor of the controller object.
     * @param square The square entity object that saves the state of the square.
     * @param squareView The GUI item toggled by the builder.
     */
    public ToggleSquareController(Square square, SquareView squareView)
    {
        this.square = square;
        this.squareView = squareView;

    }
    
    /**
     * The action performed of toggling the button and it being reflected
     * in the board.
     */
    public void actionPerformed(ActionEvent actionEvent) {
        square.toggleSquare();
    }
}
