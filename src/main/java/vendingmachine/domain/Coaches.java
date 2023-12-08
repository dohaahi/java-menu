package vendingmachine.domain;

import static vendingmachine.validator.CoachValidator.validateCoach;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<String> names) {
        List<Coach> coaches = names.stream()
                .map(name -> Coach.from(name))
                .toList();

        validateCoach(coaches);

        this.coaches = coaches;
    }

    public static Coaches from(final List<String> names) {
        return new Coaches(names);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
