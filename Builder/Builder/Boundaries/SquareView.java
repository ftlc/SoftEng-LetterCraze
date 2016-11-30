package Builder.Boundaries;

import Builder.Entities.Model;

import javax.swing.*;

/**
 * Created by ftlc on 11/30/16.
 */
public class SquareView extends JToggleButton {
     Model model;

    public SquareView(Model m) {
        super();
        this.model = m;
    }

    public SquareView(String name) {
        super(name);
    }


}

