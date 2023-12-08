package vendingmachine.domain;

public class MenuMachine {
    public void recommend() {
        MenuCategory pickCategory = MenuCategory.pickCategory();
        String pickMenu = Menu.pickMenu(pickCategory);


    }

    private void validatePickMenu(final String pickMenu) {
        // 코치가 못 먹는 메뉴인지
        // 이미 추천한 메뉴인지
        // 카테고리가 이미 2번이나 추천되었는지
    }
}
