package menu.validator;

import static menu.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import menu.IllegalMenuException;

public class CoachValidator {
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final String DELIMITER = ",";
    private static final String COACH_REGEX = "^[가-힣]+(" + DELIMITER + "[가-힣]+)*$";
    private static final String INVALID_COACH_PATTERN_MESSAGE = "중복된 이름이 입력되었습니다.";
    private static final String INVALID_COACH_DUPLICATE_MESSAGE = "중복된 이름이 입력되었습니다.";
    private static final String INVALID_COACH_LENGTH_MESSAGE = "코치는 2 ~ 5명 사이로 입력가능합니다.";

    public static void validateInputCoach(final String input) {
        validateValueIsNullAndEmpty(input);
        validateCoachPatternInput(input);
    }

    private static void validateCoachPatternInput(final String input) {
        if (!Pattern.matches(COACH_REGEX, input)) {
            throw new IllegalMenuException(INVALID_COACH_PATTERN_MESSAGE);
        }
    }

    public static void validateCoach(final List<String> coachNames) {
        validateCoachDuplication(coachNames);
        validateCoachCount(coachNames);
    }

    private static void validateCoachDuplication(final List<String> coachNames) {
        long uniqueNumberCount = coachNames.stream()
                .distinct()
                .count();

        if (coachNames.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_COACH_DUPLICATE_MESSAGE);
        }
    }

    private static void validateCoachCount(final List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_COUNT || coachNames.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(INVALID_COACH_LENGTH_MESSAGE);
        }
    }
}