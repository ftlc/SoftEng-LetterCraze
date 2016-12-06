package Builder.Entities;

import java.util.ArrayList;

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

    @Override
    public String getThemeName() {
        return name;
    }

    @Override
    public void setThemeName(String themeName) {
        this.name = name;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }
}
