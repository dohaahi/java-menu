package menu.validator;

import java.util.List;
import java.util.regex.Pattern;
import menu.domain.Coach;
import menu.exception.IllegalCoachException;
import menu.exception.IllegalXXXException;

public class CoachValidator {
    private static final int MIN_COACHES_LENGTH = 2;
    private static final int MAX_COACHES_LENGTH = 5;
    private static final String COACH_NAMES_REGEX = "^[가-힣]+(,[가-힣]+)*$";
    public static final String INVALID_COACH_NAMES_DUPLICATE_MESSAGE = "이름이 중복되게 입력되었습니다. 다시 입력해 주세요.";
    private static final String INVALID_COACHES_LENGTH_MESSAGE = "코치는 2~5명 사이입니다. 다시 입력해 주세요.";

    public static void validateInputCoaches(final String input) {
        InputValidator.validateValueIsEmpty(input);
        validateCoachPatternInput(input);
    }

    private static void validateCoachPatternInput(final String input) {
        if (!Pattern.matches(COACH_NAMES_REGEX, input)) {
            throw new IllegalCoachException();
        }
    }

    public static void validateCoach(final List<Coach> coaches) {
        validateCoachesDuplication(coaches);
        validateCoachesLength(coaches);
    }

    private static void validateCoachesLength(final List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES_LENGTH || coaches.size() > MAX_COACHES_LENGTH) {
            throw new IllegalCoachException(INVALID_COACHES_LENGTH_MESSAGE);
        }
    }

    private static void validateCoachesDuplication(final List<Coach> coaches) {
        long uniqueNumberCount = coaches.stream().distinct().count();

        if (coaches.size() != uniqueNumberCount) {
            throw new IllegalCoachException(INVALID_COACH_NAMES_DUPLICATE_MESSAGE);
        }
    }
}