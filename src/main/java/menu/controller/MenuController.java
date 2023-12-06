package menu.controller;

import menu.domain.Coaches;
import menu.domain.MenuMachine;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final MenuMachine machine = new MenuMachine();

    public void run() {
        // 1. 입력
        Coaches coaches = InputView.readCoaches();

        // 2. 실행
        machine.recommend(coaches);

        // 3. 출력
        OutputView.printRecommendMenu();
    }
}
