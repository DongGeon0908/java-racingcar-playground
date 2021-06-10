package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {

    @DisplayName("우승자_반환")
    @ParameterizedTest
    @CsvSource({
            "hel wqre wqdq",
            "msa wq q",
            "qq rr zz"
    })
    void getWinner(String input) {
        List<String> carName = Arrays.asList(input.split(" "));
        List<Car> cars = carName.stream().map(Car::new).collect(Collectors.toList());

        int acutal = cars.stream()
                .map(Car::getLocation)
                .max(Comparator.comparingInt(l -> l))
                .orElse(0);

        assertThat(acutal).isEqualTo(0);
    }


}
