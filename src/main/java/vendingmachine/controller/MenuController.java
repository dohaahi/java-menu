package vendingmachine.controller;

import static vendingmachine.util.RetryHandler.retryIfFailure;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Coach;
import vendingmachine.domain.Coaches;
import vendingmachine.domain.Menu;
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
        Coaches coaches = retryIfFailure(inputView::readCoach);
        List<Coach> coachesStorage = coaches.getCoaches();

        List<Menu> menus = new ArrayList<>();
        for (Coach coach : coachesStorage) {
            menus.add(retryIfFailure(() -> inputView.readMenu(coach.getName())));
        }

        // 2. 실행


        // 3. 출력
    }
}
