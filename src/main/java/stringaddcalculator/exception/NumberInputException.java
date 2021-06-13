package stringaddcalculator.exception;

public class NumberInputException extends RuntimeException {
    public NumberInputException() {
        super("잘못된 입력입니다.");
    }
}
