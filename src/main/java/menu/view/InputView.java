package menu;

import static menu.validator.CoachValidator.validateInputCoach;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coaches;
import menu.view.InputConverter;

public class InputView {
    private static final String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String MENUS_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static Coaches readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoach(input);

        List<String> coachNames = InputConverter.mapToStringList(input);

        return Coaches.from(coachNames);
    }

    public static Coaches readMenu() {
        System.out.println(MENUS_INPUT_MESSAGE);
        String input = readLine();
        validateInputMenuItem(input);

        List<String> menuItems = InputConverter.mapToStringList(input);

        return MenuItem.from();
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}