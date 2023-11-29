package menu.domain;

public class Coach {
    private final String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }
}