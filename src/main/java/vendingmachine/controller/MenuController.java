package vendingmachine.controller;

import vendingmachine.domain.Coaches;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 1. 입력
        Coaches coaches = inputView.readCoach();

        // 2. 실행

        // 3. 출력
    }
}
