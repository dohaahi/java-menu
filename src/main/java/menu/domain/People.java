package menu.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class People {

    private final List<Person> people = new ArrayList<>();

    public People(final List<String> names) {
        // 검증
        // 1. 코치 인원수
        names.forEach(name -> {
            people.add(Person.of(name));
        });

        this.people = people;
    }
}