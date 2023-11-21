package exception;

public class IllegalNameException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "코치의 이름 입력이 잘못되었습니다. 다시 입력해 주세요.";

    public IllegalNameException() {
        super(EXCEPTION_MESSAGE);
    }
}