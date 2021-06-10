package stringaddcalculator.exception;

public class NumberFormat extends RuntimeException {
    public NumberFormat() {
        super("잘못된 입력입니다.");
    }
}
