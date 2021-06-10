package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Pattern;

public class RacingTest {

    @DisplayName("게임_동작_유효성")
    @ParameterizedTest
    @CsvSource({
            "123123",
            "223123",
            "2131213#231",
            "2:4ㅇㄴ"
    })
    void isNumber(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }
}
