package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendResult {
    private final Coach coach;
    private final List<String> menus = new ArrayList<>();

    public RecommendResult(Coach coach) {
        this.coach = coach;
    }

    public void addMenu(final String menu) {
        menus.add(menu);
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getMenus() {
        return menus;
    }
}