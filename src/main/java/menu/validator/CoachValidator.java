package menu.validator;

import static menu.validator.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import menu.domain.Coach;
import menu.exception.IllegalMenuException;

public class CoachValidator {
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final String COACH_NAMES_REGEX = "^[가-힣]+(,[가-힣]+)*$";
    private static final String INVALID_COACH_COUNT_MESSAGE = "코치는 2 ~ 5명 사이로 입력 가능합니다.";
    private static final String INVALID_COACH_NAME_DUPLICATE = "코치 이름이 중복되어 입력되었습니다.";

    public static void validateInputCoachNames(final String input) {
        validateValueIsNullAndEmpty(input);
        validateCoachNamesPatternInput(input);
    }

    private static void validateCoachNamesPatternInput(final String input) {
        if (!Pattern.matches(COACH_NAMES_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }

    public static void validateCoach(final List<Coach> coaches) {
        validateCoachCount(coaches);
        validateCoachNamesDuplication(coaches);
    }

    private static void validateCoachCount(final List<Coach> coaches) {
        if (coaches.size() < MIN_COACH_COUNT || coaches.size() > MAX_COACH_COUNT) {
            throw new IllegalMenuException(INVALID_COACH_COUNT_MESSAGE);
        }
    }

    private static void validateCoachNamesDuplication(final List<Coach> coaches) {
        long uniqueNumberCount = coaches.stream()
                .distinct()
                .count();

        if (coaches.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_COACH_NAME_DUPLICATE);
        }
    }
}