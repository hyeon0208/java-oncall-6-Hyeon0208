package oncall.controller;

import oncall.domain.Employees;
import oncall.domain.WorkDay;
import oncall.view.ErrorView;
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
        Employees employees = setUpEmployees();
        showWorkSchedule(workDay, employees);
    }

    private WorkDay setUpWorkDay() {
        outputView.printStartWorkDayInputMessage();
        String workDay = inputHandler.receiveValidatedStartWorkDay();
        return WorkDay.from(workDay);
    }

    public Employees setUpEmployees() {
        try {
            outputView.printWeekDayWorkEmployeeNamesInputMessage();
            String weekDayEmployeeNames = inputHandler.receiveValidatedWeekDayEmployeeNames();
            outputView.printWeekendWorkEmployeeNamesInputMessage();
            String weekendEmployeeNames = inputHandler.receiveValidatedWeekendEmployeeNames();
            WeekendEmployeeValidator.validate(weekDayEmployeeNames, weekendEmployeeNames);
            return Employees.of(weekDayEmployeeNames, weekendEmployeeNames);
        } catch (IllegalArgumentException exception) {
            ErrorView.printErrorMessage(exception.getMessage());
            return setUpEmployees();
        }
    }

    public void showWorkSchedule(WorkDay workDay, Employees employees) {
        outputView.printNewLine();
        outputView.printWorkSchedule(workDay, employees);
    }
}
