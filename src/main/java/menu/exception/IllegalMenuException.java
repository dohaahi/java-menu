package menu.exception;

public class IllegalMenuException extends IllegalArgumentException {
    private static final String RE_INPUT_MESSAGE = " 다시 입력해 주세요.";
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 XX입니다.";

    public IllegalMenuException() {
        super(EXCEPTION_MESSAGE + RE_INPUT_MESSAGE);
    }

    public IllegalMenuException(final String message) {
        super(message + RE_INPUT_MESSAGE);
    }
}