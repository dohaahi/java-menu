package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.dto.RecommendResultDto;

public class MenuMachine {
    private static final int DAT_LENGTH = 5;
    private final List<RecommendResult> resultList = new ArrayList<>();

    public void recommend(final CoachHasInedibleMenus coachHasInedibleMenus) {
        List<CoachInedibleMenu> coaches = generateResult(coachHasInedibleMenus);

        for (int dayCount = 0; dayCount < DAT_LENGTH; dayCount++) {
            for (RecommendResult result : resultList) {
                result.addMenu(getRecommendMenu(coaches));
            }
        }
    }

    private String getRecommendMenu(final List<CoachInedibleMenu> coaches) {
        String recommendMenu = "";

        for (CoachInedibleMenu coach : coaches) {
            MenuCategory pickCategory = MenuCategory.pickCategory();

            recommendMenu = reversePickMenu(coach, pickCategory);
        }

        return recommendMenu;
    }

    private List<CoachInedibleMenu> generateResult(final CoachHasInedibleMenus coachHasInedibleMenus) {
        List<CoachInedibleMenu> coaches = coachHasInedibleMenus.getCoachInedibleMenus();

        for (CoachInedibleMenu coach : coaches) {
            resultList.add(new RecommendResult(coach.name()));
        }

        return coaches;
    }


    private String reversePickMenu(final CoachInedibleMenu coach, final MenuCategory pickCategory) {
        String pickMenu = Menu.pickMenu(pickCategory);

        if (!isAppropriateMenu(coach, pickMenu)) {
            pickMenu = reversePickMenu(coach, pickCategory);
        }

        return pickMenu;
    }

    private boolean isAppropriateMenu(final CoachInedibleMenu coach, final String pickMenu) {
        // 코치가 못 먹는 메뉴인지
        if (coach.isInedibleMenu(pickMenu)) {
            return false;
        }

        // 이미 추천한 메뉴인지
        // 카테고리가 이미 2번이나 추천되었는지

        return true;
    }

    public RecommendResultDto toRecommendResultDto() {
        List<String> results = resultList.stream()
                .map(result -> result.getCoachName() + " | " + String.join(" | ", result.getMenus()))
                .toList();

        return new RecommendResultDto(results);
    }
}
