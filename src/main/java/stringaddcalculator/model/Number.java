package stringaddcalculator.model;


import stringaddcalculator.exception.NumberInputException;

import java.util.List;
import java.util.stream.Collectors;


public class Number {
    private final List<Integer> resultNumber;

    public Number(Separator separator) {
        isNumber(separator);
        this.resultNumber = parseNumber(separator);
    }

    public List<Integer> getResultNumber() {
        return this.resultNumber;
    }

    private List<Integer> parseNumber(Separator separator) {
        return separator.values()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void isNumber(Separator separator) {
        separator.values().forEach(this::isNumberOne);
    }

    private void isNumberOne(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NumberInputException();
        }
    }

}
