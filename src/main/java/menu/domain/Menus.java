package menu.domain;

import static menu.validator.MenuValidator.validateMenus;

import java.util.List;

public class Menus {
    private final List<String> menus;

    public Menus(List<String> menus) {
        validateMenus(menus);
        this.menus = menus;
    }

    public static Menus from(final List<String> menus) {
        return new Menus(menus);
    }
}
