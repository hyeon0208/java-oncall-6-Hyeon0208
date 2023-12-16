package oncall.view;

public class OutputView {

    public void printStartWorkDayInputMessage() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printWeekDayWorkEmployeeNamesInputMessage() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printWeekendWorkEmployeeNamesInputMessage() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printNewLine() {
        System.out.println();
    }
}
