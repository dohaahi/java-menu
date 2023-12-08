package vendingmachine.controller;

import static vendingmachine.util.RetryHandler.retryIfFailure;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Coach;
import vendingmachine.domain.CoachInedibleMenu;
import vendingmachine.domain.CoachHasInedibleMenus;
import vendingmachine.domain.Coaches;
import vendingmachine.domain.InedibleMenu;
import vendingmachine.domain.MenuMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

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
        System.out.println("점심 메뉴 추천을 시작합니다." + System.lineSeparator());
        CoachHasInedibleMenus coachHasInedibleMenus = generateCoachInedibleMenus();

        // 2. 실행
        machine.recommend(coachHasInedibleMenus);

        // 3. 출력
        outputView.printRecommendResult(machine.toRecommendResultDto());
    }

    private CoachHasInedibleMenus generateCoachInedibleMenus() {
        Coaches coaches = retryIfFailure(inputView::readCoach);
        List<Coach> coachesStorage = coaches.getCoaches();

        List<CoachInedibleMenu> coachInedibleMenus = new ArrayList<>();
        for (Coach coach : coachesStorage) {
            InedibleMenu inedibleMenu = retryIfFailure(() -> inputView.readMenu(coach.getName()));

            coachInedibleMenus.add(new CoachInedibleMenu(coach.getName(), inedibleMenu));
        }

        return CoachHasInedibleMenus.from(coachInedibleMenus);
    }
}
