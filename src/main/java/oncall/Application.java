package oncall;

import oncall.controller.WorkController;
import oncall.view.ErrorView;
import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = initHandler();
        OutputView outputView = new OutputView();
        WorkController controller = new WorkController(inputHandler, outputView);
        controller.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return new InputHandler(inputView, errorView);
    }
}
