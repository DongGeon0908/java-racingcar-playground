package stringaddcalculator.model;

import java.util.List;
import java.util.stream.Collectors;

public class Numeral {

    private final List<String> number;
    private final List<Integer> resultNumber;

    public Numeral(List<String> values) {
        this.number = values;
        isNumber();
        resultNumber = parseNumber();
    }

    public List<Integer> getResultNumber() {
        return this.resultNumber;
    }

    private List<Integer> parseNumber() {
        return number.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void isNumber() {
        number.forEach(this::isNumberOne);
    }

    private void isNumberOne(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

}
