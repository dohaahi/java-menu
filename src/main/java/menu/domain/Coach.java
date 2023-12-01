package menu.domain;


public class Coach {
    private final String name;
    private final Menu menu;

    public Coach(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
    }

    public static Coach of(final String name, final Menu menu) {
        return new Coach(name, menu);
    }
}