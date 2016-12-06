package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class LightningLevel extends Level {

    int time;

    public LightningLevel(int time) {
        super();
        this.time = time;
    }

    public LightningLevel() {
        super();
        this.time = -1;
    }
    boolean assignTime(int time) {
        this.time = time;
        return true;
    }



}
