package menu.domain;

public class Coach {
    private final String name;
    private InedibleMenu menus;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }

    public void addInedibleMenu(final InedibleMenu menus) {
        this.menus = menus;
    }

    public String getName() {
        return name;
    }
}
