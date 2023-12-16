package oncall.controller;

import java.time.LocalDate;
import oncall.domain.WorkDay;
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
        WorkDay from = WorkDay.from(workDay);
        System.out.println(from.getDate());
        for (int i = 0; i < 40; i++) {
            from.nextDay();
            LocalDate date = from.getDate();
            System.out.println(date);
            System.out.println("휴일 ? : " + from.isHoliday(date));
            System.out.println("평일 ? : " + from.isWeekDay(date));
        }


        outputView.printWeekDayWorkEmployeeNamesInputMessage();
        String weekDayEmployeeNames = inputHandler.receiveValidatedWeekDayEmployeeNames();

        outputView.printWeekendWorkEmployeeNamesInputMessage();
        String weekendEmployeeNames = inputHandler.receiveValidatedWeekendEmployeeNames(weekDayEmployeeNames);


    }
}
