package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class Square {
    boolean toggle;

    Square(boolean toggle) {
        this.toggle =  toggle;
    }

    public boolean toggleSquare() {
        setToggle(!isToggle());

        return true; 
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public boolean isToggle() {
        return toggle;
    }
}
