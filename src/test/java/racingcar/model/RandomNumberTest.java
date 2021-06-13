package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {

    @DisplayName("난수_생성_검사")
    @Test
    void createRandom() {
        int actual = new RandomNumber().createRandom();
        assertThat(actual).isEqualTo(1);
    }
}
