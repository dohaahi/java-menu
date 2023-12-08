package vendingmachine.view;

import static vendingmachine.validator.CoachValidator.validateInputCoach;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import vendingmachine.domain.Coaches;

public class InputView {
    private static final String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요.(,로 구분)";
    private final InputConverter inputConverter = new InputConverter();

    public Coaches readCoach() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        String input = readLine();
        validateInputCoach(input);

        List<String> names = inputConverter.mapToStringList(input);

        return Coaches.from(names);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}