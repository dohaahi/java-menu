package menu.controller;

import menu.domain.Coaches;
import menu.domain.MenuRecommendMachine;
import menu.view.InputView;

public class MenuController {
    private final MenuRecommendMachine machine = new MenuRecommendMachine();

    public void run() {
        // 1. 코치, 메뉴 입력
        Coaches coaches = InputView.readRecommendElement();

        // 2. 메뉴 추천
        machine.recommendFor(coaches);

        // 3. 추천 메뉴 출력
    }
}
