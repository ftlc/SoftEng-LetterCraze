package Builder.Controllers;

import Builder.Boundaries.SquareView;
import Builder.Entities.Model;
import Builder.Entities.Square;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ftlc on 12/3/16.
 */
public class ToggleSquareController implements ActionListener{
    Square square;
    SquareView squareView;
    Model model;


    public ToggleSquareController(Square square, SquareView squareView)
    {
        this.square = square;
        this.squareView = squareView;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        square.toggleSquare();
    }
}
