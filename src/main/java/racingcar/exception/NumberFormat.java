package racingcar.exception;

public class NumberFormat extends NumberFormatException {
    public NumberFormat() {
        super("잘못된 입력입니다.");
    }
}
