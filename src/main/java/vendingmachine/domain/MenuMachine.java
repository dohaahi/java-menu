package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.dto.RecommendResultDto;

public class MenuMachine {
    private static final int DAT_LENGTH = 5;
    private final List<RecommendResult> resultList = new ArrayList<>();
    private final List<MenuCategory> menuCategories = new ArrayList<>();

    public void recommend(final CoachHasInedibleMenus coachHasInedibleMenus) {
        List<CoachInedibleMenu> coaches = generateResult(coachHasInedibleMenus);

        for (int dayCount = 0; dayCount < DAT_LENGTH; dayCount++) {
            final MenuCategory pickCategory = recursivePickCategory();
            menuCategories.add(pickCategory);

            recommendMenu(coaches, pickCategory);
        }
    }

    private void recommendMenu(final List<CoachInedibleMenu> coaches, final MenuCategory pickCategory) {
        for (CoachInedibleMenu coach : coaches) {
            String recommendMenu = getRecommendMenu(coach, pickCategory);

            RecommendResult recommendResult = resultList.stream()
                    .filter(result -> result.getCoach().equals(coach.coach()))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("recommend에서 예외 발생"));

            while (isDuplicateMenu(recommendResult, recommendMenu)) {
                recommendMenu = getRecommendMenu(coach, pickCategory);
            }

            recommendResult.addMenu(recommendMenu);
        }
    }

    public RecommendResultDto toRecommendResultDto() {
        String categories = categoryConvertor();

        List<String> results = resultConvertor();

        return new RecommendResultDto(categories, results);
    }

    private String getRecommendMenu(final CoachInedibleMenu coach, final MenuCategory pickCategory) {
        return recursivePickMenu(coach, pickCategory);
    }

    private List<CoachInedibleMenu> generateResult(final CoachHasInedibleMenus coachHasInedibleMenus) {
        List<CoachInedibleMenu> coaches = coachHasInedibleMenus.getCoachInedibleMenus();

        for (CoachInedibleMenu coach : coaches) {
            resultList.add(new RecommendResult(coach.coach()));
        }

        return coaches;
    }

    private String recursivePickMenu(final CoachInedibleMenu coach, final MenuCategory pickCategory) {
        String pickMenu = Menu.pickMenu(pickCategory);

        if (coach.isInedibleMenu(pickMenu)) {
            pickMenu = recursivePickMenu(coach, pickCategory);
        }

        return pickMenu;
    }

    private boolean isDuplicateMenu(final RecommendResult result, final String recommendMenu) {
        return result.getMenus()
                .stream()
                .anyMatch(menu -> menu.equals(recommendMenu));
    }

    private MenuCategory recursivePickCategory() {
        MenuCategory pickCategory = MenuCategory.pickCategory();

        if (isDuplicateCategory(pickCategory)) {
            pickCategory = recursivePickCategory();
        }

        return pickCategory;
    }

    private List<String> resultConvertor() {
        return resultList.stream()
                .map(result ->
                        result.getCoach().getName() + " | " + String.join(" | ", result.getMenus()))
                .toList();
    }

    private String categoryConvertor() {
        return menuCategories.stream()
                .map(MenuCategory::getName)
                .collect(Collectors.joining(" | "));
    }

    private boolean isDuplicateCategory(final MenuCategory pickCategory) {
        return menuCategories.stream()
                .filter(category -> category.equals(pickCategory))
                .count() >= 2;
    }
}