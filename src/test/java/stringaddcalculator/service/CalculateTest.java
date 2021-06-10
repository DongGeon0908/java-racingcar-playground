package stringaddcalculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculateTest {

    @DisplayName("더하기_연산")
    @ParameterizedTest
    @CsvSource({
            "123,6",
            "46,10",
            "123456789,45"
    })
    void add(String input, String output) {
        int expect = Integer.parseInt(output);

        List<Integer> actual = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            actual.add(input.charAt(i) - '0');
        }

        assertThat(expect).isEqualTo(Calculate.add(actual));
    }
}
