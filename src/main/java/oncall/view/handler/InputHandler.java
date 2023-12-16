package oncall.view.handler;

import java.util.function.Supplier;
import oncall.view.ErrorView;
import oncall.view.InputView;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public String receiveValidatedStartWorkDay() {
        return receiveValidatedInput(inputView::inputStartWorkDay);
    }

    public String receiveValidatedWeekDayEmployeeNames() {
        return receiveValidatedInput(inputView::inputWeekDayEmployeeNames);
    }

    public String receiveValidatedWeekendEmployeeNames() {
        return receiveValidatedInput(inputView::inputWeekendEmployeeNames);
    }
    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                ErrorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
