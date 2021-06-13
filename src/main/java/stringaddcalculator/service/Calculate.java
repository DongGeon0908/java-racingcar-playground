package stringaddcalculator.service;


import stringaddcalculator.model.Number;

public class Calculate {
    public int add(Number number) {
        return number.getResultNumber()
                .stream()
                .mapToInt(n -> n)
                .sum();
    }
}
