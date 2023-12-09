package menu.domain;

import static menu.validator.CoachValidator.validateCoach;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    private Coaches(List<String> coachNames) {
        validateCoach(coachNames);

        List<Coach> coaches = coachNames.stream()
                .map(Coach::from)
                .toList();

        this.coaches = coaches;
    }

    public static Coaches from(final List<String> coachNames) {
        return new Coaches(coachNames);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
