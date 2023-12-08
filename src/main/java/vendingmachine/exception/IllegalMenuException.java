package vendingmachine.exception;

public class IllegalMenuException extends IllegalArgumentException {
    public IllegalMenuException(final String message) {
        super(message);
    }
}