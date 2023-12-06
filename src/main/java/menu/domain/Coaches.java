package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(final List<String> names) {
        final List<Coach> coaches = new ArrayList<>();

        names.forEach(name -> {
            coaches.add(Coach.from(name));
        });

        return new Coaches(coaches);
    }
}
