package oncall.view.validator;

import java.util.List;
import oncall.constant.CommonValue;
import oncall.constant.ErrorMessage;
import oncall.util.Separator;
import oncall.util.StringConvertor;

public class WorkDayValidator {
    private static final int MIN_MONTH_RANGE = 1;
    private static final int MAX_MONTH_RANGE = 12;
    private static final int INPUT_LIMIT_LENGTH = 2;
    private static final List<String> DAY_OF_WEEK_RANGE = List.of("일", "월", "화", "수", "목", "금", "토");

    private WorkDayValidator() {
    }

    public static void validate(String input) {
        validateComma(input);
        String[] workDay = Separator.COMMA.split(input);
        validateBlank(workDay);
        String month = workDay[CommonValue.MONTH_INDEX];
        String dayOfWeek = workDay[CommonValue.DAY_OF_WEEK_INDEX];
        validateMonthFormat(month);
        validateMonthRange(month);
        validateDayOfWeekRange(dayOfWeek);
    }

    private static void validateComma(String input) {
        if (!input.contains(Separator.COMMA.getSeparator())) {
            throwError();
        }
    }

    private static void validateBlank(String[] workDay) {
        for (String day : workDay) {
            if (day.isBlank()) {
                throwError();
            }
        }
    }

    private static void validateLength(String[] workDay) {
        if (workDay.length != INPUT_LIMIT_LENGTH) {
            throwError();
        }
    }

    private static void validateMonthFormat(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throwError();
        }
    }

    private static void validateMonthRange(String input) {
        int month = StringConvertor.convertToInt(input);
        if (month < MIN_MONTH_RANGE || month > MAX_MONTH_RANGE) {
            throwError();
        }
    }

    private static void validateDayOfWeekRange(String input) {
        if (!DAY_OF_WEEK_RANGE.contains(input)) {
            throwError();
        }
    }

    private static void throwError() {
        throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE);
    }
}
