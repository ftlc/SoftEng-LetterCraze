package Builder.Boundaries;

import Builder.Entities.Model;

/**
 * Created by ftlc on 11/30/16.
 */
public class BoardView {
    Model model;
    SquareView[] squares = new SquareView[36];
    public BoardView (Model m) {
        this.model = m;
    }



}
