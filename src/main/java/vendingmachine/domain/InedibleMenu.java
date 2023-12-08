package vendingmachine.domain;

import static vendingmachine.validator.MenuValidator.validateMenu;

import java.util.List;

public class InedibleMenu {
    private final List<String> names;

    private InedibleMenu(List<String> names) {
        validateMenu(names);

        this.names = names;
    }

    public static InedibleMenu from(final List<String> names) {
        return new InedibleMenu(names);
    }

    public List<String> getMenus() {
        return names;
    }
}