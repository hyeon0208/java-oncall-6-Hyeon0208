package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.view.validator.EmployeeNameValidator;
import oncall.view.validator.WorkDayValidator;

public class InputView {

    public String inputStartWorkDay() {
        String workDay = Console.readLine();
        WorkDayValidator.validate(workDay);
        return workDay;
    }

    public String inputWeekDayEmployeeNames() {
        String names = Console.readLine();
        EmployeeNameValidator.validate(names);
        return names;
    }

    public String inputWeekendEmployeeNames() {
        String names = Console.readLine();
        EmployeeNameValidator.validate(names);
        return names;
    }
}
