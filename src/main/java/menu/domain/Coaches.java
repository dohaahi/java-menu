package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import menu.validator.CoachValidator;

public class Coaches {
    final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        CoachValidator.validateCoach(coaches);
        this.coaches = coaches;
    }

    public static Coaches from(final List<String> input) {
        List<Coach> coaches = input.stream()
                .map(Coach::from)
                .collect(Collectors.toList());

        return new Coaches(coaches);
    }
}