package oncall.view;

import oncall.domain.Employees;
import oncall.domain.WorkDay;

public class OutputView {

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
                printScheduleFormat(workDay ,employees.getWeekendEmployeeNameBy());
            }
            if (workDay.isWeekDay()) {
                printScheduleFormat(workDay ,employees.getWeekdayEmployeeNameBy());
            }
            if (workDay.isHoliday()) {
                printHolidayScheduleFormat(workDay, employees.getWeekendEmployeeNameBy());
            }
            workDay.nextDay();
        }
    }

    private void printScheduleFormat(WorkDay workDay, String name) {
        System.out.printf("%d월 %d일 %s %s", workDay.getMonth(), workDay.getDay(), workDay.getDayOfWeekByKorean(), name);
        printNewLine();
    }

    private void printHolidayScheduleFormat(WorkDay workDay, String name) {
        System.out.printf("%d월 %d일 %s (휴일) %s", workDay.getMonth(), workDay.getDay(),
                workDay.getDayOfWeekByKorean(), name);
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }
}
