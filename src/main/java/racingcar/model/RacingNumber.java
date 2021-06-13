package racingcar.model;

import racingcar.exception.NumberFormat;

import java.util.regex.Pattern;

public class RacingNumber {
    private final String pattern = "^[0-9]*$";
    private final int racingNumber;

    public RacingNumber(String number) {
        this.racingNumber = isNumber(number);
    }

    public int getRacingNumber() {
        return racingNumber;
    }

    // 이상함... Validate 메소드를 만들자. (두가지 역함을 가지고 있음)
    private int isNumber(String number) {
        if (Pattern.matches(this.pattern, number)) {
            return Integer.parseInt(number);
        }
        throw new NumberFormat();
    }
}

