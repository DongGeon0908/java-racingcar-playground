package stringaddcalculator.model;

import java.util.regex.Pattern;

public class Validation {
    private final String pattern = "^[0-9]*$";
    private final String PASS_VALIDATE = "PASS";
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
        if (input.length() < 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isEmpty() {
        return input == null || input.isEmpty();
    }

    private boolean isOnlyNumber() {
        return Pattern.matches(this.pattern, input);
    }

}

