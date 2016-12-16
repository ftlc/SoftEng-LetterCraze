package Builder.Boundaries;

import Builder.Controllers.ToggleSquareController;
import Builder.Entities.Board;
import Builder.Entities.Level;
import Builder.Entities.Model;
import Builder.Entities.Square;

import javax.swing.*;
import java.awt.*;

/**
 * This is the boardView, that holds the gui for the 36 ToggleButtons
 * that represent the different tiles for when building a level.
 */
public class BoardView extends JPanel {
	Model model;
	Board b;
	SquareView[] squares = new SquareView[36];
	GridBagConstraints[] gbs = new GridBagConstraints[36];

	/**
	 * Constructor just initializes the board which sets the position
	 * and state of all of the buttons in the board.
	 */
	public BoardView () {
		initalizeBoard();
	}

	public BoardView (Model m) {
		this.model = m;
		initalizeBoard();
	}

	/**
	 * setter method for the squareViews inside the boardView,
	 * when called it toggles the correct squareView.
	 * @param position, 0-36, which Square do you want to change its state.
	 */
	public void setSquareView(int position){
		squares[position].doClick();
	}

	/**
	 * Initializes the board with a black background and the location/layout
	 * of all the buttons which start out as untoggled.
	 */
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

	/**
	 * Initializes the individual squareViews, and gives them the attribute or action
	 * of being toggled when pressed.
	 */
	public void initializeSquares()
	{
		Level l = model.getLevel();
		b = l.getBoard();
		for(int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				int i = 6 * y + x;
				Square square = b.getSquareAt(i);
				squares[i] = new SquareView("");
				squares[i].addActionListener(new ToggleSquareController(square, squares[i]));
				gbs[i] = new GridBagConstraints();
				gbs[i].fill = GridBagConstraints.BOTH;
			}
		}

		for(int x = 0; x < 6; x++)
		{
			for(int y = 0; y < 6; y++) {
				int location = 6*y + x;
				gbs[location].gridx = x;
				gbs[location].gridy = y;
				this.add(squares[location], gbs[location]);
			}
		}
	}

	public Board getBoard() {
		return b;
	}


}
