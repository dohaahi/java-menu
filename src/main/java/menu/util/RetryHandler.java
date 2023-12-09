package menu.util;

import java.util.function.Supplier;
import menu.IllegalMenuException;

public class RetryHandler {
    public static <T> T retryIfFailure(final Supplier<T> supplier) {
        int count = 0;

        while (count < 20) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage() + " 다시 입력해 주세요.");
            }
        }

        throw new IllegalMenuException("[ERROR] 시도횟수를 초과하였습니다. 프로그램을 재실행 해주세요.");
    }
}