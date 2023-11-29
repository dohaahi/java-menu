package menu.view;

import static menu.validator.CoachValidator.validateInputCoaches;
import static menu.validator.MenuValidator.validateInputMenus;
import static menu.validator.XXXValidator.validateInputXXX;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coaches;
import menu.domain.Domain;
import menu.domain.Menus;

public class InputView {
    private static final String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요.(,로 구분)";
    private static final String MENU_INPUT_MESSAGE = "코치(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static Coaches readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoaches(input);

        List<String> coaches = InputConverter.mapToStringList(input);

        return Coaches.from(coaches);
    }

    public static Menus readMenus() {
        System.out.println(MENU_INPUT_MESSAGE);
        String input = readLine();
        validateInputMenus(input);

        List<String> menus = InputConverter.mapToStringList(input);

        return Menus.from(menus);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}