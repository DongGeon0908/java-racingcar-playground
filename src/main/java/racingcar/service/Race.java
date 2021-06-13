package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Participation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final int ZERO = 0;
    private final List<Car> cars; // new Participation(carName) >>> 이거를 통해서

    public Race(List<String> carName) {
        this.cars = new Participation(carName).getParticipation(); // List<Car>로 또 받아옴...
    }

    public void proceed() {
        cars.forEach(Car::moveCar); // :: 공부하기...
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinner() {
        return cars.stream()
                .filter(car -> car.getLocation() == getWinnerLocation())
                .map(car -> car.getName())
                .collect(Collectors.joining(Separator.REGEX)); // 값을 받아서..
    }

    private int getWinnerLocation() {
        return cars.stream()
                .map(Car::getLocation)
                .max(Comparator.comparingInt(l -> l))
                .orElse(ZERO);
    }
}
