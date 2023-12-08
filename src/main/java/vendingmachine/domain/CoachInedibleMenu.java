package vendingmachine.domain;

public record CoachInedibleMenu(
        Coach coach,
        InedibleMenu inedibleMenu
) {
    public boolean isInedibleMenu(final String pickMenu) {
        return inedibleMenu.getMenus()
                .stream()
                .anyMatch(menu -> menu.contains(pickMenu));
    }
}