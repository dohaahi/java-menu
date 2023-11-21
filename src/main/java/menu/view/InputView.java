package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.util.FunctionalInterfaces.retryIfFailure;
import static menu.validator.MenuValidator.inputMenuValidate;
import static menu.validator.NameValidator.inputNameValidate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.UserPreferences;

public class InputView {
    public static final String NAME_DELIMITER = ",";
    public static final String MENU_DELIMITER = ",";
    public static final String START_GAME_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String REQUEST_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (" + NAME_DELIMITER + " 로 구분)";
    public static final String REQUEST_CANNOT_EAT_MENU_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public UserPreferences readUserPreferences() {
        List<String> names = retryIfFailure(this::readNames);
        List<String> menus = retryIfFailure(this::readCanNotEatMenus);

        return new UserPreferences(names, menus);
    }

    private List<String> readNames() {
        System.out.println(START_GAME_MESSAGE);
        System.out.println(REQUEST_NAME_MESSAGE);

        String input = readLine().trim();
        inputNameValidate(input);

        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    private List<String> readCanNotEatMenus() {
        System.out.println(REQUEST_CANNOT_EAT_MENU_MESSAGE);

        String input = readLine().trim();
        inputMenuValidate(input);

        return Arrays.stream(input.split(MENU_DELIMITER))
                .collect(Collectors.toList());
    }
}