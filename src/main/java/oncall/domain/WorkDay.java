package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import oncall.constant.CommonValue;
import oncall.util.Separator;

public class WorkDay {
    private static final List<MonthDay> HOLIDAYS = List.of(
            MonthDay.of(1, 1),
            MonthDay.of(3, 1),
            MonthDay.of(5, 5),
            MonthDay.of(6, 6),
            MonthDay.of(8, 15),
            MonthDay.of(10, 3),
            MonthDay.of(10, 9),
            MonthDay.of(12, 25)
    );

    private LocalDate date;

    private WorkDay(LocalDate date) {
        this.date = date;
    }

    public static WorkDay from(String input) {
        String[] workDay = Separator.COMMA.split(input);
        int month = Integer.parseInt(workDay[CommonValue.MONTH_INDEX]);
        DayOfWeek startDay = getDayOfWeekEnumName(workDay[CommonValue.DAY_OF_WEEK_INDEX]);
        LocalDate startDate = LocalDate.of(Year.now().getValue(), month, 1)
                .with(TemporalAdjusters.firstInMonth(startDay));
        return new WorkDay(startDate);
    }

    private static DayOfWeek getDayOfWeekEnumName(String dayOfWeek) {
        if (dayOfWeek.equals("월")) {
            return DayOfWeek.MONDAY;
        }
        if (dayOfWeek.equals("화")) {
            return DayOfWeek.TUESDAY;
        }
        if (dayOfWeek.equals("수")) {
            return DayOfWeek.WEDNESDAY;
        }
        if (dayOfWeek.equals("목")) {
            return DayOfWeek.THURSDAY;
        }
        if (dayOfWeek.equals("금")) {
            return DayOfWeek.FRIDAY;
        }
        if (dayOfWeek.equals("토")) {
            return DayOfWeek.SATURDAY;
        }
        return DayOfWeek.SUNDAY;
    }

    public void nextDay() {
        int day = date.getDayOfMonth() + 1;
        int month = date.getMonthValue();
        int year = date.getYear();
        if ((month == 2 && day > 28) || (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11))
                || day > 31) {
            day = 1;
            month += 1;
            if (month > 12) {
                month = 1;
            }
        }
        date = LocalDate.of(year, month, day);
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isHoliday(LocalDate date) {
        return HOLIDAYS.contains(MonthDay.of(date.getMonth(), date.getDayOfMonth()));
    }

    public boolean isWeekend() {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public boolean isWeekDay(LocalDate date) {
        return !isHoliday(date) && !isWeekend();
    }

    public String getDayOfWeekByKorean() {
        if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            return "월";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
            return "화";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
            return "수";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
            return "목";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return "금";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return "토";
        }
        return "일";
    }
}
