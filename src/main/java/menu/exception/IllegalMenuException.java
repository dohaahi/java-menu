package menu.exception;

public class IllegalMenuException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 메뉴입니다. 다시 입력해 주세요.";

    public IllegalMenuException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalMenuException(final String message) {
        super(message);
    }
}