package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Participation;
import racingcar.model.Regex;

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

        Participation participation = new Participation(carName);

        Race race = new Race(participation);
        String winner = participation.getCars()
                .stream()
                .filter(car -> car.getLocation() == race.getWinnerLocation())
                .map(Car::getName)
                .map(Name::getNameValue)
                .collect(Collectors.joining(new Regex().getRegex()));

    }


}
