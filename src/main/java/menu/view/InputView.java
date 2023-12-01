package menu.view;

import static menu.util.RetryHandler.retryIfFailure;
import static menu.validator.CoachValidator.validateInputCoaches;
import static menu.validator.MenuValidator.validateInputMenus;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coaches;
import menu.domain.Menu;

public class InputView {
    private static final String START_MENU_RECOMMENDATION_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요.(,로 구분)";
    private static final String MENU_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static Coaches readRecommendElement() {
        System.out.println(START_MENU_RECOMMENDATION_MESSAGE);

        List<String> coachNames = retryIfFailure(InputView::readCoachNames);
        List<Menu> menus = new ArrayList<>();

        coachNames.forEach(coach -> {
            menus.add(retryIfFailure(() -> readMenu(coach)));
        });

        return Coaches.from(
                coachNames,
                menus
        );
    }

    private static List<String> readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoaches(input);

        return InputConverter.mapToStringList(input);
    }

    private static Menu readMenu(final String name) {
        System.out.printf(MENU_INPUT_MESSAGE, name);
        String input = readLine();
        validateInputMenus(input);

        List<String> menus = InputConverter.mapToStringList(input);

        return Menu.from(menus);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}