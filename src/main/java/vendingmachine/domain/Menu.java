package vendingmachine.domain;

import java.util.List;

public class Menu {
    private final List<String> names;

    private Menu(List<String> names) {
        this.names = names;
    }

    public static Menu from(final List<String> names) {
        return new Menu(names);
    }
}
