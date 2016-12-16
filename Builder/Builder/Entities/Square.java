package Builder.Entities;

/**
 * Square entity class that holds the state of the square: selected or deselected.
 * Created by ftlc on 12/2/16.
 */
public class Square {
    boolean toggle;

    /**
     * Constructor of the square object.
     * @param toggle the state of the square: selected or not.
     */
    Square(boolean toggle) {
        this.toggle =  toggle;
    }

    /**
     * Setter method that sets the square to selected or deselected.
     * @return if the state was changed.
     */
    public boolean toggleSquare() {
        setToggle(!isToggle());
        return true; 
    }

    /**
     * Setter method that changes the state of the square.
     * @param toggle true for selected, false for deselected.
     */
    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    /**
     * Getter method to know the state of the square.
     * @return the state of the square.
     */
    public boolean isToggle() {
        return toggle;
    }
}
