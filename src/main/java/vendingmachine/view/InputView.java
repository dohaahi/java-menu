package vendingmachine.view;

import static vendingmachine.validator.CoachValidator.validateInputCoach;
import static vendingmachine.validator.MenuValidator.validateInputMenu;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import vendingmachine.domain.Coaches;
import vendingmachine.domain.InedibleMenu;

public class InputView {
    private static final String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (,로 구분)";
    private static final String MENU_INPUT_MESSAGE =
            lineSeparator("%s(이)가 못 먹는 메뉴를 입력해 주세요.");
    private final InputConverter inputConverter = new InputConverter();

    public Coaches readCoach() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoach(input);

        List<String> names = inputConverter.mapToStringList(input);

        return Coaches.from(names);
    }

    public InedibleMenu readMenu(final String name) {
        System.out.printf(MENU_INPUT_MESSAGE, name);
        String input = readLine();
        validateInputMenu(input);

        List<String> names = inputConverter.mapToStringList(input);

        return InedibleMenu.from(names);
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private static String lineSeparator(final String message) {
        return System.lineSeparator() + message + System.lineSeparator();
    }
}