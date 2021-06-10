package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Participation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final int ZERO = 0;
    private final List<Car> cars;

    public Race(List<String> carName) {
        this.cars = new Participation(carName).getParticipation();
    }

    public void proceed() {
        cars.forEach(car -> car.moveCar());
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinner() {
        return cars.stream()
                .filter(car -> car.getLocation() == getWinnerLocation())
                .map(car -> car.getName())
                .collect(Collectors.joining(Separator.REGEX));
    }

    private int getWinnerLocation() {
        return cars.stream()
                .map(Car::getLocation)
                .max(Comparator.comparingInt(l -> l))
                .orElse(ZERO);
    }
}
