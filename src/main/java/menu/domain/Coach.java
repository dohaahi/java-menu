package menu.domain;

import static menu.validator.CoachNameValidator.validateCoach;
import static menu.validator.MenuValidator.validateMenu;

import java.util.List;

public record Coach(
        String name,
        List<String> menus
) {
    public Coach(String name, List<String> menus) {
        validateCoach(name);
        validateMenu(menus);

        this.name = name;
        this.menus = menus;
    }
}