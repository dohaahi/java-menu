package menu.controller;

import menu.domain.UserPreferences;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        UserPreferences userPreferences = inputView.readUserPreferences();
    }
}
