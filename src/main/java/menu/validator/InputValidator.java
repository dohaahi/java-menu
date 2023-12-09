package menu;

import wtc.exception.IllegalXXXException;

public class InputValidator {
    private static final String INPUT_VALUE_MESSAGE = "값을 입력해주세요.";

    public static void validateValueIsNullAndEmpty(final String input) {
        validateNullInput(input);
        validateEmptyInput(input);
    }

    private static void validateEmptyInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalMenuException(INPUT_VALUE_MESSAGE);
        }
    }

    private static void validateNullInput(final String input) {
        if (input == null) {
            throw new IllegalMenuException(INPUT_VALUE_MESSAGE);
        }
    }
}