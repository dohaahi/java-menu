package menu.domain;

import static menu.validator.CoachValidator.validateCoach;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(final List<Coach> coaches) {
        validateCoach(coaches);

        return new Coaches(coaches);
    }
}