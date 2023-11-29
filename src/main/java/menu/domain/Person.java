package menu.domain;

import java.util.List;

public class Person {
    private final String name;
    private final List<String> menus;

    private Person(final String name, final List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public static Person of(final String name, final List<String> menus) {
        // 이름 검증
        return new Person(name, menus);
    }
}
