package menu.validator;

public class CoachNameValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final String INVALID_XXX_LENGTH_MESSAGE = "이름은 2 ~ 4자 사이로 입력해야 합니다.";

    public static void validateName(final String name) {
        validateNameLength(name);
    }

    private static void validateNameLength(final String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_XXX_LENGTH_MESSAGE);
        }
    }
}