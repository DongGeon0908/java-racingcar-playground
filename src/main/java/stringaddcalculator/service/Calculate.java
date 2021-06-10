package stringaddcalculator.service;

import java.util.List;

public class Calculate {
    public static int add(List<Integer> number) {
        return number.stream().mapToInt(n -> n).sum();
    }
}
