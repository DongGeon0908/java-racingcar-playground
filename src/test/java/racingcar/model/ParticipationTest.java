package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipationTest {

    @DisplayName("레이스_참여_진행")
    @Test
    void participate() {
        List<String> carName = Arrays.asList("fsdf,sads,wer".split(","));

        List<Car> cars = carName.stream().map(Car::new).collect(Collectors.toList());
        assertThat(cars.size()).isEqualTo(3);
    }


}
