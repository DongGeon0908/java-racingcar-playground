package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Participation;
import racingcar.model.Regex;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Race {
    private final int INIT = 0;
    private final Participation participation;

    public Race(Participation participation) {
        this.participation = participation;
    }

    public void proceed() {
        participation.getCars().forEach(Car::moveCar);
    }

    public Participation getParticipation() {
        return participation;
    }

    public String getWinner() {
        return participation.getCars()
                .stream()
                .filter(car -> car.getLocation() == getWinnerLocation())
                .map(Car::getName)
                .map(Name::getNameValue)
                .collect(Collectors.joining(new Regex().getRegex()));
    }

    public int getWinnerLocation() {
        return participation.getCars()
                .stream()
                .map(Car::getLocation)
                .max(Comparator.comparingInt(l -> l))
                .orElse(INIT);
    }
}
