package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuMachine {
    private static final int WEEKLY_LENGTH = 5;
    private static final String DELIMITER = " | ";
    private final List<MenuCategory> categories = new ArrayList<>();

    public void recommend(final Coaches coaches) {
        for (int day = 0; day < WEEKLY_LENGTH; day++) {
            MenuCategory category = recursivePickCategory();

            coaches.getCoaches()
                    .forEach(coach -> {
                        recursivePickMenu(category, coach);
                    });
        }
    }

    public RecommendResultDto toRecommendResultDto(final Coaches coaches) {
        String categoyString = convertCategoyString();
        List<String> menusString = convertCoachAndMenusString(coaches);

        return new RecommendResultDto(categoyString, menusString);
    }

    private List<String> convertCoachAndMenusString(final Coaches coaches) {
        List<String> coachAndMenusStrings = new ArrayList<>();

        coaches.getCoaches()
                .stream()
                .toList()
                .forEach(coach -> {
                    String menuString = coach.getName() + DELIMITER +
                            String.join(DELIMITER, coach.getRecommendMenus());

                    coachAndMenusStrings.add(menuString);
                });

        return coachAndMenusStrings;
    }

    private String convertCategoyString() {
        return categories.stream()
                .map(MenuCategory::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private MenuCategory recursivePickCategory() {
        MenuCategory pickCategory = MenuCategory.pickCategory();

        while (isHaveSameTwoCategory(pickCategory)) {
            pickCategory = MenuCategory.pickCategory();
        }

        categories.add(pickCategory);

        return pickCategory;
    }

    private boolean isHaveSameTwoCategory(final MenuCategory pickCategory) {
        return categories.stream()
                .filter(category -> category.equals(pickCategory))
                .count() > 1;
    }

    private void recursivePickMenu(final MenuCategory category, final Coach coach) {
        String pickMenu = Menu.pickMenu(category);

        while (!coach.isAppropriate(pickMenu)) {
            pickMenu = Menu.pickMenu(category);
        }

        coach.addRecommendMenu(pickMenu);
    }
}