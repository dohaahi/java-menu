package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static List<String> mapToStringList(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }
}