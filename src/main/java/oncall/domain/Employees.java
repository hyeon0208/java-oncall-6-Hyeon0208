package oncall.domain;

import java.util.Collections;
import java.util.List;
import oncall.util.Separator;
import oncall.util.StringConvertor;

public class Employees {
    private List<String> weekday;
    private List<String> weekend;
    private String lastEmployeeName;
    private int weekdayIndex;
    private int weekendIndex;

    private Employees(List<String> weekday, List<String> weekend) {
        this.weekday = weekday;
        this.weekend = weekend;
        this.weekdayIndex = 0;
        this.weekendIndex = 0;
    }

    public static Employees of(String weekdayEmployeeNames, String weekendEmployeeNames) {
        List<String> weekdayEmployees = StringConvertor.convertStringArrToStringList(
                Separator.COMMA.split(weekdayEmployeeNames));
        List<String> weekendEmployees = StringConvertor.convertStringArrToStringList(
                Separator.COMMA.split(weekendEmployeeNames));
        return new Employees(weekdayEmployees, weekendEmployees);
    }

    public int getEmployeeCount() {
        return weekday.size();
    }

    public String getWeekdayEmployeeNameBy() {
        String currentEmployeeName = weekday.get(weekdayIndex);
        if (isWorkLast(currentEmployeeName)) {
            int nextIndex = (weekdayIndex + 1) % weekday.size();
            swapWeekdayEmployee(weekdayIndex, nextIndex);
            currentEmployeeName = weekday.get(weekdayIndex);
        }
        lastEmployeeName = currentEmployeeName;
        weekdayIndex = (weekdayIndex + 1) % weekday.size();
        return currentEmployeeName;
    }

    public String getWeekendEmployeeNameBy() {
        String currentEmployeeName = weekend.get(weekendIndex);
        if (isWorkLast(currentEmployeeName)) {
            int nextIndex = (weekendIndex + 1) % weekend.size();
            swapWeekendEmployee(weekendIndex, nextIndex);
            currentEmployeeName = weekend.get(weekendIndex);
        }
        lastEmployeeName = currentEmployeeName;
        weekendIndex = (weekendIndex + 1) % weekend.size();
        return currentEmployeeName;
    }

    private boolean isWorkLast(String currentEmployeeName) {
        return currentEmployeeName.equals(lastEmployeeName);
    }

    private void swapWeekdayEmployee(int index1, int index2) {
        Collections.swap(weekday, index1, index2);
    }

    private void swapWeekendEmployee(int index1, int index2) {
        Collections.swap(weekend, index1, index2);
    }
}
