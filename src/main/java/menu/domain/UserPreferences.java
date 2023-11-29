package menu.domain;

import java.util.List;

public class UserPreferences {
    private final List<String> names;
    private final List<String> menus;

    public UserPreferences(List<String> names, List<String> menus) {
        this.names = names;
        this.menus = menus;
    }

    public void recommendMenu() {

    }


}