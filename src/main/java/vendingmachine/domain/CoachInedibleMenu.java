package vendingmachine.domain;

public record CoachInedibleMenu(
        String name,
        InedibleMenu inedibleMenu
) {
    public boolean isInedibleMenu(final String pickMenu) {
        return inedibleMenu.getMenus()
                .stream()
                .anyMatch(menu -> menu.contains(pickMenu));
    }
}