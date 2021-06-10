package stringaddcalculator.model;


import stringaddcalculator.exception.NumberFormat;

import java.util.regex.Pattern;

public class Validation {
    private final String pattern = "^[0-9]*$";
    private final String PASS_VALIDATE = "PASS";
    private final int MIN_SIZE = 2;
    private final String input;

    public Validation(String input) {
        this.input = input;
    }

    public String validate() {
        isSize();
        if (isEmpty()) {
            return "0";
        }

        if (isOnlyNumber()) {
            return input;
        }
        return PASS_VALIDATE;
    }

    private void isSize() {
        if (input.length() < MIN_SIZE) {
            throw new NumberFormat();
        }
    }

    private boolean isEmpty() {
        return input == null || input.isEmpty();
    }

    private boolean isOnlyNumber() {
        return Pattern.matches(this.pattern, input);
    }

}

