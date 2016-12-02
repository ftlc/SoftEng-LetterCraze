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
