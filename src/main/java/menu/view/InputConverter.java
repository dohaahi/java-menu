package menu.view;

import java.util.Arrays;
import java.util.List;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static List<String> mapToStringList(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .toList();
    }
}