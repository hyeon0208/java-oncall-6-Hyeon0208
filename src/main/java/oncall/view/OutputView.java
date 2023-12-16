package oncall.view;

import oncall.domain.Employees;
import oncall.domain.WorkDay;

public class OutputView {
    private int weekdayIndex;
    private int weekendIndex;

    public OutputView() {
        this.weekdayIndex = 0;
        this.weekendIndex = 0;
    }

    public void printStartWorkDayInputMessage() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printWeekDayWorkEmployeeNamesInputMessage() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printWeekendWorkEmployeeNamesInputMessage() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printWorkSchedule(WorkDay workDay, Employees employees) {
        for (int i = 0; i < employees.getEmployeeCount(); i++) {
            if (workDay.isWeekend()) {
                printWeekendScheduleFormat(workDay ,employees.getWeekendEmployeeNameBy(weekendIndex));
            }
            if (workDay.isWeekDay()) {
                printWeekDayScheduleFormat(workDay ,employees.getWeekdayEmployeeNameBy(weekdayIndex));
            }
            if (workDay.isHoliday()) {
                printHolidayScheduleFormat(workDay, employees.getWeekendEmployeeNameBy(weekendIndex));
            }
            workDay.nextDay();
        }
    }

    private void printWeekendScheduleFormat(WorkDay workDay, String name) {
        System.out.printf("%d월 %d일 %s %s", workDay.getMonth(), workDay.getDay(), workDay.getDayOfWeekByKorean(), name);
        weekendIndex++;
        printNewLine();
    }

    private void printWeekDayScheduleFormat(WorkDay workDay, String name) {
        System.out.printf("%d월 %d일 %s %s", workDay.getMonth(), workDay.getDay(), workDay.getDayOfWeekByKorean(), name);
        weekdayIndex++;
        printNewLine();
    }

    private void printHolidayScheduleFormat(WorkDay workDay, String name) {
        System.out.printf("%d월 %d일 %s (휴일) %s", workDay.getMonth(), workDay.getDay(),
                workDay.getDayOfWeekByKorean(), name);
        weekendIndex++;
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }
}
