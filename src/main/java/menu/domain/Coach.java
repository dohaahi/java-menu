package menu.domain;

import java.awt.Menu;
import java.util.List;

public class Coach {
    private final String name;
    private  List<Menu> menus;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }
}
