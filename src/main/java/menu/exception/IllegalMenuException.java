package menu.exception;

public class IllegalMenuException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "메뉴 입력이 잘못되었습니다. 다시 입력해 주세요.";

    public IllegalMenuException() {
        super(EXCEPTION_MESSAGE);
    }
}