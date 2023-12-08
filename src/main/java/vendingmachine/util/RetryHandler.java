package vendingmachine.util;

import java.util.function.Supplier;

public class RetryHandler {
    private static final String RE_INPUT_MESSAGE = " 다시 입력해 주세요.";

    public static <T> T retryIfFailure(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage() + RE_INPUT_MESSAGE);
            }
        }
    }
}