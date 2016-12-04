package Builder.Boundaries;

import Builder.Controllers.ToggleSquareController;
import Builder.Entities.Board;
import Builder.Entities.Level;
import Builder.Entities.Model;
import Builder.Entities.Square;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ftlc on 11/30/16.
 */
public class BoardView extends JPanel {
    Model model;
    SquareView[] squares = new SquareView[36];
    GridBagConstraints[] gbs = new GridBagConstraints[36];

    public BoardView () {

        initalizeBoard();
    }
    public BoardView (Model m) {
        this.model = m;




        initalizeBoard();
    }


    void initalizeBoard()
    {
        setBackground(Color.BLACK);
        setBounds(6, 6, 480, 480);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{80, 80, 80, 80, 80, 80, 0};
        gbl_panel.rowHeights = new int[]{80, 80, 80, 80, 80, 80, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gbl_panel);

        initializeSquares();
    }

    void initializeSquares()
    {


        Level l = model.getLevel();
        Board b = l.getBoard();
        for(int i = 0; i < 36; i++)
        {

            Square square = b.getSquareAt(i);
            squares[i] = new SquareView("");
            squares[i].addActionListener(new ToggleSquareController(square, squares[i]));
            gbs[i] = new GridBagConstraints();
            gbs[i].fill = GridBagConstraints.BOTH;
        }


        for(int x = 0; x < 6; x++)
        {
            for(int y = 0; y < 6; y++) {
                int location = 6*x + y;
                gbs[location].gridx = x;
                gbs[location].gridy = y;
                this.add(squares[location], gbs[location]);
            }
        }
    }





}
