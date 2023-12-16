package oncall.constant;

import java.time.DayOfWeek;
import java.util.Map;

public class KoreanDayOfWeekMapper {
    public static final Map<DayOfWeek, String> DAY_OF_WEEK_TO_KOREAN = Map.of(
            DayOfWeek.MONDAY, "월",
            DayOfWeek.TUESDAY, "화",
            DayOfWeek.WEDNESDAY, "수",
            DayOfWeek.THURSDAY, "목",
            DayOfWeek.FRIDAY, "금",
            DayOfWeek.SATURDAY, "토",
            DayOfWeek.SUNDAY, "일"
    );
    public static final Map<String, DayOfWeek> STRING_TO_DAY_OF_WEEK = Map.of(
            "월", DayOfWeek.MONDAY,
            "화", DayOfWeek.TUESDAY,
            "수", DayOfWeek.WEDNESDAY,
            "목", DayOfWeek.THURSDAY,
            "금", DayOfWeek.FRIDAY,
            "토", DayOfWeek.SATURDAY,
            "일", DayOfWeek.SUNDAY
    );

    private KoreanDayOfWeekMapper() {
    }

    public static String mapToKoreanDayOfWeekName(DayOfWeek dayOfWeek) {
        return DAY_OF_WEEK_TO_KOREAN.get(dayOfWeek);
    }

    public static DayOfWeek mapToDayOfWeekEnumName(String dayOfWeek) {
        return STRING_TO_DAY_OF_WEEK.get(dayOfWeek);
    }
}
