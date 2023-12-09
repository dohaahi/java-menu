package menu.domain;

import static menu.validator.CoachNameValidator.validateName;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private InedibleMenu menus;
    private List<String> recommendMenus = new ArrayList<>();

    private Coach(String name) {
        validateName(name);

        this.name = name;
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }

    public void addInedibleMenu(final InedibleMenu menus) {
        this.menus = menus;
    }

    public void addRecommendMenu(final String menu) {
        recommendMenus.add(menu);
    }

    public boolean isAppropriate(final String menu) {
        return !isInedibleMenu(menu) && !isDuplication(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }

    // 못 먹는 메뉴랑 일치하는지
    // 일치하면 true 반환
    private boolean isInedibleMenu(final String menu) {
        return menus.hasMatch(menu);
    }

    // 중복되는 메뉴가 존재하는지
    // 중복되면 true 반환
    private boolean isDuplication(final String menu) {
        return recommendMenus.stream()
                .anyMatch(recommendMenu -> recommendMenu.equals(menu));
    }
}