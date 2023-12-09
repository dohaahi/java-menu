package menu.validator;

import static wtc.validator.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import menu.IllegalMenuException;

public class MenuItemValidator {
    private static final int MAX_MENU_COUNT = 2;
    private static final String DELIMITER = ",";
    private static final String MENU_REGEX = "^[가-힣]+(" + DELIMITER + "[가-힣]+)*$";
    private static final String INVALID_MENU_PATTERN_MESSAGE = "중복된 메뉴가 입력되었습니다.";
    private static final String INVALID_MENU_DUPLICATE_MESSAGE = "중복된 메뉴가 입력되었습니다.";
    private static final String INVALID_MENU_COUNT_MESSAGE = "메뉴는 최대 2개까지 입력 가능합니다.";

    public static void validateInputMenu(final String input) {
        if ("".equals(input)) {
            return;
        }

        validateMenuPatternInput(input);
    }

    private static void validateMenuPatternInput(final String input) {
        if (!Pattern.matches(MENU_REGEX, input)) {
            throw new IllegalMenuException(INVALID_MENU_PATTERN_MESSAGE);
        }
    }

    public static void validateMenu(final List<String> menus) {
        validateMenuDuplication(menus);
        validateMenuCount(menus);
    }

    private static void validateMenuCount(final List<String> menus) {
        if (menus.size() > MAX_MENU_COUNT) {
            throw new IllegalMenuException(INVALID_MENU_COUNT_MESSAGE);
        }
    }

    private static void validateMenuDuplication(final List<String> menus) {
        long uniqueNumberCount = menus.stream().distinct().count();

        if (menus.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_MENU_DUPLICATE_MESSAGE);
        }
    }
}