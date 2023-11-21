package menu.exception;

public class IllegalNameException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "코치의 이름이 잘못 입력되었습니다. 다시 입력해 주세요.";

    public IllegalNameException() {
        super(EXCEPTION_MESSAGE);
    }
}