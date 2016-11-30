package Builder.Boundaries;

import Builder.Entities.Model;

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
        initaliseBoard();
    }
    public BoardView (Model m) {
        this.model = m;



     //   initialiseSquares();

    }

    void initaliseBoard()
    {

    }

    void initialiseSquares()
    {



        for(int i = 0; i < 36; i++)
        {
            squares[i] = new SquareView("");
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
