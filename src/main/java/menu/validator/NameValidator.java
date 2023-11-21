package menu.validator;

import static menu.view.InputView.NAME_DELIMITER;

import menu.exception.IllegalNameException;
import java.util.regex.Pattern;

public class NameValidator {
    private static final String NAME_REGEX = "^[가-힣]+(" + NAME_DELIMITER + "[가-힣]+)*$";

    public static void inputNameValidate(final String input) {
        validateNameEmpty(input);
        validateNameMatchedNameRegex(input);
        validateNameDelimiter(input);
    }

    private static void validateNameEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalNameException();
        }
    }

    private static void validateNameMatchedNameRegex(final String input) {
        if (!Pattern.matches(NAME_REGEX, input)) {
            throw new IllegalNameException();
        }
    }

    private static void validateNameDelimiter(final String input) {
        try {
            input.split(",");
        } catch (Exception exception) {
            throw new IllegalNameException();
        }
    }
}