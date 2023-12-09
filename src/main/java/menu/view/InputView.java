package menu.view;

import static menu.validator.CoachValidator.validateInputCoach;
import static menu.validator.MenuItemValidator.validateInputMenu;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coaches;
import menu.domain.InedibleMenu;

public class InputView {
    private static final String COACH_NAMES_INPUT_MESSAGE = System.lineSeparator() + "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String MENUS_INPUT_MESSAGE =
            System.lineSeparator() + "%s(이)가 못 먹는 메뉴를 입력해 주세요." + System.lineSeparator();

    public Coaches readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoach(input);

        List<String> coachNames = InputConverter.mapToStringList(input);

        return Coaches.from(coachNames);
    }

    public InedibleMenu readMenu(final String name) {
        System.out.printf(MENUS_INPUT_MESSAGE, name);
        String input = readLine();
        validateInputMenu(input);

        List<String> menus = InputConverter.mapToStringList(input);

        return InedibleMenu.from(menus);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}