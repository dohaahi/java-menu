package menu.exception;

public class IllegalInputException extends IllegalArgumentException {
    public IllegalInputException(final String message) {
        super(message);
    }
}