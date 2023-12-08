package vendingmachine.validator;

import static vendingmachine.validator.InputValidator.validateValueIsNullAndEmpty;

import java.util.List;
import java.util.regex.Pattern;
import vendingmachine.domain.Coach;
import vendingmachine.exception.IllegalMenuException;

public class CoachValidator {
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final String DELIMITER = ",";
    private static final String COACH_REGEX = "^[가-힣]+(" + DELIMITER + "[가-힣]+)*$";
    private static final String INVALID_PATTERN_MESSAGE = "유효하지 않은 코치입니다.";
    private static final String INVALID_XXX_DUPLICATE_MESSAGE = "중복된 코치가 입력되었습니다.";
    private static final String INVALID_COACH_COUNT_MESSAGE = "코치는 2~5명으로 입력 가능합니다.";

    public static void validateInputCoach(final String input) {
        validateValueIsNullAndEmpty(input);
        validateCoachPatternInput(input);
    }

    private static void validateCoachPatternInput(final String input) {
        if (!Pattern.matches(COACH_REGEX, input)) {
            throw new IllegalMenuException(INVALID_PATTERN_MESSAGE);
        }
    }

    public static void validateCoach(final List<Coach> coaches) {
        validateCoachDuplication(coaches);
        validateCoachCount(coaches);
    }

    private static void validateCoachDuplication(final List<Coach> coaches) {
        long uniqueNumberCount = coaches.stream().distinct().count();

        if (coaches.size() != uniqueNumberCount) {
            throw new IllegalMenuException(INVALID_XXX_DUPLICATE_MESSAGE);
        }
    }

    private static void validateCoachCount(final List<Coach> coaches) {
        if (coaches.size() < MIN_COACH_COUNT || coaches.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT_MESSAGE);
        }
    }
}
