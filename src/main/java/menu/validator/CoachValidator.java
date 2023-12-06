package menu.validator;

import static menu.validator.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import menu.exception.IllegalMenuException;

public class CoachValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final String COACH_NAMES_REGEX = "^[가-힣]+(,[가-힣]+)*$";
    private static final String INVALID_NAME_LENGTH_MESSAGE = "코치 이름은 2 ~ 4자 사이로 입력 가능합니다.";
    private static final String INVALID_COACH_COUNT_MESSAGE = "코치는 2 ~ 5명 사이로 입력 가능합니다.";
    private static final String INVALID_COACH_NAME_DUPLICATE = "코치 이름이 중복되어 입력되었습니다. ";

    public static void validateInputCoachNames(final String input) {
        validateValueIsNullAndEmpty(input);
        validateCoachNamesPatternInput(input);
    }

    private static void validateCoachNamesPatternInput(final String input) {
        if (!Pattern.matches(COACH_NAMES_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }

    public static void validateCoach(final List<String> names) {
        validateNameLength(names);
        validateCoachCount(names);
        validateCoachNamesDuplication(names);
    }

    private static void validateNameLength(final List<String> names) {
        boolean invalidNameLength = names.stream()
                .filter(name -> name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
                .count() > 1;

        if (invalidNameLength) {
            throw new IllegalMenuException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private static void validateCoachCount(final List<String> names) {
        if (names.size() < MIN_COACH_COUNT || names.size() > MAX_COACH_COUNT) {
            throw new IllegalMenuException(INVALID_COACH_COUNT_MESSAGE);
        }
    }

    private static void validateCoachNamesDuplication(final List<String> names) {
        long uniqueNumberCount = names.stream().distinct().count();

        if (names.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_COACH_NAME_DUPLICATE);
        }
    }
}