package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import oncall.constant.CommonValue;
import oncall.constant.KoreanDayOfWeekMapper;
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
        return new WorkDay(createLocalDateFrom(workDay));
    }

    private static DayOfWeek getDayOfWeekEnumName(String dayOfWeek) {
        return KoreanDayOfWeekMapper.mapToDayOfWeekEnumName(dayOfWeek);
    }

    private static LocalDate createLocalDateFrom(String[] workDay) {
        int year = Year.now().getValue();
        int month = Integer.parseInt(workDay[CommonValue.MONTH_INDEX]);
        DayOfWeek startDay = getDayOfWeekEnumName(workDay[CommonValue.DAY_OF_WEEK_INDEX]);
        int day = startDay.getValue();
        return LocalDate.of(year, month, day).with(TemporalAdjusters.firstInMonth(startDay));
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

    public boolean isHoliday() {
        return HOLIDAYS.contains(MonthDay.of(date.getMonth(), date.getDayOfMonth()));
    }

    public boolean isWeekend() {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public boolean isWeekDay() {
        return !isHoliday() && !isWeekend();
    }

    public String getDayOfWeekByKorean() {
        return KoreanDayOfWeekMapper.mapToKoreanDayOfWeekName(date.getDayOfWeek());
    }
}
