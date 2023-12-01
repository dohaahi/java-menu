package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.validator.CoachValidator;

public class Coaches {
    final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        CoachValidator.validateCoach(coaches);
        this.coaches = coaches;
    }

    public static Coaches from(final List<String> coachNames, final List<Menu> menus) {
        List<Coach> coaches = new ArrayList<>();

        for (int count = 0; count < coachNames.size(); count++) {
            coaches.add(Coach.of(coachNames.get(count), menus.get(count)));
        }

        return new Coaches(coaches);
    }
}