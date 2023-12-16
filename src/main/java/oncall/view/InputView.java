package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.view.validator.WorkDayValidator;

public class InputView {

    public String inputStartWorkDay() {
        String workDay = Console.readLine();
        WorkDayValidator.validate(workDay);
        return workDay;
    }
}
