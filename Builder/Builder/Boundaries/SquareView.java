package Builder.Boundaries;

import Builder.Entities.Model;

import javax.swing.*;

/**
 * Created by ftlc on 11/30/16.
 * GUI for the square.
 * Custom class that extends the JToggleButton plus some attributes.
 */
public class SquareView extends JToggleButton {
     Model model;

     /**
      * Constructor method for the SquareView
      * @param m, the model with all the information about the entities.
      */
    public SquareView(Model m) {
        super();
        this.model = m;
    }

    /**
     * 
     * @param name
     */
    public SquareView(String name) {
        super(name);
    }


}

