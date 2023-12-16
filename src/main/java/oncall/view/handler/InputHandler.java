package oncall.view.handler;

import java.util.function.Supplier;
import oncall.view.ErrorView;
import oncall.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public String receiveValidatedStartWorkDay() {
        return receiveValidatedInput(inputView::inputStartWorkDay);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
