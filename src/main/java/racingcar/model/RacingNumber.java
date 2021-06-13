package racingcar.model;

import racingcar.exception.NumberFormatException;

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

    private int isNumber(String number) {
        validate(number);
        return Integer.parseInt(number);
    }

    private void validate(String number) {
        if (!Pattern.matches(this.pattern, number)) {
            throw new NumberFormatException();
        }
    }
}

