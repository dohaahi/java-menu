package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendResult {
    private final String coachName;
    private final List<String> menus = new ArrayList<>();

    public RecommendResult(String coachName) {
        this.coachName = coachName;
    }

    public void addMenu(final String menu) {
        menus.add(menu);
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenus() {
        return menus;
    }
}