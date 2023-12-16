package oncall.view.validator;

import java.util.List;
import oncall.constant.ErrorMessage;
import oncall.util.Separator;

public class WeekendEmployeeValidator {

    private WeekendEmployeeValidator() {
    }

    public static void validate(String weekdayEmployees, String weekendEmployees) {
        List<String> weekday = List.of(Separator.COMMA.split(weekdayEmployees));
        List<String> weekend = List.of(Separator.COMMA.split(weekendEmployees));
        validateIsSameSize(weekday, weekend);
        validateIsSameIndex(weekday, weekend);
        validateHaveSameName(weekday, weekend);
    }

    private static void validateIsSameSize(List<String> weekday, List<String> weekend) {
        if (weekday.size() != weekend.size()) {
            throwError();
        }
    }

    private static void validateIsSameIndex(List<String> weekday, List<String> weekend) {
        for (int name = 0; name < weekday.size(); name++) {
            if (weekday.get(name).equals(weekend.get(name))) {
                throwError();
            }
        }
    }

    private static void validateHaveSameName(List<String> weekday, List<String> weekend) {
        for (String name : weekday) {
            if (!weekend.contains(name)) {
                throwError();
            }
        }
    }

    private static void throwError() {
        throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE);
    }
}
