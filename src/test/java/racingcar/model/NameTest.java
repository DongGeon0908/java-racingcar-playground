package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.NumberSizeOverException;


public class NameTest {
    @DisplayName("사용자_입력_5초과")
    @ParameterizedTest
    @CsvSource({
            "asdasd",
            "asdasdd",
            "asdd"
    })
    void validate(String input) {
        if (input.length() > 5) {
            throw new NumberSizeOverException();
        }
    }
}
