package menu.validator;

import java.util.List;
import java.util.regex.Pattern;
import menu.exception.IllegalMenuException;
import menu.exception.IllegalXXXException;

public class MenuValidator {
    public static final String INVALID_MENUS_DUPLICATE_MESSAGE = "메뉴가 중복되어 입력되었습니다. 다시 입력해 주세요.";
    private static final int MENUS_COUNT = 2;
    private static final String MENU_REGEX = "^[A-zㄱ-힣]+(,[A-zㄱ-힣]+)*$";
    private static final String INVALID_MENUS_COUNT_MESSAGE = "메뉴는 최대 " + MENUS_COUNT + "개 까지 입력 가능합니다. 다시 입력해 주세요.";

    public static void validateInputMenus(final String input) {
        if (!input.isEmpty()) {
            validateMenusPatternInput(input);
        }
    }

    private static void validateMenusPatternInput(final String input) {
        if (!Pattern.matches(MENU_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }

    public static void validateMenus(final List<String> menus) {
        validateMenusDuplication(menus);
        validateMenusCount(menus);
    }

    private static void validateMenusDuplication(final List<String> menus) {
        long uniqueNumberCount = menus.stream().distinct().count();

        if (menus.size() != uniqueNumberCount) {
            throw new IllegalXXXException(INVALID_MENUS_DUPLICATE_MESSAGE);
        }
    }

    private static void validateMenusCount(final List<String> menus) {
        if (menus.size() > MENUS_COUNT) {
            throw new IllegalMenuException(INVALID_MENUS_COUNT_MESSAGE);
        }
    }

    // TODO: 메뉴판에 없는 메뉴 검증
}