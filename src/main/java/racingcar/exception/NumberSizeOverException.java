package racingcar.exception;

public class NumberSizeOverException extends IllegalArgumentException {
    public NumberSizeOverException() {
        super("잘못된 입력입니다.");
    }
}
