package stringaddcalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationTest {

    @DisplayName("빈_문자열_또는_null_값_검증")
    @Test
    void isEmpty() {
        List<String> input = Arrays.asList(null, "");

        for (String index : input) {
            boolean actual = index == null || index.isEmpty();
            assertThat(actual).isTrue();
        }
    }

    @DisplayName("숫자만_입력된_경우")
    @ParameterizedTest
    @CsvSource({
            "312313",
            "123123123",
            "1254875667"
    })
    void isOnlyNumber(String input) {
        String pattern = "^[0-9]*$";
        boolean actual = Pattern.matches(pattern, input);
        assertThat(actual).isTrue();
    }

    @DisplayName("데이터_검증_PASS인지")
    @ParameterizedTest
    @CsvSource({
            "null",
            "123123123",
            "125487:5667",
            "dasdasdasd"
    })
    void isPass(String input) {
        String actual = new Validation(input).validate();
        assertThat(actual).isEqualTo("PASS");
    }
}

