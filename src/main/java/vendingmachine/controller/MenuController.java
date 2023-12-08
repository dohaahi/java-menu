package vendingmachine.controller;

import static vendingmachine.util.RetryHandler.retryIfFailure;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Coach;
import vendingmachine.domain.Coaches;
import vendingmachine.domain.InedibleMenu;
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

        List<InedibleMenu> inedibleMenus = new ArrayList<>();
        for (Coach coach : coachesStorage) {
            inedibleMenus.add(retryIfFailure(() -> inputView.readMenu(coach.getName())));
        }

        for (int i = 0; i < coaches.getCoaches().size(); i++) {

        }

        // 2. 실행

        // 3. 출력
    }
}
