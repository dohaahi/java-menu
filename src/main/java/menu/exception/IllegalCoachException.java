package menu.exception;

public class IllegalCoachException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 코치 이름입니다. 다시 입력해 주세요.";

    public IllegalCoachException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalCoachException(final String message) {
        super(message);
    }
}