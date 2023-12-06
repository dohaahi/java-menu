package menu.view;

import static menu.util.RetryHandler.retryIfFailure;
import static menu.validator.CoachValidator.validateInputCoachNames;
import static menu.validator.MenuValidator.validateInputMenu;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;

public class InputView {
    private static final String MENU_RECOMMEND_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAMES_INPUT_MESSAGE = System.lineSeparator() + "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String MENU_INPUT_MESSAGE =
            System.lineSeparator() + "%s(이)가 못 먹는 메뉴를 입력해 주세요." + System.lineSeparator();

    public static Coaches readCoaches() {
        System.out.println(MENU_RECOMMEND_START_MESSAGE);
        List<Coach> coaches = new ArrayList<>();

        List<String> names = retryIfFailure(InputView::readCoachNames);

        names.forEach(name -> {
            List<String> menu = retryIfFailure(() -> readMenu(name));
            coaches.add(new Coach(name, menu));
        });

        return Coaches.from(coaches);
    }

    private static List<String> readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoachNames(input);

        return InputConverter.mapToStringList(input);
    }

    private static List<String> readMenu(final String name) {
        System.out.printf(MENU_INPUT_MESSAGE, name);
        String input = readLine();
        validateInputMenu(input);

        return InputConverter.mapToStringList(input);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}