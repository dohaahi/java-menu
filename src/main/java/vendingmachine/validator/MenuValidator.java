package vendingmachine.validator;

import static vendingmachine.validator.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import vendingmachine.exception.IllegalMenuException;

public class MenuValidator {
    private static final int MAX_MENU_COUNT = 2;
    private static final String DELIMITER = ",";
    private static final String MENU_REGEX = "^[가-힣]+(" + DELIMITER + "[가-힣]+)*$";
    private static final String INVALID_PATTERN_MESSAGE = "유효하지 않은 메뉴입니다.";
    private static final String INVALID_MENU_DUPLICATE_MESSAGE = "중복된 메뉴를 입력했습니다.";
    private static final String INVALID_MENU_LENGTH_MESSAGE = "메뉴는 최대 2개 까지 입력가능합니다.";

    public static void validateInputMenu(final String input) {
        validateMenuPatternInput(input);
    }

    private static void validateMenuPatternInput(final String input) {
        if ("".equals(input)) {
            return;
        }

        if (!Pattern.matches(MENU_REGEX, input)) {
            throw new IllegalMenuException(INVALID_PATTERN_MESSAGE);
        }
    }

    public static void validateXXX(final List<Integer> numbers) {
        validateMenuDuplication(numbers);
        validateMenuCount(numbers);
        // TODO: 메뉴에 없는 메뉴인지 검증
    }

    private static void validateMenuDuplication(final List<Integer> numbers) {
        long uniqueNumberCount = numbers.stream().distinct().count();

        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_MENU_DUPLICATE_MESSAGE);
        }
    }

    private static void validateMenuCount(final List<Integer> numbers) {
        if (numbers.size() > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_MENU_LENGTH_MESSAGE);
        }
    }
}