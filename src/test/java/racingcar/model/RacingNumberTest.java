package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.NumberFormat;

import java.util.regex.Pattern;

public class RacingNumberTest {
    private final String pattern = "^[0-9]*$";

    @DisplayName("숫자인지_검사")
    @ParameterizedTest
    @CsvSource({
            "123312",
            "2222",
            "das234"
    })
    void isNumber(String input) {
        if (!Pattern.matches(this.pattern, input)) {
            throw new NumberFormat();
        }
    }
}
