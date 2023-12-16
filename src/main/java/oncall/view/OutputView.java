package oncall.view;

import java.time.LocalDate;
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
        int weekdayIndex = 0;
        int weekendIndex = 0;
        for (int i = 0; i < employees.getEmployeeCount(); i++) {
            LocalDate date = workDay.getDate();
            if (workDay.isWeekend()) {
                System.out.printf("%d월 %d일 %s %s\n", date.getMonthValue(), date.getDayOfMonth(), workDay.getDayOfWeekByKorean(),
                        employees.getWeekendEmployeeNameBy(weekendIndex));
                weekendIndex++;
            }
            if (workDay.isWeekDay(date)) {
                System.out.printf("%d월 %d일 %s %s\n", date.getMonthValue(), date.getDayOfMonth(), workDay.getDayOfWeekByKorean(),
                        employees.getWeekdayEmployeeNameBy(weekdayIndex));
                weekdayIndex++;
            }
            if (workDay.isHoliday(date)) {
                System.out.printf("%d월 %d일 %s (휴일) %s\n", date.getMonthValue(), date.getDayOfMonth(), workDay.getDayOfWeekByKorean(),
                        employees.getWeekendEmployeeNameBy(weekendIndex));
                weekendIndex++;
            }
            workDay.nextDay();
        }
    }


    public void printNewLine() {
        System.out.println();
    }
}
