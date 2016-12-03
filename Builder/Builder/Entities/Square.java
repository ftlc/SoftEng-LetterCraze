package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class Square {
    String character;
    boolean toggle;

    Square(String character, boolean toggle) {
        this.character = character;
        this.toggle =  toggle;
    }

    boolean ToggleSquare() {
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
