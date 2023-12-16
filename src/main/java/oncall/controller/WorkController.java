package oncall.controller;

import oncall.domain.WorkDay;
import oncall.view.OutputView;
import oncall.view.handler.InputHandler;
import oncall.view.validator.WeekendEmployeeValidator;

public class WorkController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public WorkController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        WorkDay workDay = setUpWorkDay();

        setUpEmployees();
    }

    private WorkDay setUpWorkDay() {
        outputView.printStartWorkDayInputMessage();
        String workDay = inputHandler.receiveValidatedStartWorkDay();
        return WorkDay.from(workDay);
    }

    public void setUpEmployees() {
        try {
            outputView.printWeekDayWorkEmployeeNamesInputMessage();
            String weekDayEmployeeNames = inputHandler.receiveValidatedWeekDayEmployeeNames();
            outputView.printWeekendWorkEmployeeNamesInputMessage();
            String weekendEmployeeNames = inputHandler.receiveValidatedWeekendEmployeeNames();
            WeekendEmployeeValidator.validate(weekDayEmployeeNames, weekendEmployeeNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setUpEmployees();
        }
    }
}
