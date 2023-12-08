package vendingmachine.domain;

import static vendingmachine.validator.MenuValidator.validateMenu;

import java.util.List;

public class CoachMenu {
    private final List<String> names;

    private CoachMenu(List<String> names) {
        validateMenu(names);

        this.names = names;
    }

    public static CoachMenu from(final List<String> names) {
        return new CoachMenu(names);
    }
}