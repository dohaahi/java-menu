package menu.validator;

import static menu.view.InputView.MENU_DELIMITER;

import exception.IllegalMenuException;
import java.util.regex.Pattern;

public class MenuValidator {
    private static final String MENU_REGEX = "^[가-힣]+(" + MENU_DELIMITER + "[가-힣]+)*$";

    public static void inputMenuValidate(final String input) {
        validateMenuMatchedMenuRegex(input);
    }

    private static void validateMenuMatchedMenuRegex(final String input) {
        if (input.isBlank()) {
            return;
        }

        if (!Pattern.matches(MENU_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }
}