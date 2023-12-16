package oncall.domain;

import java.util.List;
import oncall.util.Separator;
import oncall.util.StringConvertor;

public class Employees {
    private final List<String> weekday;
    private final List<String> weekend;
    private int weekdayIndex;
    private int weekendIndex;

    private Employees(List<String> weekday, List<String> weekend) {
        this.weekday = weekday;
        this.weekend = weekend;
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
        return weekday.get(weekdayIndex++);
    }

    public String getWeekendEmployeeNameBy() {
        return weekend.get(weekendIndex++);
    }
}
