package menu.domain;

import static menu.validator.MenuItemValidator.validateMenu;

import java.util.List;

public class InedibleMenu {
    private final List<String> menus;

    private InedibleMenu(List<String> menus) {
        validateMenu(menus);

        this.menus = menus;
    }

    public static InedibleMenu from(final List<String> menus) {
        return new InedibleMenu(menus);
    }

    public boolean hasMatch(final String menu) {
        return menus.stream()
                .anyMatch(menuName -> menuName.equals(menu));
    }
}
