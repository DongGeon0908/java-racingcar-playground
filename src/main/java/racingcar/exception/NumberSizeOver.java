package racingcar.exception;

public class NumberSizeOver extends IllegalArgumentException {
    public NumberSizeOver() {
        super("잘못된 입력입니다.");
    }
}
