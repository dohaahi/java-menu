package menu.validator;

import static menu.validator.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import menu.domain.Menu;
import menu.exception.IllegalMenuException;

public class MenuValidator {
    private static final int MAX_MENU_COUNT = 3;
    private static final String MENU_REGEX = "^[가-힣]+(,[가-힣]+)*$";
    private static final String INVALID_MENU_DUPLICATE_MESSAGE = "중복된 매뉴가 입력되었습니다.";
    private static final String INVALID_MENU_COUNT_MESSAGE = "못 먹는 메뉴는 3개 미만으로 입력 가능합니다.";
    private static final String INVALID_MENU_CONTAINS_MESSAGE = "메뉴에 존재하지 않는 메뉴명입니다.";

    public static void validateInputMenu(final String input) {
        validateValueIsNullAndEmpty(input);
        validateMenuPatternInput(input);
    }

    private static void validateMenuPatternInput(final String input) {
        if (!Pattern.matches(MENU_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }

    public static void validateMenu(final List<String> menus) {
        validateMenuCount(menus);
        validateMenuDuplication(menus);
        validateMenuMatch(menus);
    }

    private static void validateMenuDuplication(final List<String> menus) {
        long uniqueNumberCount = menus.stream()
                .distinct()
                .count();

        if (menus.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_MENU_DUPLICATE_MESSAGE);
        }
    }

    private static void validateMenuCount(final List<String> menus) {
        if (menus.size() > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_MENU_COUNT_MESSAGE);
        }
    }

    private static void validateMenuMatch(final List<String> menus) {
        boolean hasMatchingMenu = Menu.hasMatchingMenu(menus);

        if (!hasMatchingMenu) {
            throw new IllegalMenuException(INVALID_MENU_CONTAINS_MESSAGE);
        }
    }
}