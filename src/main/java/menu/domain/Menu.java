package menu.domain;

import static menu.validator.MenuValidator.validateMenus;

import java.util.List;

public class Menu {
    private final List<String> menus;

    public Menu(List<String> menus) {
        validateMenus(menus);
        this.menus = menus;
    }

    public static Menu from(final List<String> menus) {
        return new Menu(menus);
    }
}