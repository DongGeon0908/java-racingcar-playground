package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeparatorTest {

    @DisplayName("입력값_구분자_분리")
    @Test
    void separatedName() {

        List<String> actual = Arrays.asList("1,2,3".split(","));

        assertThat(3).isEqualTo(actual.size());
    }

}
