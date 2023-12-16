package oncall.controller;

import oncall.view.OutputView;
import oncall.view.handler.InputHandler;

public class WorkController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public WorkController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStartWorkDayInputMessage();
        String workDay = inputHandler.receiveValidatedStartWorkDay();
        outputView.printNewLine();

    }
}
