package stringaddcalculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringaddcalculator.model.Number;
import stringaddcalculator.model.Separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculateTest {

    @DisplayName("더하기_연산")
    @ParameterizedTest
    @CsvSource({
            "1:2:3,6",
            "4:6,10",
            "1:2:3:4:5:6:7:8:9,45",
            "1:2:3:4:5:6:7:8:9,450"
    })
    void add(String input, int expect) {
        Separator separator = new Separator(input);

        Number number = new Number(separator);

        int actual = new Calculate().add(number);

        assertThat(actual).isEqualTo(expect);
    }

}
