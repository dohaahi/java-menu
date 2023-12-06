package menu.view;

import static menu.validator.CoachValidator.validateInputCoachNames;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coaches;

public class InputView {
    private static final String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String MENU_INPUT_MESSAGE = "토미(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static Coaches readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoachNames(input);

        List<String> names = InputConverter.mapToStringList(input);

        return Coaches.from(names);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}