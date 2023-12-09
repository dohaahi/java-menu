package menu.controller;

import static menu.util.RetryHandler.retryIfFailure;

import menu.domain.Coaches;
import menu.domain.InedibleMenu;
import menu.domain.MenuMachine;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuMachine machine = new MenuMachine();

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 1. 입력
        System.out.println("점심 메뉴 추천을 시작합니다.");
        Coaches coaches = generateCoaches();

        // 2. 실행
        machine.recommend(coaches);

        // 3. 출력
        outputView.printRecommendResult(machine.toRecommendResultDto(coaches));
    }

    private Coaches generateCoaches() {
        Coaches coaches = retryIfFailure(inputView::readCoachNames);
        coaches.getCoaches()
                .forEach(coach -> {
                    InedibleMenu menu = retryIfFailure(() -> inputView.readMenu(coach.getName()));
                    coach.addInedibleMenu(menu);
                });

        return coaches;
    }
}
