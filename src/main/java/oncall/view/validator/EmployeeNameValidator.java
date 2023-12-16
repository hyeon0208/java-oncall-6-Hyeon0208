package oncall.view.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.constant.ErrorMessage;
import oncall.util.Separator;

public class EmployeeNameValidator {
    private static final int MIN_EMPLOYEE_COUNT = 5;
    private static final int MAX_EMPLOYEE_COUNT = 35;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private EmployeeNameValidator() {
    }

    public static void validate(String input) {
        validateComma(input);
        String[] employeeNames = Separator.COMMA.split(input);
        validateDuplication(employeeNames);
        validateEmployeeCount(employeeNames);
        validateNameLength(employeeNames);
        validateNameIsBlank(employeeNames);
        validateNameCondition(employeeNames);
    }

    private static void validateComma(String input) {
        if (!input.contains(Separator.COMMA.getSeparator())) {
            throwError();
        }
    }

    private static void validateDuplication(String[] employeeNames) {
        Set<String> employeeSet = new HashSet<>(List.of(employeeNames));
        if (employeeNames.length != employeeSet.size()) {
            throwError();
        }
    }

    private static void validateEmployeeCount(String[] employeeNames) {
        int employeeCount = employeeNames.length;
        if (employeeCount < MIN_EMPLOYEE_COUNT || employeeCount > MAX_EMPLOYEE_COUNT) {
            throwError();
        }
    }

    private static void validateNameLength(String[] employeeNames) {
        for (String employeeName : employeeNames) {
            int length = employeeName.length();
            if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
                throwError();
            }
        }
    }

    private static void validateNameIsBlank(String[] employeeNames) {
        for (String employeeName : employeeNames) {
            if (employeeName.isBlank()) {
                throwError();
            }
        }
    }

    private static void validateNameCondition(String[] employeeNames) {
        for (String employeeName : employeeNames) {
            if (!RegexPattern.NAME_CONDITION.matches(employeeName)) {
                throwError();
            }
        }
    }

    private static void throwError() {
        throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE);
    }
}
