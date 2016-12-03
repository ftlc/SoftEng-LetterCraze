package Builder.Entities;

/**
 * Created by ftlc on 12/2/16.
 */
public class ThemeLevel extends Level{
    String name;
    Dictionary dictionary;
    public ThemeLevel(String name) {
        super();
        this.name = name;
    }

    boolean MakeDictionary(Dictionary d) {
        this.dictionary = d;
        return true;
    }
}
