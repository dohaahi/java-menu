package vendingmachine.view;

import java.util.Arrays;
import java.util.List;

public class InputConverter {
    private static final String DELIMITER = ",";

    public List<String> mapToStringList(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .toList();
    }
}